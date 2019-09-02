package jyh.test.android.ex_0611_openapi;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Parser {
    //웹에서 요소(제목, 저자, 가격등...)를 검색하여 준비해둔 vo객체(BookModel)에 저장

    BookModel vo;
    String myQuery = "";//검색어

    //통신
    public ArrayList<BookModel> connectNaver( ArrayList<BookModel> list ){

        try {

            //검색어를 서버에 요청할때 한글깨짐 방지
            myQuery = URLEncoder.encode( NaverActivity.search.getText().toString(), "utf8" );
            int count = 10;//검색결과 10건
            String urlStr = "https://openapi.naver.com/v1/search/book.xml?query=" + myQuery + "&start=1&display="+count;

            URL url = new URL( urlStr );

            //url클래스의 연결 정보를 connection에 전달
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            //네이버 책API는 기본으로 GET을 요청방식으로 한다.
            connection.setRequestMethod( "GET" );

            //발급받은 ID
            connection.setRequestProperty( "X-Naver-Client-Id", "JzJh9D9GG3DHKj4_082Y" );

            //발급받은 secret
            connection.setRequestProperty( "X-Naver-Client-Secret", "L2XdxFsYD3" );

            //인증을 받은 url을 수행하여 자원을 파싱(xml에 대입)할 객체를 준비
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput( connection.getInputStream(), null );

            //파서를 통해서 검색된 요소를 반복수행처리
            int parserEvent = parser.getEventType();

            while( parserEvent != XmlPullParser.END_DOCUMENT ){

                //시작태그를 찾아서 이름을 알아낸다.
                if( parserEvent == XmlPullParser.START_TAG ){

                    String tagName = parser.getName();

                    if( tagName.equalsIgnoreCase("title") ){
                        vo = new BookModel();
                        String title = parser.nextText();
                        vo.setB_title( title );

                    }else if( tagName.equalsIgnoreCase("image") ){
                        String img = parser.nextText();
                        vo.setB_img( img );

                    }else if( tagName.equalsIgnoreCase("author") ){
                        String author = parser.nextText();
                        vo.setB_author( author );

                    }else if( tagName.equalsIgnoreCase("price") ){
                        String price = parser.nextText();
                        vo.setB_price( price );
                        list.add(vo);

                    }

                }

                parserEvent = parser.next();//다음요소로 이동

            }//while

        }catch (Exception e){


        }

        return list;

    }//connectNaver()

}





















































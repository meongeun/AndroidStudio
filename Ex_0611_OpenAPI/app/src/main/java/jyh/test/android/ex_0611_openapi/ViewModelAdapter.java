package jyh.test.android.ex_0611_openapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;

public class ViewModelAdapter extends ArrayAdapter<BookModel>{

    Context context;
    ArrayList<BookModel> list;
    BookModel vo;
    int resource;

    public ViewModelAdapter(Context context, int resource, ArrayList<BookModel> list, ListView myListView) {
        super(context, resource, list);

        this.context = context;
        this.resource = resource;
        this.list = list;

        myListView.setOnItemClickListener( itemClick );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater linf = (LayoutInflater)context.getSystemService(
                                            Context.LAYOUT_INFLATER_SERVICE );

        convertView = linf.inflate( resource, null );

        vo = list.get( position );

        TextView title = convertView.findViewById( R.id.book_title );
        TextView author = convertView.findViewById( R.id.book_author );
        TextView price = convertView.findViewById( R.id.book_price );
        ImageView img = convertView.findViewById( R.id.book_img );

        title.setText( "제목 : " + vo.getB_title() );
        author.setText( "저자 : " + vo.getB_author() );
        price.setText( "가격 : " + vo.getB_price() );

        //이미지 로드
        new ImgAsync(img, vo).execute();

        return convertView;
    }//getView()

    class ImgAsync extends AsyncTask<String, String, Bitmap>{

        Bitmap bm;
        ImageView mImg;
        BookModel vo;

        public ImgAsync(ImageView mImg, BookModel vo) {
            this.mImg = mImg;
            this.vo = vo;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {

                URL img_url = new URL( vo.getB_img() );

                //위의 url경로를 통해 inputStream으로 이미지를 로드
                BufferedInputStream bis = new BufferedInputStream( img_url.openStream() );

                //얻어온 스트림으로부터 Bitmap객체 생성
                bm = BitmapFactory.decodeStream( bis );

                bis.close();

            }catch (Exception e){


            }

            if( bm != null ){
                return bm;

            }else{
                //웹에서 이미지를 가져오는데 실패했다면, 기본 이미지를 반환
                Bitmap bitmap = BitmapFactory.decodeResource(
                        context.getResources(), R.mipmap.ic_launcher );
                return bitmap;
            }
        }//doInBackground()

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            //이미지뷰에 bitmap객체를 세팅
            mImg.setImageBitmap( bitmap );
        }
    }//ImgAsync

    //리스트뷰 항목 클릭 감지자
    AdapterView.OnItemClickListener itemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String bookImg = list.get(position).getB_img();

            //서버에서 가져온 이미지의 경로에서 bid만 추출
            String bookId = bookImg.substring(
                    bookImg.lastIndexOf('/')+1,
                    bookImg.lastIndexOf(".jpg"));

            //추출한 bid로 부터 상세정보 페이지로 연결할 url준비
            String bookLink = "http://book.naver.com/bookdb/book_detail.nhn?bid=" + bookId;

            Intent intent = new Intent( Intent.ACTION_VIEW );
            intent.setData( Uri.parse(bookLink) );
            context.startActivity( intent );

        }
    };

}













package com.example.moviefinder;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.EventLogTags;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Pager1 extends Fragment {

    ImageView mImage;
    TextView mTitle, mBook, mAge;
    Button btnDetail1;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Description().execute();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_pager1,container,false);

        mImage =(ImageView)layout.findViewById(R.id.imageView_img);
        mTitle =(TextView)layout.findViewById(R.id.textView_title);

        mAge = (TextView)layout.findViewById(R.id.textView_age);
        mBook =(TextView)layout.findViewById(R.id.textView_reserve);
        btnDetail1 = (Button)layout.findViewById(R.id.btnDetail1);
        btnDetail1.setOnClickListener(click);
        return layout;
    }

    private class Description extends AsyncTask<Void, Void, Void>{
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("잠시 기다려 주세요.");
            progressDialog.show();;
        }

        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
                Elements mElementDataSize = doc.select("ul[class=lst_detail_t1]").select("li"); //필요한 녀석만 꼬집어서 지정
                int mElementSize = mElementDataSize.size(); //목록이 몇개인지 알아낸다. 그만큼 루프를 돌려야 하나깐.

                for(Element elem : mElementDataSize){ //이렇게 요긴한 기능이
                    //영화목록 <li> 에서 다시 원하는 데이터를 추출해 낸다.
                    String my_title = elem.select("li dt[class=tit] a").text();
                    String my_link = elem.select("li div[class=thumb] a").attr("href");
                    String my_imgUrl = elem.select("li div[class=thumb] a img").attr("src");
                    //특정하기 힘들다... 저 앞에 있는집의 오른쪽으로 두번째집의 건너집이 바로 우리집이야 하는 식이다.
                    Element rElem = elem.select("dl[class=info_txt1] dt").next().first();
                    String my_release = rElem.select("dd").text();
                    Element dElem = elem.select("dt[class=tit_t2]").next().first();
                    String my_director = "감독: " + dElem.select("a").text();
                    //Log.d("test", "test" + mTitle);
                    //ArrayList에 계속 추가한다.
                    mTitle.setText(my_title);
                    mBook.setText(my_release);
                    mAge.setText(my_director);

                }

                //추출한 전체 <li> 출력해 보자.
                Log.d("debug :", "List " + mElementDataSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


    }

    public Pager1(){

    }



    View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    };
}

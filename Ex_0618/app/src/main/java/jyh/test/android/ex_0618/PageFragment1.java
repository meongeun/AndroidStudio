package jyh.test.android.ex_0618;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PageFragment1 extends Fragment {

    Button btn1, btn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout)inflater.inflate(
                                R.layout.fragment_page_fragment1, container, false );

        btn1 = layout.findViewById( R.id.btn1 );
        btn2 = layout.findViewById( R.id.btn2 );

        btn1.setOnClickListener( click );
        btn2.setOnClickListener( click );
        return layout;
    }//onCreateView()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn1:
                    Toast.makeText( getContext(), "btn1 클릭", Toast.LENGTH_SHORT ).show();
                    break;

                case R.id.btn2:
                    Toast.makeText( getActivity(), "btn1 클릭", Toast.LENGTH_SHORT ).show();
                    break;

            }//switch

        }
    };

}



























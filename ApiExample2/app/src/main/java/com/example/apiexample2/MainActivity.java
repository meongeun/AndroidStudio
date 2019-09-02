package com.example.apiexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = "MainActivity";

    @BindView(R.id.link) TextView mLink;
    @BindView(R.id.body_result) TextView bodyResultTextView;
    @BindView(R.id.code_result) TextView codeResultTextView;
    @BindView(R.id.id_result) TextView idResultTextView;
    @BindView(R.id.userid_result) TextView useridResultTextView;
    @BindView(R.id.title_result) TextView titleResultTextView;
    RetroClient retroClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        retroClient = RetroClient.getInstance(this).createBaseApi();
        mLink.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @OnClick(R.id.get1)
    void get1(){
        Toast.makeText(this, "GET 1 Clicked", Toast.LENGTH_SHORT).show();
        retroClient.getFirst("1", new RetroCallback() {
            @Override
            public void onSuccess(int code, Object receivedData) {
                ResponseGet data = (ResponseGet) receivedData;
                codeResultTextView.setText(String.valueOf(code));
                idResultTextView.setText(String.valueOf(data.id));
                titleResultTextView.setText(data.title);
                useridResultTextView.setText(String.valueOf(data.userId));
                bodyResultTextView.setText(data.body);
            }

            @Override
            public void onError(Throwable t) {
                Log.e(LOG, t.toString());
                codeResultTextView.setText("Error");
                idResultTextView.setText("Error");
                titleResultTextView.setText("Error");
                useridResultTextView.setText("Error");
                bodyResultTextView.setText("Error");
            }

            @Override
            public void onFailure(int code) {
                codeResultTextView.setText(code);
                idResultTextView.setText("Failure");
                titleResultTextView.setText("Failure");
                useridResultTextView.setText("Failure");
                bodyResultTextView.setText("Failure");
            }
        });
    }
}

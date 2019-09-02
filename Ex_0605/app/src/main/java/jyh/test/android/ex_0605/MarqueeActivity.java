package jyh.test.android.ex_0605;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MarqueeActivity extends AppCompatActivity {

    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marquee);

        t1 = findViewById(R.id.t1);
        t1.setSelected( true );

        t2 = findViewById(R.id.t2);
        t2.setSelected( true );

    }
}

































































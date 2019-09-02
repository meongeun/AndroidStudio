package jyh.test.android.ex_0626;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

public class SweetAlertActivity extends AppCompatActivity {

    SweetAlertDialog sweetAlertDialog;
    Button btn_default, btn_warning, btn_error, btn_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_alert);

        btn_default = findViewById(R.id.btn_default);
        btn_warning = findViewById(R.id.btn_warning);
        btn_error = findViewById(R.id.btn_error);
        btn_success = findViewById(R.id.btn_success);

        btn_default.setOnClickListener( click );
        btn_warning.setOnClickListener( click );
        btn_error.setOnClickListener( click );
        btn_success.setOnClickListener( click );

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch( v.getId() ){

                case R.id.btn_default://기본버튼
                    sweetAlertDialog = new SweetAlertDialog(
                            SweetAlertActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE );

                    sweetAlertDialog.setTitleText("dialog title");
                    sweetAlertDialog.setContentText( "앱을 종료하시겠습니까?" );
                    sweetAlertDialog.setCustomImage( R.mipmap.ic_launcher_round );
                    sweetAlertDialog.setConfirmText("확인");
                    sweetAlertDialog.setCancelText("취소");

                    //취소버튼에 이벤트 감지자 등록
                    sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            //다이얼로그 종료
                            sweetAlertDialog.dismiss();
                        }
                    });

                    //확인버튼에 이벤트 감지자 등록
                    sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            finish();
                        }
                    });

                    sweetAlertDialog.show();
                    break;

                case R.id.btn_warning://경고타입
                    sweetAlert( "사용자 등록을 먼저 해주세요",
                                getString( R.string.alert_warning ),
                                SweetAlertDialog.WARNING_TYPE,
                                SweetAlertActivity.this);
                    break;

                case R.id.btn_error://오류타입
                    sweetAlert( "등록되지 않은 사용자",
                                getString( R.string.alert_error ),
                                SweetAlertDialog.ERROR_TYPE,
                                SweetAlertActivity.this);
                    break;

                case R.id.btn_success://성공타입
                    sweetAlert( "등록성공",
                                getString(R.string.alert_success),
                                SweetAlertDialog.SUCCESS_TYPE,
                                SweetAlertActivity.this);
                    break;

            }//switch

        }
    };

    //타입별 다이얼로그 호출 메서드
    private void sweetAlert(String msg, String title, int msgType, final Context context){

        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog( context, msgType );
        sweetAlertDialog.setTitleText( title );
        sweetAlertDialog.setContentText( msg );
        sweetAlertDialog.setConfirmText( "확인" );

        sweetAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                //다이얼로그가 종료되면서 수행할 작업
                Toast.makeText( context, "확인", Toast.LENGTH_SHORT ).show();
            }
        });

        sweetAlertDialog.show();
    }//sweetAlert()

}











































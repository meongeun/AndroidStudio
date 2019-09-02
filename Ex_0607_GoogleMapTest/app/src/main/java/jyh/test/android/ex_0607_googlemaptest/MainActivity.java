package jyh.test.android.ex_0607_googlemaptest;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    //위도 경도
    double latitude, longitude;

    //위치정보 확인 및 관리를 위한 객체
    LocationManager l_manager;
    Location location;

    //위도와 경도를 저장하는 포지션 객체
    static LatLng MY_POSITON = null;
    //Marker marker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l_manager = (LocationManager)getSystemService( LOCATION_SERVICE );
        location = l_manager.getLastKnownLocation( LocationManager.GPS_PROVIDER );

        latitude = location.getLatitude();//위도
        longitude = location.getLongitude();//경도

        MY_POSITON = new LatLng( latitude, longitude );

        //mapFragment를 생성하여 첫 실행시 onMapReady()를 호출
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById( R.id.map );
        mapFragment.getMapAsync( this );

    }//onCreate()

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //위도, 경도 위치로 카메라 이동
        googleMap.moveCamera( CameraUpdateFactory.newLatLng( MY_POSITON ) );

        //구글지도의 축척은 1 ~ 23까지 지정가능
        //숫자가 클 수록 확대범위가 넓음
        CameraUpdate zoom = CameraUpdateFactory.zoomTo( 17 );
        googleMap.animateCamera( zoom );

        //marker표시
        MarkerOptions marker = new MarkerOptions();
        marker.position( MY_POSITON ).title( getAddress( latitude, longitude ) );
        googleMap.addMarker( marker ).showInfoWindow();//생성한 마커를 화면에 출력

    }//onMapReady()

    //위도, 경도를 기반으로 주소를 반환하는 메서드
    private String getAddress( double lat, double lng ){

        String address = null;

        //위치 정보를 활용하기 위한 구글 api객체
        Geocoder geocoder = new Geocoder(
                MainActivity.this, Locale.getDefault());

        //주소 목록을 담기 위한 List
        List<Address> list = null;


        try {
            //주소 목록을 가져온다. ( 위도, 경도, 조회 갯수 )
            list = geocoder.getFromLocation( lat, lng, 1 );
        } catch (IOException e) {
            e.printStackTrace();
        }

        if( list == null ){
            Toast.makeText( getApplicationContext(),
                            "주소데이터를 얻어오는데 실패했습니다.",
                            Toast.LENGTH_SHORT).show();
            return null;
        }

        Address addr = list.get(0);
        address = addr.getCountryName() + " "  //대한민국
                  + addr.getLocality() + " " //서울
                  + addr.getThoroughfare() + " " //노고산동
                  + addr.getFeatureName(); //111-2

        return address;

    }//getAddress()

}













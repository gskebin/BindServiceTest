package kr.co.dunet.app.bindservicetest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyService ms;
    boolean isService = false;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder mb = (MyService.MyBinder) service;
            ms = mb.getService();
            isService =true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isService = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void BtnStartService(View v){
        Toast.makeText(getApplicationContext() , "서비스시작" , Toast.LENGTH_LONG).show();
        bindService(new Intent(MainActivity.this, MyService.class),connection, Context.BIND_AUTO_CREATE);
    }
    public void BtnStopService(View v){
        if(connection !=null){
        unbindService(connection);
        Toast.makeText(getApplicationContext() , "서비스종료" , Toast.LENGTH_LONG).show();

        }
//        return;
    }
    public void BtnReceive(View v){
        if(isService){
            Toast.makeText(getApplicationContext() , "서비스중 받아온 데이터 " + ms.getRanNum() , Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(getApplicationContext() , "서비스중 아님" , Toast.LENGTH_LONG).show();
            return ;
        }
    }
}

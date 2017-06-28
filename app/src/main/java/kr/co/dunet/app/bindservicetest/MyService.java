package kr.co.dunet.app.bindservicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Random;

public class MyService extends Service {


    IBinder iBinder = new MyBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return iBinder;
    }

    class MyBinder extends Binder{

        MyService getService(){
            return MyService.this;
        }
    }

    int getRanNum(){
        return new Random().nextInt();
    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext() , "onCreate 시작" , Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}

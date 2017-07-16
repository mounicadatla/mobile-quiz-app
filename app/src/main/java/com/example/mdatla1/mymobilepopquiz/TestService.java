package com.example.mdatla1.mymobilepopquiz;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.mdatla1.mymobilepopquiz.fragment.UtilLog;

import java.util.Timer;
import java.util.TimerTask;

public class TestService extends Service {

    private Timer timer = new Timer();
    private int update = 0;
    public static final String UPDATE = "update";
    public static final String ACTION = "TestAction";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        String value = intent.getStringExtra("Service");
        if(value.equals("Start")){
            timer.schedule(new UpdateTask(), 0, 2000);
        }else if (value.equals("Stop")){
            timer.cancel();
        }
//        timer.schedule(new UpdateTask(), 0, 1000);
        return super.onStartCommand(intent, flags, startId);
    }

//    @Override
//    public int onStopCommand(Intent intent, int flags, int stopId){
//        String value = intent.getStringExtra("Service");
//        if(value.equals("Stop")){
//            timer.cancel();
//        }
//        return super.onStopCommand(intent, flags, stopId);
//    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    private class UpdateTask extends TimerTask {
        public void run(){
            Intent intent = new Intent();
            intent.setAction(ACTION); // Necessary
            intent.putExtra(UPDATE, ++update);
            sendBroadcast(intent);
            UtilLog.d("Service", update+"");
        }
    }
}
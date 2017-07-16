



package com.example.mdatla1.mymobilepopquiz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.mdatla1.mymobilepopquiz.TestService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceActivity extends AppCompatActivity {

    @BindView(R.id.activity_service_tv)
    TextView textView;

    private TestReceiver testReceiver;
    private int time = 0;


    @OnClick(R.id.activity_service_start)
    public void startService(View v){
        Intent intent = new Intent(this, TestService.class);
        intent.putExtra("Service", "Start");
        startService(intent);
        registerBrocast();
    }

    @OnClick(R.id.activity_service_stop)
    public void stopService(View v){
        Intent intent = new Intent(ServiceActivity.this, TestService.class);
        intent.putExtra("Service", "Stop");
        stopService(intent);
        unregisterReceiver(testReceiver);
    }

    private void registerBrocast() {
        testReceiver = new TestReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(TestService.ACTION);
        registerReceiver(testReceiver, filter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
    }


    public class TestReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent){
            String action = intent.getAction();
            if (action.equals(TestService.ACTION)){
                int update = intent.getIntExtra("update", 0);
                textView.setText(String.valueOf(update));
            }
        }
    }

}
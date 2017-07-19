package com.example.mdatla1.mymobilepopquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends BaseActivity{


    private int checkedID;
    private final int DIALOG = 12345;

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what){
                case DIALOG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    shortToast("Dialog Message: " + s);
                    break;

                default:
            }
            super.handleMessage(msg);


        }
    };


    @BindView(R.id.activity_dialog_rdg)
    RadioGroup radioGroup;
    @OnClick(R.id.activity_dialog_button)
    public void okClick(){
        switch (checkedID){

            case R.id.activity_view_pager_bt :
                Intent intent1 = new Intent(DialogActivity.this, viewPagerActivity.class);
                startActivity(intent1);

                break;
            case R.id.activity_gesture_bt :
                Intent intent2 = new Intent(DialogActivity.this, GestureActivity.class);
                startActivity(intent2);

                break;
            case R.id.activity_broadcast_bt :
                Intent intent3 = new Intent(DialogActivity.this, ServiceActivity.class);
                startActivity(intent3);

                break;
            case R.id.activity_custom_dialog_bt :

                CustomDialog customDialog = new CustomDialog(this, new CustomDialog.ICustomDialogListener() {
                    @Override
                    public void onOKClicked(String msg) {
                        shortToast(msg);
                    }
                });
                customDialog.setCanceledOnTouchOutside(false);
                customDialog.show();

                break;

            case R.id.activity_listview_bt :
                Intent intent4 = new Intent(DialogActivity.this, ListViewActivity.class);
                startActivity(intent4);

                break;


            default:

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);


        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                shortToast("You checked the RadioButton " + checkedId);
                checkedID = checkedId;

            }
        });


    }



}
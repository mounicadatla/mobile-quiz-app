package com.example.mdatla1.mymobilepopquiz;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialog extends Dialog {

    private final ICustomDialogListener listener;

    public interface ICustomDialogListener{
        public void onOKClicked(String msg);
        //  public void onCancelClicked(String msg);

    }



    @OnClick(R.id.dialog_custom_ok)
    public void ok(View view){
        listener.onOKClicked("You clicked OK");
        cancel();

    }
    public CustomDialog(@NonNull Context context, ICustomDialogListener listener) {
//        super(context);
        super(context,R.style.dialog);
        setContentView(R.layout.dialog_custom);
        ButterKnife.bind(this);
        this.listener=listener;

    }

}

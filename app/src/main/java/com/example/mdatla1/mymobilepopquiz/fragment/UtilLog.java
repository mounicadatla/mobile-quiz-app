package com.example.mdatla1.mymobilepopquiz.fragment;

import android.util.Log;

/**
 * Created by mounicadatla on 6/19/17.
 */

public class UtilLog {
    private static  boolean isLog= false;
    public static void setIsLog(boolean b){
        isLog=b;
    }
    public static void d(String  tag, String msg){
        if(isLog){
            Log.d(tag,msg);
        }

    }

}

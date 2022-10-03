package com.upwards.uidemo.Utils;

import android.widget.Toast;

import com.upwards.uidemo.MainApplication;

public class Utils {

    public static void showToast(String message){
        Toast.makeText(MainApplication.getContext(),message,Toast.LENGTH_LONG).show();
    }
}

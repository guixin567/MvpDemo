package com.example.ldachu.mvpdemo.common.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {

    private static Toast toast;

    public static void show(Context context, String message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();

        } else {
            toast.setText(message);
            toast.show();
        }
    }



}
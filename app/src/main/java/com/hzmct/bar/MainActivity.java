package com.hzmct.bar;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ShellUtils;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    Intent systemBarIntent = new Intent("com.tchip.changeBarHideStatus");
    Intent statusBarIntent = new Intent("com.tchip.changeStatusBarHideStatus");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.bar_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Executors.newCachedThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        ShellUtils.execCmd("settings put system systembar_hide 0", true); //1为隐藏导航栏，0显示导航栏
                        sendBroadcast(systemBarIntent);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            ShellUtils.execCmd("settings put system systemstatusbar_hide 0", true); //1隐藏状态栏，0显示状态栏
                            sendBroadcast(statusBarIntent);
                        }
                    }
                });
            }
        });

        findViewById(R.id.bar_hide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Executors.newCachedThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        ShellUtils.execCmd("settings put system systembar_hide 1", true); //1为隐藏导航栏，0显示导航栏
                        sendBroadcast(systemBarIntent);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            ShellUtils.execCmd("settings put system systemstatusbar_hide 1", true); //1隐藏状态栏，0显示状态栏
                            sendBroadcast(statusBarIntent);
                        }
                    }
                });
            }
        });
    }
}
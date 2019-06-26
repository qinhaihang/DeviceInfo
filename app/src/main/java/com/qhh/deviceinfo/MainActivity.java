package com.qhh.deviceinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mDeviceInfoTv;
    private StringBuilder mInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDeviceInfoTv = findViewById(R.id.tv_device_info);
        mInfos = new StringBuilder();
        showDeviceInfo();

    }

    private void showDeviceInfo() {

        showScreenInfo();

        mDeviceInfoTv.setText(mInfos.toString());
    }

    private void showScreenInfo() {

        DisplayMetrics metrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;

        mInfos.append("widthPx = " + widthPixels + "\n")
                .append("heightPx = " + heightPixels + "\n");

        float density = metrics.density;
        int densityDpi = metrics.densityDpi;

        mInfos.append("像素密度(density) = " + density + "\n")
                .append("dpi = " + densityDpi + "\n");

    }
}

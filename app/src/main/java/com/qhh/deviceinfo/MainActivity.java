package com.qhh.deviceinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.qhh.deviceinfo.bean.ScreenInfos;
import com.qhh.deviceinfo.utils.DeviceInfos;
import com.qhh.deviceinfo.utils.SystemUtils;

public class MainActivity extends AppCompatActivity {

    private TextView mDeviceInfoTv;
    private StringBuilder mInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SystemUtils.hideBottomUIMenu(this);
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

        //ScreenInfos screenInfos = DeviceInfos.getScreenInfos(this);
        ScreenInfos screenInfos = DeviceInfos.getScreenInfos(getApplicationContext());

        mInfos.append("widthPx = " + screenInfos.widthPixels + "\n")
                .append("heightPx = " + screenInfos.heightPixels + "\n")
                .append("density = " + screenInfos.density + "\n")
                .append("dpi = " + screenInfos.densityDpi + "\n");

    }
}

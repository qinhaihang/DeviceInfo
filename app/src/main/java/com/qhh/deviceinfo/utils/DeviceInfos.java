package com.qhh.deviceinfo.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.qhh.deviceinfo.bean.ScreenInfos;

/**
 * @author qinhaihang_vendor
 * @version $Rev$
 * @time 2019/9/7 9:45
 * @des
 * @packgename com.qhh.deviceinfo.utils
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes
 */
public class DeviceInfos {

    public static ScreenInfos getScreenInfos(Activity activity){

        ScreenInfos screenInfos = new ScreenInfos();

        //DisplayMetrics metrics = new DisplayMetrics();
        DisplayMetrics metrics = getDisplayMetrics(activity);

        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        screenInfos.widthPixels = metrics.widthPixels;
        screenInfos.heightPixels = metrics.heightPixels;
        screenInfos.density = metrics.density;
        screenInfos.densityDpi = metrics.densityDpi;


        return screenInfos;
    }

    private static DisplayMetrics getDisplayMetrics(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) { //Android 4.2,4.2.2 api level 17
            WindowManager windowMgr = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
            windowMgr.getDefaultDisplay().getRealMetrics(metric);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        }
        return metric;
    }

}

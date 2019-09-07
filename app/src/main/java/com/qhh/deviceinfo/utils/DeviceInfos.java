package com.qhh.deviceinfo.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

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

        DisplayMetrics metrics = new DisplayMetrics();

        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        screenInfos.widthPixels = metrics.widthPixels;
        screenInfos.heightPixels = metrics.heightPixels;
        screenInfos.density = metrics.density;
        screenInfos.densityDpi = metrics.densityDpi;


        return screenInfos;
    }

}

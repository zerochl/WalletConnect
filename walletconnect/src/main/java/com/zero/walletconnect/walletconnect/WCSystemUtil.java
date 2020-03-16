package com.zero.walletconnect.walletconnect;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.zero.walletconnect.walletconnect.log.WCLogUtil;

public class WCSystemUtil {

    public static final int DEFAULT_USER_ID = -1;

    public static String getUserId(Context context) {
        PackageManager pm = context.getPackageManager();
        ApplicationInfo activityInfo = null;
        try {
            activityInfo = pm.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            WCLogUtil.i("HongLi", "User Id" + activityInfo.uid);
            return activityInfo.uid + "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return DEFAULT_USER_ID + "";
    }
}

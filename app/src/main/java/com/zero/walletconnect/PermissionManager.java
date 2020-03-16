package com.zero.walletconnect;

import android.app.Activity;
import android.content.Context;

import pub.devrel.easypermissions.EasyPermissions;

public class PermissionManager {
    /**
     * 检测权限
     *
     * @param context
     * @param perms
     * @return true:已经获取权限 false: 未获取权限，主动请求权限
     */
    public static boolean checkPermission(Context context, String[] perms) {
        return EasyPermissions.hasPermissions(context, perms);
    }

    /**
     * 请求权限
     *
     * @param activity
     * @param tip
     * @param requestCode
     * @param perms
     */
    public static void requestPermission(Activity activity, String tip, int requestCode, String[] perms) {
        if (checkPermission(activity, perms)) {
            return;
        }
        EasyPermissions.requestPermissions(activity, tip, requestCode, perms);
    }
}

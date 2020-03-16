package com.zero.walletconnect.walletconnect.log;

public class WCLogUtil {

    private static LogCallBack logCallBack;

    public static void init(LogCallBack logCallBack) {
        WCLogUtil.logCallBack = logCallBack;
    }

    public static void e(String tag, String msg) {
        if (null == logCallBack) {
            return;
        }
        logCallBack.e(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (null == logCallBack) {
            return;
        }
        logCallBack.i(tag, msg);
    }
}

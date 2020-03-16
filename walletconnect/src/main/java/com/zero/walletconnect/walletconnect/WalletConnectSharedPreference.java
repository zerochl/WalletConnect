package com.zero.walletconnect.walletconnect;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class WalletConnectSharedPreference {
    private static final String SP_DB_CONFIG = "config_sp";

    private static final String SP_KEY_LATEST_WC_PROTOCOL = "latestWCProtocol";

    public static void setLatestWCProtocol(Context context, String protocol) {
        SharedPreferences configSharedPreference = getSharedPreferences(context);
        if (null == configSharedPreference) {
            return;
        }
        SharedPreferences.Editor editor = configSharedPreference.edit();
        editor.putString(SP_KEY_LATEST_WC_PROTOCOL, protocol);
        editor.apply();
    }

    public static String getLatestWCProtocol(Context context) {
        SharedPreferences configSharedPreference = getSharedPreferences(context);
        if (null == configSharedPreference) {
            return "";
        }
        return configSharedPreference.getString(SP_KEY_LATEST_WC_PROTOCOL, "");
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        if (null == context || context.getApplicationContext() == null) {
            return null;
        }
        String userId = WCSystemUtil.getUserId(context);
        SharedPreferences configSP = context.getApplicationContext().getSharedPreferences(SP_DB_CONFIG, Context.MODE_PRIVATE);
        Map<String, ?> dataMap = configSP.getAll();
        if (dataMap.size() == 0) {
            configSP = context.getApplicationContext().getSharedPreferences(userId + SP_DB_CONFIG, Context.MODE_PRIVATE);
        }
        return configSP;
    }
}

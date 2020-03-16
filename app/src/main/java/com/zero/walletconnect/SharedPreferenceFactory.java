package com.zero.walletconnect;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class SharedPreferenceFactory {
    private  static String SP_DB_CONFIG = "mykey_config_sp";
    public static SharedPreferences getConfigSP(Context context) {
        SharedPreferences configSP = getSharedPreferences(context, SP_DB_CONFIG);
        Map<String, ?> dataMap = configSP.getAll();
        if (dataMap.size() == 0) {
            configSP = getSharedPreferences(context, SP_DB_CONFIG);
        }
        return configSP;
    }

    public static SharedPreferences getSharedPreferences(Context context, String dbName) {
        if (null == context || context.getApplicationContext() == null) {
            return null;
        }
        return context.getApplicationContext().getSharedPreferences(dbName, Context.MODE_PRIVATE);
    }
}

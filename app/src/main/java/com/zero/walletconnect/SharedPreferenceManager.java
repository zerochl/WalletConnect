package com.zero.walletconnect;

import android.content.SharedPreferences;

public class SharedPreferenceManager {

    private static final String SAVED_UUID = "savedUuid";
    private static final String WALLET_CONNECT_PEER_META = "walletConnectPeerMeta";

    public static String getSavedUUID() {
        SharedPreferences configSP = SharedPreferenceFactory.getConfigSP(ZeroApplication.getMainApplication());
        return get(configSP, SAVED_UUID, "");
    }

    public static void setSavedUUID(String savedUUID) {
        SharedPreferences configSP = SharedPreferenceFactory.getConfigSP(ZeroApplication.getMainApplication());
        SharedPreferences.Editor editor = configSP.edit();
        put(SAVED_UUID, savedUUID, editor);
    }

    public static String getWalletConnectPeerMeta() {
        SharedPreferences configSP = SharedPreferenceFactory.getConfigSP(ZeroApplication.getMainApplication());
        return get(configSP, WALLET_CONNECT_PEER_META, "");
    }

    public static void setWalletConnectPeerMeta(String peerMeta) {
        SharedPreferences configSP = SharedPreferenceFactory.getConfigSP(ZeroApplication.getMainApplication());
        SharedPreferences.Editor editor = configSP.edit();
        put(WALLET_CONNECT_PEER_META, peerMeta, editor);
    }




    private static void put(String key, String value, SharedPreferences.Editor editor) {
        editor.putString(key, value);
        editor.apply();
    }

    private static void put(String key, int value, SharedPreferences.Editor editor) {
        editor.putInt(key, value);
        editor.apply();
    }

    private static void put(String key, boolean value, SharedPreferences.Editor editor) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    private static void put(String key, long value, SharedPreferences.Editor editor) {
        editor.putLong(key, value);
        editor.apply();
    }

    private static String get(SharedPreferences preferences, String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    private static int get(SharedPreferences preferences, String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    private static boolean get(SharedPreferences preferences, String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }

    private static long get(SharedPreferences preferences, String key, long defaultValue) {
        return preferences.getLong(key, defaultValue);
    }
}

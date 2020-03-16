package com.zero.walletconnect;

import android.app.Application;

import androidx.multidex.MultiDexApplication;

public class ZeroApplication extends MultiDexApplication {
    private static Application mainApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        mainApplication = this;
        WalletConnectHelperManager.getInstance().initWalletConnect(getApplicationContext());
    }

    public static Application getMainApplication() {
        return mainApplication;
    }

}

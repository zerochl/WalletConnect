package com.zero.walletconnect;

import android.text.TextUtils;

import java.util.UUID;

public class UserManager {
    public static String getRandomUUID() {
        String savedUUID = SharedPreferenceManager.getSavedUUID();
        if (TextUtils.isEmpty(savedUUID)) {
            // 创建UUID
            savedUUID = UUID.randomUUID().toString();
            SharedPreferenceManager.setSavedUUID(savedUUID);
        }
        return savedUUID;
    }
}

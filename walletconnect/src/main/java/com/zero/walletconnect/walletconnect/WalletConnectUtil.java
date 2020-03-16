package com.zero.walletconnect.walletconnect;

import android.text.TextUtils;

import com.mykey.id.walletconnect.Session;
import com.zero.walletconnect.walletconnect.log.WCLogUtil;

import java.net.URLDecoder;
import java.util.HashMap;


public class WalletConnectUtil {

    private static final String TAG = "";

    public static boolean isWalletConnectProtocol(String protocol) {
        if (TextUtils.isEmpty(protocol)) {
            return false;
        }
        Session.Config config = parseWalletConnectProtocol(protocol);
        if (null == config || TextUtils.isEmpty(config.getHandshakeTopic()) || TextUtils.isEmpty(config.getBridge()) || TextUtils.isEmpty(config.getKey())) {
            return false;
        }
        return true;
    }

    public static Session.Config parseWalletConnectProtocol(String protocolUrl) {
        if (TextUtils.isEmpty(protocolUrl)) {
            WCLogUtil.e(TAG, "in");
            return null;
        }
        // // wc:33d14209-370c-4374-a74a-30d847894207@1?bridge=https%3A%2F%2Fbridge.walletconnect.org&key=521470f3262ccb6036c688a168aa5a6a39abee1a6ec8bef2ab94191770c57720
        String handshakeTopic = protocolUrl.substring(protocolUrl.indexOf(':') + 1, protocolUrl.indexOf('@'));
        String[] params = protocolUrl.substring(protocolUrl.indexOf('?') + 1).split("&");
        HashMap<String, String> paramMap = getParamsMap(params);
        String bridge = paramMap.get("bridge");
        String key = paramMap.get("key");
        return new Session.Config(handshakeTopic, bridge, key, "wc", 1);
    }

    private static HashMap<String, String> getParamsMap(String[] params) {
        if (null == params || params.length == 0) {
            return new HashMap<>();
        }
        try {
            HashMap<String, String> paramMap = new HashMap<>();
            for (String param : params) {
                String[] strs = param.split("=");
                if (strs.length != 2) {
                    return new HashMap<>();
                }
                paramMap.put(strs[0], URLDecoder.decode(strs[1], "UTF-8"));
            }
            return paramMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}

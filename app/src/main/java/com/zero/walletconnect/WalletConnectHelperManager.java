package com.zero.walletconnect;

import android.content.Context;
import android.util.Log;

import com.mykey.id.walletconnect.Session;
import com.zero.walletconnect.functionpage.scan.controller.MixProtocolController;
import com.zero.walletconnect.walletconnect.WallConnectInfoConfig;
import com.zero.walletconnect.walletconnect.WalletConnectCallBack;
import com.zero.walletconnect.walletconnect.WalletConnectManager;
import com.zero.walletconnect.walletconnect.log.LogCallBack;

public class WalletConnectHelperManager {
    private static final String TAG = "WalletConnectHelper";
    private static final WalletConnectHelperManager walletConnectHelper = new WalletConnectHelperManager();

    private static final String CUSTOM_METHOD_PERSONAL_SIGN = "personal_sign";

    private WalletConnectHelperManager() {
    }

    public static WalletConnectHelperManager getInstance() {
        return walletConnectHelper;
    }

    public void initWalletConnect(Context context) {
        WalletConnectManager.getInstance().init(context, new WallConnectInfoConfig()
                .setClientId(UserManager.getRandomUUID())
                .setName(CommonInfo.APP_NAME)
                .setUrl(CommonInfo.APP_URL)
                .setIcon(CommonInfo.APP_ICON_URL)
                .setDescription(CommonInfo.APP_DESCRIPTION)
                .setLogCallBack(logCallBack)
                .setWalletConnectCallBack(walletConnectCallBack));
    }

    private void savePeerMeta(Session.PeerMeta peerMeta) {
        if (null == peerMeta) {
            return;
        }
        SharedPreferenceManager.setWalletConnectPeerMeta(JsonUtil.gsonToJson(peerMeta));
    }

    private Session.PeerMeta getPeerMeta() {
        Session.PeerMeta peerMeta = JsonUtil.gsonParse(SharedPreferenceManager.getWalletConnectPeerMeta(), Session.PeerMeta.class);
        if (null == peerMeta) {
            peerMeta = new Session.PeerMeta();
        }
        return peerMeta;
    }

    private LogCallBack logCallBack = new LogCallBack() {
        @Override
        public void e(String tag, String log) {
            Log.e(tag, log);
        }

        @Override
        public void i(String tag, String log) {
            Log.i(tag, log);
        }
    };

    private WalletConnectCallBack walletConnectCallBack = new WalletConnectCallBack() {
        @Override
        public void onSessionRequest(Session.MethodCall.SessionRequest sessionRequest) {
            Log.e(TAG, "in onSessionRequest");
            savePeerMeta(sessionRequest.getPeer().getMeta());
            WalletConnectManager.getInstance().approveSession(MixProtocolController.ETHAddress);
        }

        @Override
        public void onSessionUpdate(Session.MethodCall.SessionUpdate sessionUpdate) {

        }

        @Override
        public void onSendTransaction(Session.MethodCall.SendTransaction sendTransaction) {
            Log.e(TAG, "in onSendTransaction");
        }

        @Override
        public void onSignMessage(Session.MethodCall.SignMessage signMessage) {
            Log.e(TAG, "in onSignMessage");
        }

        @Override
        public void onCustom(Session.MethodCall.Custom custom) {
            Log.e(TAG, "in onCustom");
        }

        @Override
        public void onResponse(Session.MethodCall.Response response) {

        }
    };
}

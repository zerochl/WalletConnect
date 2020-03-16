package com.zero.walletconnect.walletconnect;

import com.mykey.id.walletconnect.Session;

public interface WalletConnectCallBack {
    void onSessionRequest(Session.MethodCall.SessionRequest sessionRequest);
    void onSessionUpdate(Session.MethodCall.SessionUpdate sessionUpdate);
    void onSendTransaction(Session.MethodCall.SendTransaction sendTransaction);
    void onSignMessage(Session.MethodCall.SignMessage signMessage);
    void onCustom(Session.MethodCall.Custom custom);
    void onResponse(Session.MethodCall.Response response);
}

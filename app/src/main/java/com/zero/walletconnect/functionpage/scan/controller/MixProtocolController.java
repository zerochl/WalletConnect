package com.zero.walletconnect.functionpage.scan.controller;

import android.text.TextUtils;

import com.zero.walletconnect.functionpage.scan.ScanQRContract;
import com.zero.walletconnect.walletconnect.WalletConnectManager;
import com.zero.walletconnect.walletconnect.WalletConnectUtil;

/**
 * Created by zero on 2018/12/7.
 */

public class MixProtocolController extends ScanQRController {

    public static String ETHAddress = "0xc0b09b78c00EBCeD69eD1b397F5FB6AD94938441";

    public MixProtocolController(ScanQRContract.IMvpScanQRView mvpView, ScanQRContract.IMvpScanQRPresenter presenter) {
        super(mvpView, presenter);
    }

    public void handleAnalyzeOnSuccess(String result) {
        if (checkWalletConnect(result)) {
            return;
        }
        mvpView.doClickBackAction();
    }

    @Override
    public boolean needSelectAlbum() {
        return true;
    }

    private boolean checkWalletConnect(String result) {
        // 没有ETH地址，或者协议不对均不需要start wallet connect
        if (TextUtils.isEmpty(ETHAddress) || !WalletConnectUtil.isWalletConnectProtocol(result)) {
            return false;
        }
        WalletConnectManager.getInstance().startConnect(mvpView.getActivity(), result);
        mvpView.doClickBackAction();
        return true;
    }

}

package com.zero.walletconnect.functionpage.scan;

import android.graphics.Bitmap;
import android.util.Log;

import com.zero.walletconnect.R;
import com.zero.walletconnect.functionpage.scan.controller.MixProtocolController;
import com.zero.walletconnect.functionpage.scan.controller.ScanQRController;
import com.zero.walletconnect.zxing.activity.CaptureFragment;
import com.zero.walletconnect.zxing.activity.CodeUtils;

/**
 * Created by zero on 2018/10/22.
 */

public class ScanQRPresenter implements ScanQRContract.IMvpScanQRPresenter {

    private static final String TAG = "ScanQRPresenter";

    // 选择系统图片Request Code
    public static final int REQUEST_IMAGE = 110;
    private CaptureFragment captureFragment;

    private ScanQRContract.IMvpScanQRView mvpView;
    private ScanQRController scanQRController;

    public ScanQRPresenter(ScanQRContract.IMvpScanQRView mvpView) {
        this.mvpView = mvpView;
    }

    public void fillData() {
        scanQRController = new MixProtocolController(mvpView, this);
    }

    public void initCamera() {
        captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.view_custom_camera);
        captureFragment.setAnalyzeCallback(analyzeCallback);
        mvpView.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.scan_qr_container, captureFragment).commit();
    }

    public void restart() {
        captureFragment.restart();
    }

    /**
     * 二维码解析回调函数
     */
    private CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Log.i(TAG, "onAnalyzeSuccess.");
            scanQRController.handleAnalyzeOnSuccess(result);
        }

        @Override
        public void onAnalyzeFailed() {
            Log.e(TAG, "onAnalyzeFailed");
            restart();
        }
    };
}

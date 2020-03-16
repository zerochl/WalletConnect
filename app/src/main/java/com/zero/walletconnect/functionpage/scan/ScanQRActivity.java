package com.zero.walletconnect.functionpage.scan;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zero.walletconnect.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * Created by zero on 2018/10/22.
 */

public class ScanQRActivity extends FragmentActivity implements ScanQRContract.IMvpScanQRView {

    private ImageView btnBack;
    private ScanQRPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        btnBack = findViewById(R.id.back);

        btnBack.setOnClickListener(onClickListener);

        presenter = new ScanQRPresenter(this);

        presenter.fillData();
        // 为二维码扫描界面设置定制化界面
        presenter.initCamera();
    }

    @Override
    public FragmentActivity getActivity() {
        return this;
    }

    @Override
    public void doClickBackAction() {
        finish();
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == btnBack) {
                doClickBackAction();
            }
        }
    };

}

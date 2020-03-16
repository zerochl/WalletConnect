package com.zero.walletconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zero.walletconnect.functionpage.scan.ScanQRActivity;

public class MainActivity extends AppCompatActivity {
    private String[] PERMS_CAMERA = {
            Manifest.permission.CAMERA
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 请求权限
                if (!PermissionManager.checkPermission(getApplicationContext(), PERMS_CAMERA)) {
                    PermissionManager.requestPermission(MainActivity.this, "", 0, PERMS_CAMERA);
                    return;
                }
                Intent intent = new Intent(MainActivity.this, ScanQRActivity.class);
                startActivity(intent);
            }
        });
    }
}

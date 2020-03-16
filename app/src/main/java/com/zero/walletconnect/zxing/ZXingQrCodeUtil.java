package com.zero.walletconnect.zxing;


import android.graphics.Bitmap;
import android.text.TextUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.HashMap;

/**
 * Created by zero on 2018/9/4.
 */

public class ZXingQrCodeUtil {
    // 定义二维码的宽高
    private static final int WIDTH = 900;
    private static final int HEIGHT = 900;
    // 二维码格式
    private static final String FORMAT = "png";

    /**
     * 生成二维码
     * @param content
     * @return
     */
    public static Bitmap createZxingqrCode(String content) {
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        // 定义二维码参数
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        // 设置编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        // 设置容错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 设置边距默认是5
        hints.put(EncodeHintType.MARGIN, 0);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
            return MatrixToBitmap.toBitmap(bitMatrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

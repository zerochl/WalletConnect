package com.zero.walletconnect.zxing;

import android.graphics.Bitmap;

import com.google.zxing.common.BitMatrix;

/**
 * BitMatrix转bitmap
 * Created by zero on 2018/9/4.
 */
public class MatrixToBitmap {
    // 用于设置图案的颜色
    private static final int BLACK = 0xFF000000;
    // 用于背景色
    private static final int WHITE = 0xFFFFFFFF;

    private MatrixToBitmap() {
    }

    public static Bitmap toBitmap(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bitmap.setPixel(x, y, (matrix.get(x, y) ? BLACK : WHITE));
            }
        }
        return bitmap;
    }

}

package com.zero.walletconnect.walletconnect;

import android.text.TextUtils;

import java.io.File;

public class WCFileUtil {
    /**
     * 判断文件或文件夹是否存在
     *
     * @param path
     * @return true 文件存在
     */
    public static boolean isExist(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        boolean exist = false;
        try {
            File file = new File(path);
            exist = file.exists();
        } catch (Exception e) {
            return false;
        }
        return exist;
    }

    public static void createNewFile(String folderPath, String fileName) {
        if (TextUtils.isEmpty(folderPath) || TextUtils.isEmpty(fileName)) {
            return;
        }
        try {
            File folder = new File(folderPath);
            folder.mkdirs();
            File file = new File(folderPath + File.separator + fileName);
            file.delete();
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.zero.walletconnect;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

public class JsonUtil {

    public static <T> T gsonParse(String json, Class<T> classObj) {
        try {
            return new Gson().fromJson(json, classObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T gsonParse(String json, TypeToken typeToken) {
        try {
            return new Gson().fromJson(json, typeToken.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> String gsonToJson(T obj) {
        if (null == obj) {
            return "";
        }
        return new Gson().toJson(obj);
    }
}

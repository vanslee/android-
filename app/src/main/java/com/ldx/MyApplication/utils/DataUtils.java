package com.ldx.MyApplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class DataUtils {
    public static String data = "data";
    public static SharedPreferences sp;

    public static void setSharedPreferences(Context context, String key, String value) {
        // 文件权限设置为私有
        // 创建文件
        sp = context.getSharedPreferences(data, Context.MODE_PRIVATE);
        // 写入
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
    }

    /**
     * 取值
     *
     * @param key
     * @return
     */
    public static String getSharedPreferences(String key) {
        return sp.getString(key, "null");
    }
}

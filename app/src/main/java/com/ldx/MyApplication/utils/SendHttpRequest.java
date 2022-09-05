package com.ldx.MyApplication.utils;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ldx.MyApplication.activity.DetailActivity;
import com.ldx.MyApplication.activity.LoginActivity;
import com.ldx.MyApplication.activity.RegistryActivity;
import com.ldx.MyApplication.constants.SystemContains;
import com.ldx.MyApplication.fragment.Index;
import com.ldx.MyApplication.fragment.UserCenter;
import com.ldx.MyApplication.pojo.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class SendHttpRequest {
    public static String Authentication = "";

    public static void sendGETRequest(String location) {
        Log.e("请求地址:GET", location);
        new Thread(() -> {
            String resultJsonData = "";
            InputStream inputStream = null;
            try {
                URL url = new URL(location);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty(SystemContains.CONTENT_TYPE, SystemContains.FORMART);
                urlConnection.setRequestMethod(SystemContains.GETMETHOD);
                if (!"".equals(Authentication)) {
                    urlConnection.setRequestProperty("Authentication", Authentication);
                    Log.e("赋值token", "2");
                }

                Log.e("Authentication", Authentication);
                urlConnection.connect();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                    int readLen = 0;
                    byte[] bytes = new byte[SystemContains.BYTE_LENGTH];
                    while ((readLen = inputStream.read(bytes)) != -1) {
                        resultJsonData += new String(bytes, 0, readLen);
                    }

                } else {
                    throw new RuntimeException("输入地址不合法,未能获取到数据");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStream != null)
                        inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Log.i(SystemContains.TAG, resultJsonData);
            if (location.contains("actor"))
                IndexCalled(resultJsonData);
            else PhoneCalled(resultJsonData);
        }).start();

    }

    private static void PhoneCalled(String resultJsonData) {
        UserCenter.resultJsonData = resultJsonData;
    }

    private static void IndexCalled(String resultJsonData) {
        Index.resultJsonData = resultJsonData;
    }

    public static void sendPOSTRequest(String location, User user) {
        new Thread(() -> {
            Log.e(SystemContains.TAG, "注册");
            InputStream inputStream = null;
            String resultJsonData = "";
            try {
                URL url = new URL(location);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                JSONObject jsonObject = new JSONObject();
                if (user != null) {
                    jsonObject.put("phone", user.getPhone());
                    jsonObject.put("password", user.getPassword());
                }
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                urlConnection.setRequestProperty(SystemContains.CONTENT_TYPE, SystemContains.FORMART);
                urlConnection.setRequestMethod(SystemContains.POSTMETHOD);
                if (!"".equals(Authentication)) {
                    urlConnection.setRequestProperty("Authentication", Authentication);
                    Log.e("赋值token", "2");
                }
                DataOutputStream os = new DataOutputStream(urlConnection.getOutputStream());
                os.writeBytes(jsonObject.toString());
                os.flush();
                os.close();
                urlConnection.connect();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                    int readLen = 0;
                    byte[] bytes = new byte[SystemContains.BYTE_LENGTH];
                    while ((readLen = inputStream.read(bytes)) != -1) {
                        resultJsonData += new String(bytes, 0, readLen);
                    }
                } else {
                    throw new RuntimeException("输入地址不合法,未能获取到数据");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStream != null)
                        inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (location.contains("registry"))
                RegistryCalled(resultJsonData);
            else if (location.contains("logout")) {
                UserCenterCalled(resultJsonData);
            } else LoginCalled(resultJsonData);

        }).start();
    }

    private static void UserCenterCalled(String resultJsonData) {
        UserCenter.resultJsonData = resultJsonData;
    }

    private static void LoginCalled(String resultJsonData) {
        LoginActivity.resultJsonData = resultJsonData;
    }

    private static void RegistryCalled(String resultJsonData) {
        RegistryActivity.resultJsonData = resultJsonData;
    }

    public static <T> T JSONToBean(String resultJsonData, Class<T> objectBean) {
        return JSON.parseObject(resultJsonData, objectBean);
    }
}

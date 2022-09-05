package com.ldx.MyApplication.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSON;
import com.ldx.MyApplication.R;
import com.ldx.MyApplication.activity.LoginActivity;
import com.ldx.MyApplication.activity.RegistryActivity;
import com.ldx.MyApplication.bean.PhoneBean;
import com.ldx.MyApplication.bean.ResponseResult;
import com.ldx.MyApplication.constants.SystemContains;
import com.ldx.MyApplication.utils.SendHttpRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * 用户中心
 */
public class UserCenter extends Fragment {
    public static String resultJsonData = "";
    // 需要和哪个activity绑定
    private Activity activity;
    private EditText editText;
    private TextView button;
    private TextView logout;
    private TextView showResult;

    private UserCenter() {
    }

    public static UserCenter getUserFragment(Activity activity) {
        UserCenter userCenter = new UserCenter();
        userCenter.activity = activity;
        return userCenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_usercenter, container, false);
        editText = inflate.findViewById(R.id.fragment_usercenter_et);
        button = inflate.findViewById(R.id.fragment_usercenter_btn);
        logout = inflate.findViewById(R.id.fragment_usercenter_logout);
        showResult = inflate.findViewById(R.id.fragment_usercenter_show);
        logout.setOnClickListener((v) -> {
            Log.e("退出登录", "1");
            SendHttpRequest.sendPOSTRequest(SystemContains.logoutURL, null);
            while ("".equals(resultJsonData)) {
            }
            ResponseResult responseResult = JSON.parseObject(resultJsonData, ResponseResult.class);
            Log.e("退出登录返回的信息", responseResult.getMsg());
            resultJsonData = "";
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
        button.setOnClickListener((v) -> {
            String phone = editText.getText().toString().trim();
            if (phone.length() == 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage("请输入电话号");
                builder.show();
            } else {
                boolean matches = Pattern.matches(SystemContains.PHONE_REGEX, phone);
                if (matches) {
                    SendHttpRequest.sendGETRequest(SystemContains.QUERY_PHONE + phone);
                    while ("".equals(resultJsonData)) {
                    }
                    Log.e("返回的电话数据", resultJsonData);
                    activity.runOnUiThread(() -> {
                        ResponseResult responseResult = JSON.parseObject(resultJsonData, ResponseResult.class);
                        if (responseResult.getCode() == 200) {
                            showResult.setText(responseResult.getData().toString());
                        } else {
                            showResult.setText("该接口需要付费,请升级会员后再试");
                        }
                    });
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage("输入的电话格式不对");
                    builder.show();
                }
                resultJsonData = "";
            }
        });
        return inflate;
    }

}

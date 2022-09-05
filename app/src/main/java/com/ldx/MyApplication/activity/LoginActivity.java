package com.ldx.MyApplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ldx.MyApplication.MainActivity;

import com.ldx.MyApplication.R;
import com.ldx.MyApplication.bean.ResponseResult;
import com.ldx.MyApplication.constants.SystemContains;
import com.ldx.MyApplication.pojo.User;
import com.ldx.MyApplication.utils.DataUtils;
import com.ldx.MyApplication.utils.SendHttpRequest;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ePhone;
    private EditText epw;
    private TextView tLogin;
    private TextView tRegistry;
    public static String type = "1";
    public static String resultJsonData = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        ePhone = findViewById(R.id.log_et_phone);
        epw = findViewById(R.id.log_et_pw);
        tLogin = findViewById(R.id.log_tv_login);
        tRegistry = findViewById(R.id.log_tv_registry);
        //TODO 添加点击事件
        tLogin.setOnClickListener(this);
        tRegistry.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String phone = ePhone.getText().toString().trim();
        String pwd = epw.getText().toString().trim();
        //TODO 通过ID区别各自对象
        switch (view.getId()) {
            case R.id.log_tv_login:
                if (phone.length() == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("请输入手机号");
                    builder.show();
                } else {
                    User user = new User(phone, pwd);
                    SendHttpRequest.sendPOSTRequest(SystemContains.loginURL, user);
                    Log.e(SystemContains.TAG, resultJsonData);
                    while ("".equals(resultJsonData)) {

                    }
                    ResponseResult responseResult = JSON.parseObject(resultJsonData, ResponseResult.class);
                    if (responseResult.getCode() != 200) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage(responseResult.getMsg());
                        builder.show();
                    } else {
                        JSONObject jsonObject = JSON.parseObject(responseResult.getData().toString());
                        String token = (String) jsonObject.get("token");
                        SendHttpRequest.Authentication = token;
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
                break;
            case R.id.log_tv_registry:
                Intent intent = new Intent(LoginActivity.this, RegistryActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}

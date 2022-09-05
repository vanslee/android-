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
import com.ldx.MyApplication.MainActivity;
import com.ldx.MyApplication.R;
import com.ldx.MyApplication.bean.ResponseResult;
import com.ldx.MyApplication.constants.SystemContains;
import com.ldx.MyApplication.pojo.User;
import com.ldx.MyApplication.utils.DataUtils;
import com.ldx.MyApplication.utils.SendHttpRequest;

/**
 * TODO 1. 创建一个类
 *      2. 创建你要展示的内容 res创建布局
 *      3.
 */
public class RegistryActivity extends AppCompatActivity {
    private EditText ePhone;
    private EditText ePw;
    private EditText eConfimPw;
    private TextView tRegistry;
    public static String resultJsonData = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        initView();
    }

    private void initView() {
        ePhone = findViewById(R.id.registry_et_phone);
        ePw = findViewById(R.id.registry_et_pw);
        eConfimPw = findViewById(R.id.registry_et_confirmpw);
        tRegistry = findViewById(R.id.registry_tv_registry);

        //TODO 添加点击事件
        tRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = ePhone.getText().toString().trim();
                String password = ePw.getText().toString().trim();
                String confirmPw = eConfimPw.getText().toString().trim();
                //TODO
                // 第一我们判断用户名是否是11,
                // 第二我们判断密码是否大于等于6位
                // 第三我们来判断两个密码输入是否一致
                if (phone.length() == 11) {
                    if (password.length() >= 6) {
                        if (password.equals(confirmPw)) {
                            LoginActivity.type = "2";
                            User user = new User(phone, password);
                            SendHttpRequest.sendPOSTRequest(SystemContains.registryURL, user);
                            while ("".equals(resultJsonData)) {

                            }
                            Log.e("获取到后端返回的数据", resultJsonData);
                            ResponseResult responseResult = JSON.parseObject(resultJsonData, ResponseResult.class);
                            if (responseResult.getCode() != 200) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegistryActivity.this);
                                builder.setMessage(responseResult.getMsg());
                                builder.show();
                            } else {
                                Intent intent = new Intent(RegistryActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegistryActivity.this);
                            builder.setMessage("您两次输入的密码不一致");
                            builder.show();
                        }
                    } else {
                        // 密码位数<6
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegistryActivity.this);
                        builder.setMessage("您输入的密码小于6位");
                        builder.show();
                    }
                } else {
                    // 手机号小于11位
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegistryActivity.this);
                    builder.setMessage("您输入的手机号有误");
                    builder.show();
                }
            }
        });

    }

}

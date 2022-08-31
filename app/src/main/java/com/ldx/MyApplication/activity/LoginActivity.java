package com.ldx.MyApplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ldx.MyApplication.MainActivity;

import com.ldx.MyApplication.R;
import com.ldx.MyApplication.utils.DataUtils;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ePhone;
    private EditText epw;
    private TextView tLogin;
    private TextView tRegistry;
    public static String type = "1";
    private String dataName;
    private String dataPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        if (type.equals("1")) {

        } else {
            dataName = DataUtils.getSharedPreferences("dataName");
            dataPwd = DataUtils.getSharedPreferences("dataPwd");
        }
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
                    if (phone.equals(dataName)) {
                        if (pwd.equals(dataPwd)) {
                            Intent intent = new Intent();
                            intent.setClass(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setMessage("您输入的密码有误,请先确认你输入的密码");
                            builder.show();
                        }
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage("你还未登陆,请先注册");
                        builder.show();
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

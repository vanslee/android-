package com.ldx.MyApplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ldx.MyApplication.MainActivity;
import com.ldx.MyApplication.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ePhone;
    private EditText epw;
    private TextView tLogin;
    private TextView tRegistry;
    private String dataName;
    private String dataPwd;

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
        //TODO 通过ID区别各自对象
        switch (view.getId()) {
            case R.id.log_tv_login:
                if (phone.length() != 11) {
                    Toast toast = Toast.makeText(this, "手机号不合法", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    if (phone.equals(dataName)) {
                        if (epw.equals(dataPwd)) {
                            Intent intent = new Intent();
                            intent.setClass(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setMessage("您输入的密码有误,请重新输入");
                            builder.show();
                        }
                    }else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage("你还未登陆,请先注册");
                        builder.show();
                    }
                }
                break;
            case R.id.log_tv_registry:
                Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            default:
                break;
        }
    }
}

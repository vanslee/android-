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

/**
 * TODO 1. 创建一个类
 *      2. 创建你要展示的内容 res创建布局
 *      3.
 */
public class RegistryActivity extends AppCompatActivity {
    private EditText ePhone;
    private EditText epw;
    private EditText eConfirmpw;
    private TextView tRegistry;
    public static String type = "1";
    public String name;
    public String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        initView();
        if (type.equals("1")) {

        } else {
            name = DataUtils.getSharedPreferences("name");
            password = DataUtils.getSharedPreferences("pwd");
        }
    }

    private void initView() {
        ePhone = findViewById(R.id.registry_et_phone);
        epw = findViewById(R.id.registry_et_pw);
        eConfirmpw = findViewById(R.id.registry_et_confirmpw);
        tRegistry = findViewById(R.id.registry_tv_registry);
        String phone = ePhone.getText().toString().trim();
        String password = epw.getText().toString().trim();
        String confirmPw = eConfirmpw.getText().toString().trim();
        //TODO 添加点击事件
        tRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 首先我们判断用户名是否是11,
                // 第二我们判断密码是否大于6位
                // 第三我们来判断两个密码输入是否一致
                if (phone.length() == 11) {
                    if (password.length() >= 6) {
                        if (password.equals(confirmPw)) {
                            Intent intent = new Intent();
                            intent.setClass(RegistryActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegistryActivity.this);
                            builder.setMessage("您两次输入的密码不一致");
                            builder.show();
                        }
                    } else {
                        // 密码位数<6
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegistryActivity.this);
                        builder.setMessage("密码不符合规范");
                        builder.show();
                    }
                } else {
                    // 手机号小于11位
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegistryActivity.this);
                    builder.setMessage("您输入的手机号有误");
                    builder.show();
                }
                Intent intent = new Intent(RegistryActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}

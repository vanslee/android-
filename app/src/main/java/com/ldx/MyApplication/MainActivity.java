package com.ldx.MyApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tabbar1;
    private TextView tabbar2;
    private TextView tabbar3;
    // TODO Fragment是Activity里面的组件


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tabbar1 = findViewById(R.id.tabbar1);
        tabbar2 = findViewById(R.id.tabbar2);
        tabbar3 = findViewById(R.id.tabbar3);
        //TOOD 绑定点击时间
        tabbar1.setOnClickListener(this);
        tabbar2.setOnClickListener(this);
        tabbar3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
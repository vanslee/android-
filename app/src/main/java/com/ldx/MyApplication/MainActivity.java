package com.ldx.MyApplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ldx.MyApplication.fragment.Details;
import com.ldx.MyApplication.fragment.Index;
import com.ldx.MyApplication.fragment.UserCenter;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tabbar1;
    private TextView tabbar2;
    private TextView tabbar3;
    // TODO Fragment是Activity里面的组件
    private Index index;
    private Details details;
    private UserCenter userCenter;
    //TODO Fragment管理器
    private FragmentManager manager;
    //TODO 需要替换Fragment
    private int showType = -1;

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
        //TODO 构造Fragment对象
        index = Index.getIndexFragment(this);
        details = Details.getDetailsFragment(this);
        userCenter = UserCenter.getUserFragment(this);
        //TODO 布局管理器
        manager = getSupportFragmentManager();
        //
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_frame, index);
        transaction.commit();
        showType = 0;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tabbar1:
                tabbar1.setTextColor(getResources().getColor(R.color.user_red));
                tabbar2.setTextColor(getResources().getColor(R.color.black));
                tabbar3.setTextColor(getResources().getColor(R.color.black));
                if (showType != 0) {
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.main_frame, index);
                    transaction.commit();
                    showType = 0;
                }
                break;
            case R.id.tabbar2:
                if (showType != 1) {
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.main_frame, details);
                    transaction.commit();
                    showType = 1;
                }
                break;
            case R.id.tabbar3:
                if (showType != 2) {
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.main_frame, userCenter);
                    transaction.commit();
                    showType = 2;
                }
                break;
        }

    }
}
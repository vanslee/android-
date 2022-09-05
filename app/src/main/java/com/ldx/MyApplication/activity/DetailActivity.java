package com.ldx.MyApplication.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.ldx.MyApplication.R;
import com.ldx.MyApplication.adapter.DetailAdapter;
import com.ldx.MyApplication.bean.HotNewsBean;
import com.ldx.MyApplication.bean.ResponseResult;
import com.ldx.MyApplication.constants.SystemContains;
import com.ldx.MyApplication.utils.SendHttpRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class DetailActivity extends AppCompatActivity {
    private ListView listView;
    private DetailAdapter detailAdapter;
    public static String resultJsonData = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        listView = findViewById(R.id.is_detial);
        setNetWork();
    }

    private void setNetWork() {
        new Thread(() -> {
            SendHttpRequest.sendGETRequest(SystemContains.GET_ALL_ACTORS);
            while ("".equals(resultJsonData)) {}
            ResponseResult responseResult = JSON.parseObject(resultJsonData, ResponseResult.class);
            if (responseResult.getCode() != 200) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
                builder.setMessage(responseResult.getMsg());
                builder.show();
            } else {
                Log.i(SystemContains.TAG, resultJsonData);
                Log.e("演员表数据", responseResult.getData().toString());
//                runOnUiThread(() -> {
//                    HotNewsBean hotNewsBean = JSON.parseObject(resultJsonData, HotNewsBean.class);
//                    detailAdapter = new DetailAdapter(DetailActivity.this, hotNewsBean.getResult());
//                    listView.setAdapter(detailAdapter);
//                });
            }

        }).start();
    }
}



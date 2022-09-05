package com.ldx.MyApplication.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ldx.MyApplication.R;
import com.ldx.MyApplication.adapter.IndexAdapter;
import com.ldx.MyApplication.bean.ActorList;
import com.ldx.MyApplication.bean.HistoryOnToday;
import com.ldx.MyApplication.bean.ResponseResult;
import com.ldx.MyApplication.constants.SystemContains;
import com.ldx.MyApplication.utils.SendHttpRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

/**
 * 首页
 */
public class Index extends Fragment {
    private Index() {
    }

    // 需要和哪个activity绑定
    private Activity activity;
    private ListView listView;
    private IndexAdapter indexAdapter;
    private Button flushBtn;
    public static String resultJsonData = "";
    ;


    public static Index getIndexFragment(Activity activity) {
        Index index = new Index();
        index.activity = activity;
        return index;
    }

    // 设置布局
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_index, container, false);
        listView = inflate.findViewById(R.id.fragment_index_list);
        flushBtn = inflate.findViewById(R.id.fragment_index_btn);
        flushBtn.setOnClickListener((View v) -> {
            setNetWork();
            Log.e("Index", "发起请求");
        });
        return inflate;
    }

    //TODO 获取网络请求
    private void setNetWork() {
        new Thread(() -> {
            SendHttpRequest.sendGETRequest(SystemContains.GET_ALL_ACTORS);
            while ("".equals(resultJsonData)) {
            }
            ResponseResult responseResult = JSON.parseObject(resultJsonData, ResponseResult.class);
            if (responseResult.getCode() != 200) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(responseResult.getMsg());
                builder.show();
            } else {
                Log.e("接收到后端传入的Actors数据", responseResult.getData().toString());
                activity.runOnUiThread(() -> {
                    JSONArray actorList = (JSONArray) JSONArray.parse(responseResult.getData().toString());
                    indexAdapter = new IndexAdapter(actorList, activity);
                    listView.setAdapter(indexAdapter);
                });
            }


        }).start();

    }
}

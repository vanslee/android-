package com.ldx.MyApplication.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 首页
 */
public class Index extends Fragment {
    private Index() {
    }

    // 需要和哪个activity绑定
    private Activity activity;

    public static Index getIndexFragment(Activity activity) {
        Index index = new Index();
        index.activity = activity;
        return index;
    }

    // 设置布局
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

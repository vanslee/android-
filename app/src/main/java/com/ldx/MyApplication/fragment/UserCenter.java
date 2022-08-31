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
 * 用户中心
 */
public class UserCenter extends Fragment {
    // 需要和哪个activity绑定
    private Activity activity;

    private UserCenter() {
    }

    public static UserCenter getUserFragment(Activity activity) {
        UserCenter userCenter = new UserCenter();
        userCenter.activity = activity;
        return userCenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

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
 * App功能详情
 */
public class Details extends Fragment {
    private Details() {
    }

    // 需要和哪个activity绑定
    private Activity activity;

    public static Details getDetailsFragment(Activity activity) {
        Details details = new Details();
        details.activity = activity;
        return details;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

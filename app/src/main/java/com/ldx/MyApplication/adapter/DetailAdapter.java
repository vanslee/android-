package com.ldx.MyApplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ldx.MyApplication.R;
import com.ldx.MyApplication.bean.HotNewsBeanResult;
import com.ldx.MyApplication.bean.HotNewsBeanResultData;

import java.util.List;

public class DetailAdapter extends BaseAdapter {
    private List<HotNewsBeanResult> result;
    private Context context;

    public DetailAdapter(Context context, List<HotNewsBeanResult> result) {
        this.context = context;
        this.result = result;
    }

    /*TODO 多少个条目*/
    @Override
    public int getCount() {
        return result.size();
    }

    /*TODO 具体到每个条目*/
    @Override
    public Object getItem(int i) {
        return result.get(i);
    }

    /*TODO 点击哪个*/
    @Override
    public long getItemId(int i) {
        return i;
    }

    /*TODO 最重要的，这个是我们每个条目我也设置不同的内容*/
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Todo 你可以设置你想要的条目内容
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflate = inflater.inflate(R.layout.fragment_details, viewGroup, false);
        TextView viewById = inflate.findViewById(R.id.adpter_details_tv);
        for (HotNewsBeanResultData datum : result.get(i).getData()) {
            viewById.setText(datum.toString());
        }
        return view;
    }
}

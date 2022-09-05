package com.ldx.MyApplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ldx.MyApplication.R;
import com.ldx.MyApplication.bean.Actor;
import com.ldx.MyApplication.bean.HistoryOnToday;
import com.ldx.MyApplication.bean.NBANewBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IndexAdapter extends BaseAdapter {
    private JSONArray result;
    private Context context;

    public IndexAdapter(JSONArray result, Context context) {
        this.result = result;
        this.context = context;
    }

    /**
     * TODO 我们要展示的个数
     *
     * @return
     */
    @Override
    public int getCount() {
        return result.size();
    }

    /**
     * 我们点击的条目对象
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return result.get(position);
    }

    /**
     * 点击条目对象的下标
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 我们想让条目上展示的内容
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 转化成Actor对象
        Actor actor = JSON.parseObject(result.get(position).toString(), Actor.class);
        // 添加布局
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewItem = inflater.inflate(R.layout.adapter_index, parent, false);
        TextView textView = viewItem.findViewById(R.id.adapter_index_tv);
        TextView textView2 = viewItem.findViewById(R.id.adapter_index_tv2);
        ImageView imageView = viewItem.findViewById(R.id.adapter_index_img);
        textView.setText(actor.getName());
        textView2.setText(actor.getDescription());
        Picasso.with(context).load(actor.getAvatar()).into(imageView);
        return viewItem;
    }
}

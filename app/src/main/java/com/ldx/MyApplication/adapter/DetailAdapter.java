package com.ldx.MyApplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ldx.MyApplication.bean.HotVideoInfo;
import java.util.List;

public class DetailAdapter extends BaseAdapter {
    private List<HotVideoInfo> result;
    private Context context;
    public DetailAdapter(Context context,List<HotVideoInfo> result){
        this.context=context;
        this.result=result;
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
        return null;
    }
}

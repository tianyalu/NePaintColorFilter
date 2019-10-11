package com.sty.ne.paint.colorfilter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by tian on 2019/10/11.
 */

public class ColorFilterAdapter extends RecyclerView.Adapter<ColorFilterAdapter.MyViewHolder>{
    private LayoutInflater mInflater;
    private List<float[]> filters;

    public ColorFilterAdapter(LayoutInflater mInflater, List<float[]> filters) {
        this.mInflater = mInflater;
        this.filters = filters;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder;
        viewHolder = new MyViewHolder(mInflater.inflate(R.layout.list_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ColorFilterUtils.imageViewColorFilter(holder.imageView, filters.get(position));
    }

    @Override
    public int getItemCount() {
        return filters.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}

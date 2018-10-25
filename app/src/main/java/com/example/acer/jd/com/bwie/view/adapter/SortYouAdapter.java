package com.example.acer.jd.com.bwie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acer.jd.R;
import com.example.acer.jd.SouSuoActivity;
import com.example.acer.jd.com.bwie.model.bean.SortBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by acer on 2018/10/17.
 */

public class SortYouAdapter extends RecyclerView.Adapter<SortYouAdapter.MyViewHolder>{
    private Context context;
    private List<SortBean.DataBean> data;
    private  SortYouAdapter02 sortYouAdapter02;
    private SortYouAdapter02.OnItemClickLisnter onItemClickLisnter;

    public void setData(List<SortBean.DataBean> data) {
        this.data = data;
    }

    public SortYouAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sort_you_recycler_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        sortYouAdapter02 = new SortYouAdapter02(context);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.sort_you_recyclerView_text.setText(data.get(position).getName());
        holder.sort_you_recyclerView.setLayoutManager(new GridLayoutManager(context,3, LinearLayoutManager.VERTICAL,false));
        List<SortBean.DataBean.ListBean> list = data.get(position).getList();
        sortYouAdapter02.setList(list);
        holder.sort_you_recyclerView.setAdapter(sortYouAdapter02);
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickLisnter != null){
                    onItemClickLisnter.onItemClick(position);
                    sortYouAdapter02.setOnItemClickLisnter(new SortYouAdapter02.OnItemClickLisnter() {
                        @Override
                        public void onItemClick(int postion) {
                            String name = data.get(position).getName();
                            Intent intent = new Intent(context, SouSuoActivity.class);
                            intent.putExtra("sousuo",name);
                            context.startActivity(intent);
                        }
                    });
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView sort_you_recyclerView;
        private TextView sort_you_recyclerView_text;
        public MyViewHolder(View itemView) {
            super(itemView);
            sort_you_recyclerView = itemView.findViewById(R.id.sort_you02_recyclerView);
            sort_you_recyclerView_text = itemView.findViewById(R.id.sort_you_text);
        }
    }

    public interface OnItemClickLisenter{
        void onItemClick(int posetion);
    }

    public void setOnItemClickLisenter(SortYouAdapter02.OnItemClickLisnter onItemClickLisenter){
        this.onItemClickLisnter = onItemClickLisenter;
    }
}

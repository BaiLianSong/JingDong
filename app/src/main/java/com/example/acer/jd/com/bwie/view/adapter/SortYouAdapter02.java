package com.example.acer.jd.com.bwie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acer.jd.R;
import com.example.acer.jd.ShowActivity;
import com.example.acer.jd.com.bwie.model.bean.SortBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by acer on 2018/10/17.
 */

public class SortYouAdapter02 extends RecyclerView.Adapter<SortYouAdapter02.MyViewHolder> {
    private List<SortBean.DataBean.ListBean> list;
    private Context context;
    public OnItemClickLisnter onItemClickLisnter;

    public SortYouAdapter02(Context context) {
        this.context = context;
    }

    public void setList(List<SortBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sort_you02_recycler_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.sort_you_recyclerView_text.setText(list.get(position).getName());
        Uri parse = Uri.parse(list.get(position).getIcon());
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .build();
        holder.sort_you_recyclerView_simple.setController(controller);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = list.get(position).getName();
                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("sousuo",name);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView sort_you_recyclerView_simple;
        private TextView sort_you_recyclerView_text;
        public MyViewHolder(View itemView) {
            super(itemView);
            sort_you_recyclerView_simple = itemView.findViewById(R.id.sort_you_recyclerView_simple);
            sort_you_recyclerView_text = itemView.findViewById(R.id.sort_you_recyclerView_text);
        }
    }

    public interface OnItemClickLisnter{
        void onItemClick(int postion);
    }

    public void setOnItemClickLisnter(OnItemClickLisnter onItemClickLisnter){
        this.onItemClickLisnter = onItemClickLisnter;
    }
}

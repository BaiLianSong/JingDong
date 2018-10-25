package com.example.acer.jd.com.bwie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.acer.jd.R;
import com.example.acer.jd.XiangQingActivity;
import com.example.acer.jd.com.bwie.model.bean.SouSuoBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by acer on 2018/10/20.
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.MyViewHolder>{
    private Context context;
    private List<SouSuoBean.DataBean> data;

    public ShowAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<SouSuoBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_adapter_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.showAdapterTitle.setText(data.get(position).getTitle());
        holder.showAdapterPrice.setText(data.get(position).getPrice()+"");
        String images = data.get(position).getImages();
        String[] split = images.split("\\|");
        Uri parse = Uri.parse(split[0]);
        AbstractDraweeController fresco = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .build();
        holder.showAdapterSimple.setController(fresco);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pid = data.get(position).getPid();
                Intent intent = new Intent(context, XiangQingActivity.class);
                intent.putExtra("pid",pid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView showAdapterSimple;
        private TextView showAdapterTitle,showAdapterPrice;
        public MyViewHolder(View itemView) {
            super(itemView);
            showAdapterSimple = itemView.findViewById(R.id.show_adapter_simple);
            showAdapterPrice = itemView.findViewById(R.id.show_adapter_price);
            showAdapterTitle = itemView.findViewById(R.id.show_adapter_title);
        }
    }
}

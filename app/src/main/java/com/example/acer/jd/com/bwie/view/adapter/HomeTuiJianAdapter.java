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
import com.example.acer.jd.XiangQingActivity;
import com.example.acer.jd.com.bwie.model.bean.HomeBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by acer on 2018/10/17.
 */

public class HomeTuiJianAdapter extends RecyclerView.Adapter<HomeTuiJianAdapter.MyViewHolder>{
    private Context context;
    private List<HomeBean.DataBean.TuijianBean.ListBeanX> list;

    public void setList(List<HomeBean.DataBean.TuijianBean.ListBeanX> list) {
        this.list = list;
    }

    public HomeTuiJianAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_tuijian_adapter_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.text_tuijian.setText("￥" + list.get(position).getPrice());
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Uri parse = Uri.parse(split[0]);
        final AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .build();
        holder.simple_tuijian.setController(controller);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XiangQingActivity.class);
                int pid = list.get(position).getPid();
                intent.putExtra("pid",pid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView simple_tuijian;
        private TextView text_tuijian;
        public MyViewHolder(View itemView) {
            super(itemView);
            simple_tuijian = itemView.findViewById(R.id.simple_tuijian);
            text_tuijian = itemView.findViewById(R.id.text_tuijian);
        }
    }
}

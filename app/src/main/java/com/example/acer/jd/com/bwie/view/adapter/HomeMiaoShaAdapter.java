package com.example.acer.jd.com.bwie.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acer.jd.R;
import com.example.acer.jd.com.bwie.model.bean.HomeBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by acer on 2018/10/17.
 */

public class HomeMiaoShaAdapter extends RecyclerView.Adapter<HomeMiaoShaAdapter.MyViewHolder> {
    private Context context;
    private List<HomeBean.DataBean.MiaoshaBean.ListBean> list;

    public void setList(List<HomeBean.DataBean.MiaoshaBean.ListBean> list) {
        this.list = list;
    }

    public HomeMiaoShaAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_miaosha_adapter_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.adapter_miaosha_text.setText("￥"+list.get(position).getPrice());
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Uri parse = Uri.parse(split[0]);
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .build();
        holder.simle_miaosha.setController(controller);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView simle_miaosha;
        private TextView adapter_miaosha_text;
        public MyViewHolder(View itemView) {
            super(itemView);
            simle_miaosha = itemView.findViewById(R.id.simple_miaosha);
            adapter_miaosha_text = itemView.findViewById(R.id.adapter_miaosha_text);
        }
    }
}

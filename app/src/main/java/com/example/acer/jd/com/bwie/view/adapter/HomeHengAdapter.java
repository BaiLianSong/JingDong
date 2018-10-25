package com.example.acer.jd.com.bwie.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.acer.jd.R;
import com.example.acer.jd.com.bwie.model.bean.JiuBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by acer on 2018/10/16.
 */

public class HomeHengAdapter extends RecyclerView.Adapter<HomeHengAdapter.MyViewHolder>{
    private Context context;
    private List<JiuBean.DataBean> list;

    public void setList(List<JiuBean.DataBean> list) {
        this.list = list;
    }

    public HomeHengAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_adapter01_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.home_adapter01_text.setText(list.get(position).getName());
        Uri parse = Uri.parse(list.get(position).getIcon());
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .build();
        holder.home_adapter01_image.setController(controller);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView home_adapter01_image;
        private TextView home_adapter01_text;
        public MyViewHolder(View itemView) {
            super(itemView);
            home_adapter01_image = itemView.findViewById(R.id.home_adapter01_image);
            home_adapter01_text = itemView.findViewById(R.id.home_adapter01_text);
        }
    }
}

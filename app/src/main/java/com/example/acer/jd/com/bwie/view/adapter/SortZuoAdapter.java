package com.example.acer.jd.com.bwie.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acer.jd.R;
import com.example.acer.jd.com.bwie.model.bean.JiuBean;
import com.example.acer.jd.com.bwie.presenter.SortPresenter;

import java.util.List;

/**
 * Created by acer on 2018/10/17.
 */

public class SortZuoAdapter extends RecyclerView.Adapter<SortZuoAdapter.MyViewHolder>{
    private Context context;
    private List<JiuBean.DataBean> data;
    private SortPresenter sortPresenter;
    private OnItemClickLisenter onItemClickLisenter;

    public SortZuoAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<JiuBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sort_zuo_recycler_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        sortPresenter = new SortPresenter();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.sort_zuo_recyclerView_text.setText(data.get(position).getName());
        /*holder.sort_zuo_recyclerView_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int cid = data.get(position).getCid();
//                sortPresenter.sortRight(cid);
            }
        });*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickLisenter != null){
                    onItemClickLisenter.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView sort_zuo_recyclerView_text;
        public MyViewHolder(View itemView) {
            super(itemView);
            sort_zuo_recyclerView_text = itemView.findViewById(R.id.sort_zuo_recyclerView_text);
        }
    }

    public interface  OnItemClickLisenter{
        void onItemClick(int postion);
    }

    public void setOnItemClickListener(OnItemClickLisenter onItemClickListener){
        this.onItemClickLisenter = onItemClickListener;
    }
}

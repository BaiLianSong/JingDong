package com.example.acer.jd.com.bwie.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.acer.jd.R;
import com.example.acer.jd.com.bwie.model.bean.CarBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by acer on 2018/10/20.
 */

public class CarRecycler02Adapter extends RecyclerView.Adapter<CarRecycler02Adapter.CarViewHolder02> {
    private Context context;
    private List<CarBean.DataBean.ListBean> list;

    public CarRecycler02Adapter(Context context) {
        this.context = context;
    }

    public void setList(List<CarBean.DataBean.ListBean> list) {
        this.list = list;
    }

    public OnItemClickListener onItemClickListener;

    @Override
    public CarViewHolder02 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_adapter02_layout,parent,false);
        CarViewHolder02 carViewHolder02 = new CarViewHolder02(view);
        return carViewHolder02;
    }

    @Override
    public void onBindViewHolder(final CarViewHolder02 holder, final int position) {
        holder.carAdapter02Title.setText(list.get(position).getTitle());
        holder.carAdapter02Price.setText(list.get(position).getPrice()+"");
        boolean inCheck = list.get(position).isInCheck();
        Log.i("aaa",inCheck+"");
        holder.shangpin_check.setChecked(list.get(position).isInCheck());
        String[] split = list.get(position).getImages().split("\\|");
        Uri parse = Uri.parse(split[0]);
        AbstractDraweeController fresco = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .build();
        holder.carAdapter02Simple.setController(fresco);

        holder.shangpin_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean allInCheck = true;
                    if (holder.shangpin_check.isChecked()){
                        list.get(position).setInCheck(true);
                    }else {
                        list.get(position).setInCheck(false);
                    }

                    notifyItemChanged(position);
                    onItemClickListener.itemClick(position);
                   /* boolean itemInCheck = list.get(i).isInCheck();
                    allInCheck = (allInCheck & itemInCheck);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CarViewHolder02 extends RecyclerView.ViewHolder{
        private SimpleDraweeView carAdapter02Simple;
        private TextView carAdapter02Title,carAdapter02Price;
        private CheckBox shangpin_check;
        public CarViewHolder02(View itemView) {
            super(itemView);
            carAdapter02Simple = itemView.findViewById(R.id.car_adapter02_simple);
            carAdapter02Title = itemView.findViewById(R.id.car_adapter02_title);
            carAdapter02Price = itemView.findViewById(R.id.car_adapter02_price);
            shangpin_check = itemView.findViewById(R.id.shangpin_check);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void itemClick(int postiom);
    }
}

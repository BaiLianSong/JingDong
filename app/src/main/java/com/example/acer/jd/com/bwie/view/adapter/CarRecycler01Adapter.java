package com.example.acer.jd.com.bwie.view.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.acer.jd.R;
import com.example.acer.jd.com.bwie.model.bean.CarBean;

import java.util.List;

/**
 * Created by acer on 2018/10/20.
 */

public class CarRecycler01Adapter extends RecyclerView.Adapter<CarRecycler01Adapter.CarViewHolder>{
    OnCheckedChangeLisenter onCheckedChangeLisenter;
    private Context context;

    public CarRecycler01Adapter(Context context) {
        this.context = context;
    }

    private List<CarBean.DataBean> data;

    public List<CarBean.DataBean> getData() {
        return data;
    }

    public void setData(List<CarBean.DataBean> data) {
        this.data = data;
    }

    private CarRecycler02Adapter carRecycler02Adapter;
    private double price;

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_adapter_layout,parent,false);
        CarViewHolder carViewHolder = new CarViewHolder(view);
        return carViewHolder;
    }

     boolean isChecked=true;
    @Override
    public void onBindViewHolder(final CarViewHolder holder, final int position) {
        holder.shangjia.setText(data.get(position).getSellerName());
        holder.carRecycler02.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));


        final List<CarBean.DataBean.ListBean> list = data.get(position).getList();
        carRecycler02Adapter = new CarRecycler02Adapter(context);
        carRecycler02Adapter.setList(list);
        holder.carRecycler02.setAdapter(carRecycler02Adapter);

        //holder.shangjia_check.setChecked(data.get(position).isOutCheck());


        holder.shangjia_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked){
                    isChecked=false;
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setInCheck(true);
                        price += list.get(i).getPrice();
                    }
                    data.get(position).setOutCheck(true);
                    //isChecked=false;
                }else {
                    isChecked=true;
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setInCheck(false);
                    }
                    data.get(position).setOutCheck(false);
                    //isChecked=true;
                }

                notifyItemChanged(position);

                //carRecycler02Adapter.notifyDataSetChanged();
            }
        });

        holder.shangjia_check.setChecked(data.get(position).isOutCheck());

        for (int i = 0; i < data.get(position).getList().size(); i++) {
            if (!data.get(position).getList().get(i).isInCheck()){
                holder.shangjia_check.setChecked(false);
                break;
            }else {
                holder.shangjia_check.setChecked(true);
            }
        }

        //商品里面的接口回调
        carRecycler02Adapter.setOnItemClickListener(new CarRecycler02Adapter.OnItemClickListener() {
            @Override
            public void itemClick(int itemPostion) {
                notifyDataSetChanged();
                //boolean outCheck = data.get(position).isOutCheck();
                //得到当前商品的选中状态
                boolean inCheck = list.get(itemPostion).isInCheck();
                if (!inCheck){//
                    data.get(position).setOutCheck(false);
                }else {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isInCheck()){
                            data.get(position).setOutCheck(true);
                        }else {
                            data.get(position).setOutCheck(false);
                        }
                    }
                }
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder{
        private TextView shangjia;
        private RecyclerView carRecycler02;
        private CheckBox shangjia_check;
        public CarViewHolder(View itemView) {
            super(itemView);
            shangjia = itemView.findViewById(R.id.car_shangjia);
            carRecycler02 = itemView.findViewById(R.id.car_recycler02);
            shangjia_check = itemView.findViewById(R.id.shangjia_check);
        }
    }

    public interface OnCheckedChangeLisenter {
        void onChecked(int layoutPosition, boolean isChecked);
    }

    public void setOnCheckedChangeLisenter(OnCheckedChangeLisenter onCheckedChangeLisenter) {
        this.onCheckedChangeLisenter = onCheckedChangeLisenter;
    }
}

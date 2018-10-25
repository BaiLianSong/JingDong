package com.example.acer.jd;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.acer.jd.com.bwie.model.bean.ImageBean;
import com.example.acer.jd.com.bwie.model.eventbusbean.MessageBean;
import com.example.acer.jd.com.bwie.view.fragment.CarFragment;
import com.example.acer.jd.com.bwie.view.fragment.DiscoverFragment;
import com.example.acer.jd.com.bwie.view.fragment.HomeFragment;
import com.example.acer.jd.com.bwie.view.fragment.MineFragment;
import com.example.acer.jd.com.bwie.view.fragment.SortFragment;
import com.example.acer.jd.com.bwie.view.iview.IBaseView;
import com.example.acer.jd.com.bwie.view.iview.IHomeView;
import com.hjm.bottomtabbar.BottomTabBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements IBaseView{
    private BottomTabBar bottomTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);
        bottomTabBar = findViewById(R.id.bottomTabBar);
        bottomTabBar.init(getSupportFragmentManager())
                .setFontSize(10)
                .setImgSize(20,20)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.mipmap.home, HomeFragment.class)
                .addTabItem("分类",R.mipmap.classily, SortFragment.class)
                .addTabItem("发现",R.mipmap.sou, DiscoverFragment.class)
                .addTabItem("购物车",R.mipmap.shop, CarFragment.class)
                .addTabItem("我的",R.mipmap.my, MineFragment.class)
                .isShowDivider(true);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void aaa(MessageBean messageBean){
        String flag = messageBean.getFlag();
        if (flag.equals("success")){
            Toast.makeText(this,"成功",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

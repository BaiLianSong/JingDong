package com.example.acer.jd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.acer.jd.com.bwie.model.bean.SouSuoBean;
import com.example.acer.jd.com.bwie.presenter.SouSuoPresenter;
import com.example.acer.jd.com.bwie.view.adapter.ShowAdapter;
import com.example.acer.jd.com.bwie.view.iview.ISouSuo;

import java.util.List;

public class ShowActivity extends AppCompatActivity implements ISouSuo{
    private RecyclerView show_recyclerView;
    private SouSuoPresenter souSuoPresenter;
    private String sousuo;
    private ShowAdapter showAdapter;
    private EditText showActivityEdit;
    private ImageView showActivityImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        Intent intent = getIntent();
        sousuo = intent.getStringExtra("sousuo");
        initData();
    }

    private void initData() {
        showActivityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sousuo = showActivityEdit.getText().toString();
                souSuoPresenter.souSuo(sousuo,1);
            }
        });

        souSuoPresenter = new SouSuoPresenter();
        souSuoPresenter.attachView(this);
        souSuoPresenter.souSuo(sousuo,1);
        show_recyclerView.setLayoutManager(new LinearLayoutManager(ShowActivity.this,LinearLayoutManager.VERTICAL,false));
        showAdapter = new ShowAdapter(this);
    }

    private void initView() {
        show_recyclerView = findViewById(R.id.show_recyclerView);
        showActivityEdit = findViewById(R.id.show_activity_edit);
        showActivityImage = findViewById(R.id.show_activity_image);
    }

    @Override
    public void onSuccess(SouSuoBean souSuoBean) {
        List<SouSuoBean.DataBean> data = souSuoBean.getData();
        showAdapter.setData(data);
        show_recyclerView.setAdapter(showAdapter);
    }

    @Override
    public void onFailure(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        souSuoPresenter.dettachView();
    }
}

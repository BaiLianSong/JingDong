package com.example.acer.jd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.jd.com.bwie.model.bean.SouSuoBean;
import com.example.acer.jd.com.bwie.view.custom.LiuShi;
import com.example.acer.jd.com.bwie.view.iview.ISouSuo;

import java.util.ArrayList;
import java.util.List;

public class SouSuoActivity extends AppCompatActivity{
    private EditText sousuo_acitivity_edit;
    private ImageView sousuo_activity_image;
    private LiuShi liuShi;
    private ViewGroup.MarginLayoutParams layoutParams;
    private List<String> list;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_suo);
        initView();
        initData();
    }

    private void initData() {
        layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin=40;
        layoutParams.rightMargin=40;

        list = new ArrayList<>();

        sousuo_activity_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                liuShi.removeAllViews();
                String sousuo = sousuo_acitivity_edit.getText().toString();
                list.add(sousuo);
                for (int i = list.size()-1; i >-1 ; i--) {
                    textView = new TextView(SouSuoActivity.this);
                    textView.setText(list.get(i));
                    textView.setGravity(Gravity.CENTER); textView.setLayoutParams(layoutParams);
                    liuShi.addchild(textView);
                }
                Intent intent = new Intent(SouSuoActivity.this,ShowActivity.class);
                intent.putExtra("sousuo",sousuo);
                sousuo_acitivity_edit.setText("");
                startActivity(intent);
            }
        });

    }

    private void initView() {
        sousuo_acitivity_edit = findViewById(R.id.sousuo_activity_edit);
        sousuo_activity_image = findViewById(R.id.sousuo_activity_image);
        liuShi = findViewById(R.id.liuShi);
    }

}

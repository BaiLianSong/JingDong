package com.example.acer.jd.com.bwie.view.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acer.jd.LoginOrRegisterActivity;
import com.example.acer.jd.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by acer on 2018/10/12.
 */

public class MineFragment extends Fragment{
    private SimpleDraweeView mainSimple;
    private View view;
    private TextView main_nameText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.mine_fragment_layout,container,false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        mainSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginOrRegisterActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = data.getStringExtra("result");
        main_nameText.setText(result);
        Log.i("msg",result);
    }

    private void initView() {
        mainSimple = view.findViewById(R.id.main_simple);
        main_nameText = view.findViewById(R.id.main_nameText);
    }
}

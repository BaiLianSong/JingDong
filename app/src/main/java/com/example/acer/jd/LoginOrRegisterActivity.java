package com.example.acer.jd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.jd.com.bwie.model.bean.LoginBean;
import com.example.acer.jd.com.bwie.presenter.RegisterOrLoginPresenter;
import com.example.acer.jd.com.bwie.view.iview.ILoginOrRegisterView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class LoginOrRegisterActivity extends AppCompatActivity implements ILoginOrRegisterView{
    private EditText username_edit,password_edit;
    private Button login_btn;
    private TextView register_text;
    private RegisterOrLoginPresenter registerOrLoginPresenter;
    private String username;
    private String password;
    private ImageView qq_image;
    private UMShareAPI umShareAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        umShareAPI = UMShareAPI.get(this);
        initView();
        initData();

    }

    private void initData() {
        registerOrLoginPresenter = new RegisterOrLoginPresenter();
        registerOrLoginPresenter.attachView(this);


        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = username_edit.getText().toString();
                password = password_edit.getText().toString();
                registerOrLoginPresenter.register(username,password);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = username_edit.getText().toString();
                password = password_edit.getText().toString();
                registerOrLoginPresenter.log(username,password);
            }
        });

        qq_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMAuthListener authListener = new UMAuthListener() {
                    /**
                     * @desc 授权开始的回调
                     * @param platform 平台名称
                     */
                    @Override
                    public void onStart(SHARE_MEDIA platform) {

                    }

                    /**
                     * @desc 授权成功的回调
                     * @param platform 平台名称
                     * @param action 行为序号，开发者用不上
                     * @param data 用户资料返回
                     */
                    @Override
                    public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

                        Toast.makeText(LoginOrRegisterActivity.this, "成功了", Toast.LENGTH_LONG).show();
                        Toast.makeText(LoginOrRegisterActivity.this, "授权成功后的回调数据，用户信息"+data, Toast.LENGTH_LONG).show();
                    }

                    /**
                     * @desc 授权失败的回调
                     * @param platform 平台名称
                     * @param action 行为序号，开发者用不上
                     * @param t 错误原因
                     */
                    @Override
                    public void onError(SHARE_MEDIA platform, int action, Throwable t) {

                        Toast.makeText(LoginOrRegisterActivity.this, "失败：" + t.getMessage(),Toast.LENGTH_LONG).show();
                    }

                    /**
                     * @desc 授权取消的回调
                     * @param platform 平台名称
                     * @param action 行为序号，开发者用不上
                     */
                    @Override
                    public void onCancel(SHARE_MEDIA platform, int action) {
                        Toast.makeText(LoginOrRegisterActivity.this, "取消了", Toast.LENGTH_LONG).show();
                    }
                };
                umShareAPI.getPlatformInfo(LoginOrRegisterActivity.this, SHARE_MEDIA.QQ, authListener);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    private void initView() {
        username_edit = findViewById(R.id.username_edit);
        password_edit = findViewById(R.id.password_edit);
        login_btn = findViewById(R.id.login_btn);
        register_text = findViewById(R.id.my_register_text);
        qq_image = findViewById(R.id.qq_image);

    }

    @Override
    public void onLoginSuceess(LoginBean msg) {
        //Toast.makeText(LoginOrRegisterActivity.this,msg,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        //把返回数据存入Intent
        intent.putExtra("result", msg.getData().getUsername());
        //设置返回数据
        LoginOrRegisterActivity.this.setResult(RESULT_OK, intent);
        //关闭Activity
        LoginOrRegisterActivity.this.finish();
    }

    @Override
    public void onFailure(String msg) {
        Toast.makeText(LoginOrRegisterActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterSuccess(String msg) {
        Toast.makeText(LoginOrRegisterActivity.this,msg,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerOrLoginPresenter.dettachView();
    }
}

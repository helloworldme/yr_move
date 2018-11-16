package com.yrkg.move.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yc.yclibrary.base.YcMvpAppCompatActivity;
import com.yc.yclibrary.exception.ApiException;
import com.yrkg.move.R;
import com.yrkg.move.bean.json.LoginBeanJson;
import com.yrkg.move.db.UserInfoPref;
import com.yrkg.move.mvp.contact.MvpLoginC;
import com.yrkg.move.mvp.presenter.MvpLoginP;


import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录界面
 * Created by Administrator on 2018/8/14.
 */

public class LoginActivity extends YcMvpAppCompatActivity<MvpLoginP> implements MvpLoginC.V {
    @BindView(R.id.edt_name)
    EditText edt_name;
    @BindView(R.id.edt_pwd)
    EditText edt_pwd;

    private String user;
    private String pwd;

    @Override
    protected MvpLoginP loadPresenter() {
        return new MvpLoginP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        //获取用户名和密码
        user = UserInfoPref.getUserAccount();
        pwd = UserInfoPref.getUserPassword();
        if (!TextUtils.isEmpty(user)) {
            edt_name.setText(user);
            edt_pwd.setText(pwd);
            mPresenter.login(user, pwd);
        }
    }

    @Override
    public void onLoginSuccess(LoginBeanJson json) {
        //tvLoginResult.setText("结果：" + json.toString());
        Log.d("LoginSuccess", "结果：" + json.toString());
        UserInfoPref.saveLoginInfo(json.getUser_name(),json.getUid(),json.getPk_corp(),user,pwd);
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void onLoginFail(ApiException apiException) {
        Log.d("onLoginFail", "结果：" + apiException.getMessage());
    }

    @OnClick({ R.id.btn_login})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
//                Log.e("1111",":::"+edt_name.getText().toString());
//                // mPresenter.login(edt_name.getText().toString(), edt_pwd.getText().toString());
//                //判断非空
//                user=edt_name.getText().toString();
//                pwd=edt_pwd.getText().toString();
//                if (TextUtils.isEmpty(user)) {
//                    Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (TextUtils.isEmpty(pwd)) {
//                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
//                    return;
//                }
               // mPresenter.login(user, pwd);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case R.id.forget_pwd:
                Toast.makeText(this,"正在开发......",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

package com.yrkg.move.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yc.yclibrary.base.YcMvpAppCompatActivity;
import com.yc.yclibrary.mvp.BasePresenter;
import com.yrkg.move.R;


/**
 * Created by Administrator on 2018/9/6.
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends YcMvpAppCompatActivity<P> {
    protected TextView mTitle;
    protected ImageView mLeftBtn;
    /**
     * 设置标题栏
     */
    protected void setToolBar(String title) {
        mTitle = (TextView) findViewById(R.id.tv_tital);
        mTitle.setText(title);
        mLeftBtn = (ImageView) findViewById(R.id.tital_png);
        findViewById(R.id.tital_png).setOnClickListener(v -> onLeftClick(v));
    }
    /**
     * 标题左边按钮事件（含左边文字）
     */
    public void onLeftClick(View v) {
        finish();
    }
}

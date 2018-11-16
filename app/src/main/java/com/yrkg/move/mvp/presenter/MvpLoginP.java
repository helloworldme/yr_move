package com.yrkg.move.mvp.presenter;

import com.yc.yclibrary.exception.ApiException;
import com.yc.yclibrary.mvp.BasePresenter;
import com.yrkg.move.bean.json.LoginBeanJson;
import com.yrkg.move.http.NetObserver;
import com.yrkg.move.http.NetReponse;
import com.yrkg.move.mvp.contact.MvpLoginC;
import com.yrkg.move.mvp.model.MvpLoginM;


/**
 *
 */

public class MvpLoginP extends BasePresenter<MvpLoginC.V> implements MvpLoginC.P {
    @Override
    public void login(String usercode, String password) {
        getIView().showLoading("加载中...");
        new MvpLoginM().login(usercode, password)
                .compose(getIView().bindLifecycle())
                .subscribe(new NetObserver<NetReponse<LoginBeanJson>>() {
                    @Override
                    public void onSuccess(NetReponse<LoginBeanJson> json) {
                        getIView().hideLoading();
                        getIView().onLoginSuccess(json.getData());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onLoginFail(msg);
                    }
                });
    }
}

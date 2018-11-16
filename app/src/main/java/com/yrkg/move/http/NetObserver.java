package com.yrkg.move.http;

import com.yc.yclibrary.exception.ApiException;
import com.yc.yclibrary.net.BaseObserver;

/**
 * Created by Administrator on 2018/8/28.
 */

public abstract class NetObserver<T extends NetReponse> extends BaseObserver<T>{
    @Override
    public void onNext(T response) {
        if(response.getCode()==200)
            super.onNext(response);
        else {
            onError(new ApiException(response.getMsg(),response.getCode()));
        }
    }
}

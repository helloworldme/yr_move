package com.yrkg.move.mvp.model;


import com.yc.yclibrary.mvp.IModel;
import com.yc.yclibrary.net.NetTransformer;
import com.yc.yclibrary.net.RetrofitUtils;
import com.yrkg.move.http.ApiServer;
import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

/**
 *
 */

public class MvpLoginM implements IModel {
    public Observable login(String usercode, String password) {
        JSONObject json = new JSONObject();
        try {
            json.put("usercode",usercode);
            json.put("password",password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return RetrofitUtils.Instance
                .getApiService(ApiServer.class)
                .login(json.toString())
                .compose(NetTransformer.compose());
    }
}

package com.yrkg.move.http;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/8/28.
 */

public class NetReponse<T> {
    @SerializedName("data")
    private T data;
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

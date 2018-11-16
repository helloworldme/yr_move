package com.yrkg.move.bean.json;

/**
 * Created by Administrator on 2018/8/21.
 */

public class LoginBeanJson {

    /**
     * data : {"uid":"0001AA10000000014AMD","user_name":"apptest","pk_corp":"1001"}
     * code : 200
     * msg : 成功
     */
        private String uid;
        private String user_name;
        private String pk_corp;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPk_corp() {
        return pk_corp;
    }

    public void setPk_corp(String pk_corp) {
        this.pk_corp = pk_corp;
    }

    @Override
    public String toString() {
        return "LoginBeanJson11{" +
                "uid='" + uid + '\'' +
                ", user_name='" + user_name + '\'' +
                ", pk_corp='" + pk_corp + '\'' +
                '}';
    }
}

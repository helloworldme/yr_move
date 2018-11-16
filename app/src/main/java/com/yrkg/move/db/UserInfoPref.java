package com.yrkg.move.db;


import io.reactivex.annotations.NonNull;

/**
 * 用户信息
 */

public class UserInfoPref {
    private static final String mUserName = "mUserName";//用户名
    private static final String mUId = "mUId";//用户名id
    private static final String mPkCorp = "mPkCorp";//公司主键
    private static final String mUserAccount = "";//用户账号
    private static final String mUserPassword = "";//用户密码

    private static PrefHelper mPrefHelper = PrefHelper.Instance;

    public static String getUserName() {
        return mPrefHelper.getPref(mUserName, mUserName);
    }

    public static void setUserName(@NonNull String userName) {
        mPrefHelper.setPref(mUserName, userName);
    }
    public static String getUId() {
        return mPrefHelper.getPref(mUId, mUId);
    }

    public static void setUId(@NonNull String userId) {
        mPrefHelper.setPref(mUId, userId);
    }

    public  static  String getPkCorp(){
        return mPrefHelper.getPref(mPkCorp,mPkCorp);
    }
    public  static void setPkCorp(@NonNull String pk_corp){
       mPrefHelper.setPref(mPkCorp,pk_corp);
    }



    public static String getUserAccount() {
        return mPrefHelper.getPref(mUserAccount, mUserAccount);
    }

    public static void setUserAccount(@NonNull String UserAccount) {
        mPrefHelper.setPref(mUserAccount, UserAccount);
    }


    public static String getUserPassword() {
        return mPrefHelper.getPref(mUserPassword, mUserPassword);
    }

    public static void setUserPassword(@NonNull String userPassword) {
        mPrefHelper.setPref(mUserPassword, userPassword);
    }


    /**
     * 保存用户登录信息
     */
    public static void saveLoginInfo(String mUserName, String mUId, String mPkCorp, String mUserAccount,String mUserPassword) {
        setUserAccount(mUserAccount);
        setUId(mUId);
        setUserPassword(mUserPassword);
        setPkCorp(mPkCorp);
        setUserName(mUserName);
    }

    /**
     * 清除用户登录信息
     */
    public static void clearloginInfo() {
        setUserAccount("");
        setUId("");
        setUserPassword("");
        setPkCorp("");
        setUserName("");
    }
}

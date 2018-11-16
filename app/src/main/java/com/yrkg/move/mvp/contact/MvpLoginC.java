package com.yrkg.move.mvp.contact;

import com.yc.yclibrary.exception.ApiException;
import com.yc.yclibrary.mvp.IView;
import com.yrkg.move.bean.json.LoginBeanJson;


/**
 *
 */

public class MvpLoginC {
    public interface V extends IView {
        /**
         * 登录成功
         */
        void onLoginSuccess(LoginBeanJson json);

        /**
         * 登录失败
         */
        void onLoginFail(ApiException apiException);
    }

    public interface P {
        void login(String usercode, String password);
    }
}

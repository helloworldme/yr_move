package com.yrkg.move.http;




import com.yrkg.move.bean.json.LoginBeanJson;
import com.yrkg.move.url.UrlHelper;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 */

public interface ApiServer {

    //登录
    @POST(UrlHelper.BASE_API + "login")
    Observable<NetReponse<LoginBeanJson>> login(@Query("par") String par);





}

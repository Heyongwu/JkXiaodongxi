package bwei.com.jkxiaodongxi.model;

import bwei.com.jkxiaodongxi.bean.JavaBean;
import bwei.com.jkxiaodongxi.bean.LoginBean;
import bwei.com.jkxiaodongxi.network.Api;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Yw_Ambition on 2017/12/1.
 */

public interface ServiceAPI {
    @GET(Api.URL)
    Call<JavaBean>  bean();
    @GET(Api.HOSTURL)
    Call<LoginBean> loginbean(@Query("mobile") String mobile,
                              @Query("password") String pwd);


}

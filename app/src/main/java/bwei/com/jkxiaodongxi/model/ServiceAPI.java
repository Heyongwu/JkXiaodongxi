package bwei.com.jkxiaodongxi.model;

import bwei.com.jkxiaodongxi.bean.DataBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Yw_Ambition on 2017/12/1.
 */

public interface ServiceAPI {
    @GET("api/data/Android/{size}/{page}")
    Call<DataBean> databean(@Path("size") int size,@Path("page") int page);

}

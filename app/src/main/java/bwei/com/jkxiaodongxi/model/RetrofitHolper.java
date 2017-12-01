package bwei.com.jkxiaodongxi.model;

import bwei.com.jkxiaodongxi.network.Api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yw_Ambition on 2017/12/1.
 */

public class RetrofitHolper {
    private static OkHttpClient okHttpClient;
    private static ServiceAPI serviceAPI;
    static {
        initOKHttpClient();
    }

    public static OkHttpClient initOKHttpClient() {
        if(okHttpClient == null){
            synchronized (RetrofitHolper.class){
                if(okHttpClient == null){
                    okHttpClient = new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
    public static ServiceAPI getServiceAPI(){
        if(serviceAPI == null){
            synchronized (ServiceAPI.class){
                if(serviceAPI == null){
                    serviceAPI = OncreatApi(ServiceAPI.class, Api.HOST);
                }
            }
        }
        return serviceAPI;
    }

    public static<T> T OncreatApi(Class<T> tClass,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}

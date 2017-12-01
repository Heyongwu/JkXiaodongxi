package bwei.com.jkxiaodongxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import bwei.com.jkxiaodongxi.bean.JavaBean;
import bwei.com.jkxiaodongxi.bean.LoginBean;
import bwei.com.jkxiaodongxi.model.RetrofitHolper;
import bwei.com.jkxiaodongxi.model.ServiceAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ServiceAPI serviceAPI = RetrofitHolper.getServiceAPI();
        Call<JavaBean> bean = serviceAPI.bean();
        bean.enqueue(new Callback<JavaBean>() {
            @Override
            public void onResponse(Call<JavaBean> call, Response<JavaBean> response) {
                Log.i("TAG",response.body().getResults().get(0).toString());
            }

            @Override
            public void onFailure(Call<JavaBean> call, Throwable t) {

            }
        });

        Call<LoginBean> loginbean = serviceAPI.loginbean("13366645979", "123456");
        loginbean.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                String msg = response.body().getMsg();
                Log.i("TAG",msg);
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {

            }
        });
    }
}

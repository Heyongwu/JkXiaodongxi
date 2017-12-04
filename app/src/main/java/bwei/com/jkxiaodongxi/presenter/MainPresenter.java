package bwei.com.jkxiaodongxi.presenter;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import bwei.com.jkxiaodongxi.bean.DataBean;
import bwei.com.jkxiaodongxi.model.RetrofitHolper;
import bwei.com.jkxiaodongxi.model.ServiceAPI;
import bwei.com.jkxiaodongxi.network.Message;
import bwei.com.jkxiaodongxi.network.NetworkUtils;
import bwei.com.jkxiaodongxi.view.IMainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Yw_Ambition on 2017/12/2.
 */

public class MainPresenter {
    private static IMainActivity iMainActivity;

    public MainPresenter(IMainActivity iMainActivity) {

        this.iMainActivity = iMainActivity;
    }
    public void getShowData(Context context){
        if(!NetworkUtils.isAvailable(context)){
            EventBus.getDefault().postSticky(new Message("网络未连接"));
            iMainActivity.showa();
        }
        ServiceAPI serviceAPI = RetrofitHolper.getServiceAPI();
        Call<DataBean> databean = serviceAPI.databean(10,1);
        databean.enqueue(new Callback<DataBean>() {
            @Override
            public void onResponse(Call<DataBean> call, Response<DataBean> response) {
                List<DataBean.ResultsBean> results = response.body().getResults();
                iMainActivity.showData(results);
            }

            @Override
            public void onFailure(Call<DataBean> call, Throwable t) {

            }
        });

    }
}

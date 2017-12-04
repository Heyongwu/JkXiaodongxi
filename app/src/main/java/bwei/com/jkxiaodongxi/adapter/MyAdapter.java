package bwei.com.jkxiaodongxi.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zgl.greentest.gen.UserDao;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import bwei.com.jkxiaodongxi.R;
import bwei.com.jkxiaodongxi.bean.DataBean;
import bwei.com.jkxiaodongxi.network.App;
import bwei.com.jkxiaodongxi.view.User;

/**
 * Created by Yw_Ambition on 2017/12/2.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DataBean.ResultsBean> list ;
    private Context context;


    public MyAdapter(List<DataBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        DataBean.ResultsBean resultsBean = list.get(position);
        String images = "http://img.gank.io/fef497ed-83ba-46f6-8a94-0e7b724e1c10";
        myViewHolder.sv.setImageURI(Uri.parse(images));
        myViewHolder.tv.setText(list.get(position).getDesc());
        //添加数据库
        UserDao userDao = App.getInstances().getDaoSession().getUserDao();
        String desc = list.get(position).getDesc();
        User user = new User(desc);
        userDao.insert(user);
        EventBus.getDefault().postSticky("网络正常");
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sv;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            sv = itemView.findViewById(R.id.layout_sv);
            tv = itemView.findViewById(R.id.layout_tv);
        }
    }
}

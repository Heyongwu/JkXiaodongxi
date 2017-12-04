package bwei.com.jkxiaodongxi.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.zgl.greentest.gen.UserDao;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwei.com.jkxiaodongxi.R;
import bwei.com.jkxiaodongxi.adapter.MyAdapter;
import bwei.com.jkxiaodongxi.bean.DataBean;
import bwei.com.jkxiaodongxi.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    private UserDao userDao;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        MainPresenter presenter = new MainPresenter(this);
        presenter.getShowData(this);
        

    }
    @Override
    public void showData(List<DataBean.ResultsBean> list) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rlv.setLayoutManager(manager);
        MyAdapter adapter = new MyAdapter(list, MainActivity.this);
        rlv.setAdapter(adapter);
    }

    @Override
    public void showa() {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
    }
    @Subscribe(sticky = true)
    public void Message(bwei.com.jkxiaodongxi.network.Message event) {
        msg = event.getMsg();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }
}


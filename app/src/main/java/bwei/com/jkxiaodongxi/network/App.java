package bwei.com.jkxiaodongxi.network;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zgl.greentest.gen.DaoMaster;
import com.zgl.greentest.gen.DaoSession;

/**
 * Created by Yw_Ambition on 2017/12/2.
 */

public class App extends Application {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static App instances;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        instances = this;
        setDatabase();
    }
    public static App getInstances(){
        return instances;
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {

        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();

        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }

}

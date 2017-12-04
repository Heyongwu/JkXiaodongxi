package bwei.com.jkxiaodongxi.view;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Yw_Ambition on 2017/12/2.
 */
@Entity
public class User {

    private String user;

    @Generated(hash = 287260832)
    public User(String user) {
        this.user = user;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}

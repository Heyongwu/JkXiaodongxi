package bwei.com.jkxiaodongxi.network;

/**
 * Created by Yw_Ambition on 2017/12/2.
 */

public class Message {
    private String Msg;

    public Message(String msg) {
        Msg = msg;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Msg='" + Msg + '\'' +
                '}';
    }
}

package cn.gas.myvolley.volley;

/**
 * Created by Administrator on 2017/3/28.
 */

public interface VolleyListener<T> {

    void onDataListener(T response);

    void onErrListener(String errMsg);


}

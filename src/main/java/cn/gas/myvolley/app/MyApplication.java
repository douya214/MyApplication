package cn.gas.myvolley.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2017/3/29.
 */

public class MyApplication extends Application {

    private static RequestQueue requestQueue;


    @Override
    public void onCreate() {
        super.onCreate();


        requestQueue = Volley.newRequestQueue(this);

    }


    public static RequestQueue getQueue() {

        return requestQueue;
    }

}

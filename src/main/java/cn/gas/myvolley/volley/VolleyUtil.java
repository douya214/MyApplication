package cn.gas.myvolley.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import cn.gas.myvolley.app.MyApplication;

/**
 * Created by Administrator on 2017/3/28.
 */

public class VolleyUtil {


    public static void gsonGET(String url, Class clazz, final VolleyListener volleyListener, int responseTime) {


        GsonRequest request = new GsonRequest(url, clazz, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                if (response != null) {
                    volleyListener.onDataListener(response);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyListener.onErrListener(error.getMessage().toString());
            }
        });


        request.setRetryPolicy(new DefaultRetryPolicy(responseTime * 1000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MyApplication.getQueue().add(request);

    }

    public static void gsonPost(String url, final HashMap<String, String> paramsMap, Class clazz, final VolleyListener volleyListener, int responseTime) {


        GsonRequest request = new GsonRequest(Request.Method.POST, url, clazz, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                if (response != null) {
                    volleyListener.onDataListener(response);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyListener.onErrListener(error.getMessage().toString());

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return paramsMap;
            }
        };


        request.setRetryPolicy(new DefaultRetryPolicy(responseTime * 1000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MyApplication.getQueue().add(request);

    }


    public static void stringGet(String url, final VolleyListener volleyListener, int responseTime) {


        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {

                    volleyListener.onDataListener(response);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyListener.onErrListener(error.getMessage().toString());

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(responseTime * 1000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MyApplication.getQueue().add(request);

    }


    public static void stringPost(String url, final HashMap<String, String> paramsMap, final VolleyListener volleyListener, final int responseTime) {


        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    volleyListener.onDataListener(response);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyListener.onErrListener(error.getMessage().toString());
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return paramsMap;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(responseTime * 1000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MyApplication.getQueue().add(request);
    }


}

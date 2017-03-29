package cn.gas.myvolley.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/3/27.
 */

public class GsonRequest<T> extends Request<T> {

    private Response.Listener<T> mListener;
    private Gson gson;
    private Class<T> clazz;

    public GsonRequest(int method, String url, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errListener) {
        super(method, url, errListener);
        mListener = listener;
        this.clazz = clazz;
        gson = new Gson();
    }

    public GsonRequest(String url, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errListenerr) {
        this(Method.GET, url, clazz, listener, errListenerr);

    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String json;

        try {
            json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));

            T t = gson.fromJson(json, clazz);

            return Response.success(t, HttpHeaderParser.parseCacheHeaders(response));


        } catch (UnsupportedEncodingException e) {

            return Response.error(new ParseError(e));
        }

    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}

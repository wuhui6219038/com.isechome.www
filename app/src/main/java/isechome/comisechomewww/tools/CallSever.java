package isechome.comisechomewww.tools;

import android.content.Context;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;

public class CallSever {
    private static CallSever callServer;
    private RequestQueue mRequestQueue;

    private CallSever() {
        mRequestQueue = NoHttp.newRequestQueue();
    }

    public synchronized static CallSever newCallSeverInstance() {
        if (callServer == null) {
            callServer = new CallSever();
        }
        return callServer;
    }

    /**
     * 将联网任务加载到队列中
     *
     * @param what
     * @param request
     * @param context
     * @param callback
     * @param isShowDialog 是否显示加载框
     * @param <T>
     */
    public <T> void add(int what, Request<T> request, Context context,
                        HttpListener<T> callback, boolean isShowDialog) {
        mRequestQueue.add(what, request, new HttpResponseListener<T>(context,
                callback, isShowDialog, request));
    }

    public void cancelAll() {
        mRequestQueue.cancelAll();
    }

    public void stopAll() {
        mRequestQueue.stop();
    }
}

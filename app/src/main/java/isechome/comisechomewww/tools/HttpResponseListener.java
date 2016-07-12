package isechome.comisechomewww.tools;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

/**
 * @param <T> 联网监听
 */
public class HttpResponseListener<T> implements OnResponseListener<T> {
    private HttpListener<T> callback;
    private Context mContext;
    private Dialog mDialog;
    private Request<T> request;

    public HttpResponseListener(Context context, HttpListener<T> callback,
                                boolean isShowDialog, Request<T> request) {
        this.callback = callback;
        mContext = context;
        if (isShowDialog)
            initDialog();
    }

    private void initDialog() {
        // TODO
        if (mDialog == null) {
            mDialog.setOnCancelListener(new OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    request.cancel();
                }
            });
        }
    }

    @Override
    public void onStart(int what) {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    @Override
    public void onSucceed(int what, Response<T> response) {
        if (callback != null) {
            callback.onSucceed(what, response);
        }
    }

    @Override
    public void onFailed(int what, String url, Object tag, Exception exception,
                         int responseCode, long networkMillis) {
        if (callback != null) {
            callback.onFail(what, url, tag, exception, responseCode,
                    networkMillis);
        }

    }

    @Override
    public void onFinish(int what) {
        if (mDialog != null && mDialog.isShowing())
            mDialog.dismiss();

    }

}

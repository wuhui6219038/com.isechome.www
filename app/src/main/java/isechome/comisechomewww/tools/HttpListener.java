package isechome.comisechomewww.tools;

import com.yolanda.nohttp.rest.Response;

/**
 * 联网回调接口，在调用nohttp的时候 只需要实现这个接口即可
 *
 * @param <T>
 */
public interface HttpListener<T> {
    public void onSucceed(int what, Response<T> response);

    /**
     * @param what
     */
    public void onFail(int what, String url, Object tag, Exception exception,
                       int responseCode, long networkMillis);

}

package isechome.comisechomewww.callback;

/**
 * Created by Administrator on 2016/7/14.
 *
 * @description 倒计时完成接口
 */

public interface onCountDownListener {
    /**
     * @param count    当前计数
     * @param isFinish 是否结束
     */
    public void onCountDown(int count, boolean isFinish);


}

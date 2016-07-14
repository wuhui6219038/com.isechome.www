package isechome.comisechomewww.tools;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

import isechome.comisechomewww.bean.Constant;
import isechome.comisechomewww.callback.onCountDownListener;

/**
 * @author wuhui
 * @ClassName: TimerUtils
 * @Description: 计时器
 * @date 2016年1月4日 下午3:25:58
 */

public class TimerUtils {
    private TimerTask task;
    private Handler handler;
    private int time_count;
    private Timer timer;
    /**
     * 倒计时时间
     */
    private int Sec = Constant.TIMECOUNT;
    private onCountDownListener mCountDownListener;
    private boolean isFinish = false;

    public TimerUtils(onCountDownListener listener) {
        this.mCountDownListener = listener;
    }

    private void initTimer() {
        timer = new Timer(true);
        time_count = Sec;
        init_handler();
        task = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = --time_count;
                handler.sendMessage(message);
            }
        };
    }


    private void init_handler() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                int count = msg.what;
                if (count == 0) {
                    // 计数完成
                    isFinish = true;
                    stop();
                } else {
                    isFinish = false;
                }
                if (mCountDownListener != null) {
                    mCountDownListener.onCountDown(count, isFinish);
                } else {
                    stop();
                }
            }
        };
    }

    public void start() {
        stop();
        initTimer();
        timer.schedule(task, 0, 1000);
    }

    private void stop() {
        if (timer != null)
            timer.cancel();
    }


}

package isechome.comisechomewww.tools;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * @author wuhui
 * @ClassName: ToastUtil
 * @Description: 处理toast提示
 * @date 2016年4月1日 上午10:48:39
 */

public class ToastUtil {
    private static Toast mToast;
    private static Handler mhandler = new Handler();
    private static Runnable r = new Runnable() {
        public void run() {
            mToast.cancel();
        }

        ;
    };

    private static void showToast(Context context, String text, int duration) {
        mhandler.removeCallbacks(r);
        if (null != mToast) {
            mToast.setText(text);
        } else {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        mhandler.postDelayed(r, 5000);
        mToast.show();
    }

    public static void showMsg_By_ID(Context context, int strId, int duration) {
        showToast(context, context.getString(strId), duration);
    }

    public static void showMsg_By_String(Context context, String str,
                                         int duration) {
        showToast(context, str, duration);
    }
}

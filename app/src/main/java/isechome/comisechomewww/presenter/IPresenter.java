package isechome.comisechomewww.presenter;

import android.view.View;

/**
 * Created by wuhui on 16/7/13.
 */
public interface IPresenter {
    /**
     * 注册页面
     */
    static final int TITLE_TYPE_REGISTER = 1;
    /**
     * 登录
     */
    static final int TITLE_TYPE_LOGIN = 2;

    public void getTitle(int type);

    public void setYanZhengMaInfo(View view, int count, boolean isFinish);

}

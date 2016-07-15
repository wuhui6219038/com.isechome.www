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
    /**
     * 密码找回
     */
    static final int TITLE_TYPE_REGETPASSWORD = 3;

    public void getTitle(int type);


}

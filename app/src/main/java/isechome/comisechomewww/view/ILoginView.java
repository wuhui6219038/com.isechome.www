package isechome.comisechomewww.view;

/**
 * Created by wuhui on 16/7/9.
 * 用户登陆界面
 */
public interface ILoginView extends IBaseView {
    /**
     * 初始化页面控件
     */
    void initView();

    /**
     * 显示密码
     *
     * @param show
     */
    void showPassWord(boolean show);

    /**
     * 清空用户名
     */
    void clearUserName();

}


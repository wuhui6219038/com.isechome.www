package isechome.comisechomewww.presenter;

/**
 * Created by wuhui on 16/7/13.
 */
public interface IPresenter {
    /**
     * 注册页面
     */
    static final int TITLE_TYPE_REGISTER = 1;

    public void getTitle(int type);
}

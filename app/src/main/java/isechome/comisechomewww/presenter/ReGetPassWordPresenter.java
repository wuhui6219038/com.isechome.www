package isechome.comisechomewww.presenter;

import android.content.Context;
import android.view.View;

import isechome.comisechomewww.view.IReGetPassWordView;

/**
 * Created by Administrator on 2016/7/15.
 */

public class ReGetPassWordPresenter extends BasePresenter {
    private IReGetPassWordView mIReGetPassWordView;
    private Context mContext;

    public ReGetPassWordPresenter(Context view) {
        super(view);
        mIReGetPassWordView = (IReGetPassWordView) view;
        mContext = (Context) view;
    }


    //验证码设置
    public void setYanZhengMa(View view) {
        //TODO
    }

}

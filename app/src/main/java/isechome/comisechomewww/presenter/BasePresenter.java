package isechome.comisechomewww.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import isechome.comisechomewww.R;
import isechome.comisechomewww.view.IBaseView;

/**
 * Created by Administrator on 2016/7/15.
 */

public class BasePresenter implements IPresenter {
    private Intent intent;
    private Context mContext;
    private IBaseView mTitleView;

    public BasePresenter(Context context) {
        mContext = context;
        mTitleView = (IBaseView) context;
    }

    public void jump2Where(Class ac, Bundle data) {
        if (intent == null) {
            intent = new Intent();
        }
        if (data != null) {
            intent.putExtras(data);
        }
        intent.setClass(mContext, ac);
        mContext.startActivity(intent);
    }

    public void setYanZhengMaInfo(View view, int count, boolean isFinish) {
        if (isFinish) {
            ((Button) view).setText(mContext.getResources().getString(R.string.action_getcode));
            view.setEnabled(true);
        } else {
            ((Button) view).setText(mContext.getResources().getString(R.string.info_yanzhengma, count + ""));
        }
    }

    @Override
    public void getTitle(int type) {
        switch (type) {
            case TITLE_TYPE_REGISTER:
                mTitleView.setTitle(mContext.getResources().getString(R.string.title_register));
                break;
            case TITLE_TYPE_LOGIN:
                mTitleView.setTitle(mContext.getResources().getString(R.string.title_login));
                break;
            case TITLE_TYPE_REGETPASSWORD:
                mTitleView.setTitle(mContext.getResources().getString(R.string.action_re_password));
                break;
            default:
                break;

        }
    }
}

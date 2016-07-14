package isechome.comisechomewww.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import isechome.comisechomewww.R;
import isechome.comisechomewww.model.IRegisterModel;
import isechome.comisechomewww.view.ILoginView;
import isechome.comisechomewww.view.IRegisterView;

/**
 * Created by Administrator on 2016/7/13.
 */

public class RegistPresenter implements IPresenter {
    private IRegisterView mResgisetView;
    private IRegisterModel mResgisetModel;
    private Context mContext;
    private Intent intent;

    public RegistPresenter(IRegisterView view) {
        mResgisetView = view;
        mContext = (Context) view;
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

    @Override
    public void getTitle(int type) {
        if (type == TITLE_TYPE_REGISTER)
            mResgisetView.setTitle(mContext.getResources().getString(R.string.title_register));
    }

    public void setYanZhengMaInfo(View view, int count, boolean isFinish) {
        if (isFinish) {
            ((Button) view).setText(mContext.getResources().getString(R.string.action_getcode));
            view.setEnabled(true);
        } else {
            ((Button) view).setText(mContext.getResources().getString(R.string.info_yanzhengma, count + ""));
        }
    }
}

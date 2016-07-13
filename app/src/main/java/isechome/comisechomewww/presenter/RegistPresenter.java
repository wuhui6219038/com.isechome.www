package isechome.comisechomewww.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.widget.CheckBox;
import android.widget.EditText;

import isechome.comisechomewww.R;
import isechome.comisechomewww.model.ILoginModel;
import isechome.comisechomewww.view.ILoginView;

/**
 * Created by Administrator on 2016/7/13.
 */

public class RegistPresenter implements IPresenter {
    private ILoginView mLoginView;
    private ILoginModel mLoginModel;
    private Context mContext;
    private Intent intent;

    public RegistPresenter(ILoginView view) {
        mLoginView = view;

        mContext = (Context) view;
    }

    public Drawable getCode() {
        Drawable drawable = null;
        return drawable;
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
            mLoginView.setTitle(mContext.getResources().getString(R.string.title_register));
    }
}

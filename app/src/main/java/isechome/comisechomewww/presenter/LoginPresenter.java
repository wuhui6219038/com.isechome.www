package isechome.comisechomewww.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import isechome.comisechomewww.model.ILoginModel;
import isechome.comisechomewww.view.ILoginView;

/**
 * Created by Administrator on 2016/7/13.
 */

public class LoginPresenter {
    private ILoginView mLoginView;
    private ILoginModel mLoginModel;
    private Intent intent;

    public LoginPresenter(ILoginView view) {
        mLoginView = view;
    }

    /**
     * @param cb
     * @param view
     * @desc 是否显示密码
     */
    public void showPsd(CheckBox cb, EditText view) {
        if (cb.isChecked()) {
            view.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        } else {
            view.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    public void jump2Where(Class ac, Bundle data) {
        if (intent == null) {
            intent = new Intent();
        }
        if (data != null) {
            intent.putExtras(data);
        }
        intent.setClass((Context) mLoginView, ac);
        ((Context) mLoginView).startActivity(intent);
    }
}

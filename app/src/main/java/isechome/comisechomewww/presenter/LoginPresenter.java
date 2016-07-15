package isechome.comisechomewww.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import isechome.comisechomewww.R;
import isechome.comisechomewww.model.ILoginModel;
import isechome.comisechomewww.view.ILoginView;

/**
 * Created by Administrator on 2016/7/13.
 */

public class LoginPresenter extends BasePresenter {
    private ILoginView mLoginView;
    private ILoginModel mLoginModel;
    private Context mContext;
    private Intent intent;

    public LoginPresenter(Context view) {
        super(view);
        mLoginView = (ILoginView) view;

        mContext = (Context) view;
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


}

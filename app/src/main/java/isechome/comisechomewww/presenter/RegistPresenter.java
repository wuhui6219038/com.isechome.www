package isechome.comisechomewww.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import isechome.comisechomewww.R;
import isechome.comisechomewww.model.IRegisterModel;
import isechome.comisechomewww.view.IBaseView;
import isechome.comisechomewww.view.IRegisterView;

/**
 * Created by Administrator on 2016/7/13.
 */

public class RegistPresenter extends BasePresenter {
    private IRegisterView mResgisetView;
    private IRegisterModel mResgisetModel;
    private Context mContext;
    private Intent intent;

    public RegistPresenter(Context view) {
        super(view);
        mResgisetView = (IRegisterView) view;
        mContext = view;
    }



}

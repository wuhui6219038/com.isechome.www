package isechome.comisechomewww.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import isechome.comisechomewww.R;
import isechome.comisechomewww.presenter.RegistPresenter;

/**
 * Created by Administrator on 2016/7/13.
 */

public class FastRegisterActivity extends BaseActivity {

    @BindView(R.id.quhao_textview)
    TextView quhaoTextview;
    @BindView(R.id.phoneNum_textview)
    EditText phoneNumTextview;
    @BindView(R.id.yanzhengma_editview)
    EditText yanzhengmaEditview;
    @BindView(R.id.yanzhengma_iv)
    ImageView yanzhengmaIv;
    @BindView(R.id.accpet_cb)
    CheckBox accpetCb;
    @BindView(R.id.xieyi_tv)
    TextView xieyiTv;
    @BindView(R.id.hotlint_tv)
    TextView hotlintTv;
    @BindView(R.id.title_textview)
    TextView tilte;
    private RegistPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_fast_regist);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @OnClick({R.id.quhao_textview, R.id.phoneNum_textview, R.id.yanzhengma_iv, R.id.accpet_cb, R.id.xieyi_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quhao_textview:
                break;
            case R.id.phoneNum_textview:
                break;
            case R.id.yanzhengma_iv:


                break;
            case R.id.accpet_cb:
                break;
            case R.id.xieyi_tv:
                break;
        }
    }
}

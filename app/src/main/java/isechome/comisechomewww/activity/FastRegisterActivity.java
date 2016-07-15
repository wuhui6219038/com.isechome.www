package isechome.comisechomewww.activity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import isechome.comisechomewww.R;
import isechome.comisechomewww.presenter.IPresenter;
import isechome.comisechomewww.presenter.RegistPresenter;
import isechome.comisechomewww.tools.ToastUtil;
import isechome.comisechomewww.view.IRegisterView;

/**
 * Created by Administrator on 2016/7/13.
 */

public class FastRegisterActivity extends BaseActivity implements IRegisterView {
    /**
     * 手机号码标示
     */
    public static final String REGISTER_PHONE = "phoneNum";
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
    @BindView(R.id.next_btn)
    Button nextBtn;
    private RegistPresenter presenter;
//控件


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_fast_regist);
        super.onCreate(savedInstanceState);
        init();
        setViewDefalutValue();
        setHotLine();
    }

    private void init() {
        presenter = new RegistPresenter(this);
    }

    @OnClick({R.id.quhao_textview, R.id.phoneNum_textview, R.id.yanzhengma_iv, R.id.accpet_cb, R.id.xieyi_tv, R.id.next_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quhao_textview:
                break;
            case R.id.phoneNum_textview:
                break;
            case R.id.yanzhengma_iv:
                //TODO
                ToastUtil.showMsg_By_String(this, "获取验证码", Toast.LENGTH_SHORT);
                break;
            case R.id.accpet_cb:
                break;
            case R.id.xieyi_tv:
                break;
            case R.id.next_btn:
                Bundle bundle = new Bundle();
                bundle.putString(REGISTER_PHONE, phoneNumTextview.getText().toString());
                presenter.jump2Where(YanZhengMaCheckActivity.class, bundle);
                break;
        }
    }

    @Override
    public void setViewDefalutValue() {
        presenter.getTitle(IPresenter.TITLE_TYPE_REGISTER);
    }

    @Override
    public void setTitle(String title) {
        this.tilte.setText(title);
    }

    @Override
    public void setHotLine() {
        super.setHotLine(hotlintTv);
    }


}

package isechome.comisechomewww.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import isechome.comisechomewww.R;
import isechome.comisechomewww.callback.onCountDownListener;
import isechome.comisechomewww.presenter.IPresenter;
import isechome.comisechomewww.presenter.RegistPresenter;
import isechome.comisechomewww.tools.TimerUtils;
import isechome.comisechomewww.tools.ToastUtil;
import isechome.comisechomewww.view.IRegisterView;

/**
 * Created by Administrator on 2016/7/13.
 */

public class FastRegister2Activity extends BaseActivity implements IRegisterView, onCountDownListener {
    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.userphone_tv)
    TextView userphoneTv;
    @BindView(R.id.userinfo_tv)
    TextView userinfoTv;
    @BindView(R.id.yanzhengma_editview)
    EditText yanzhengmaEditview;
    @BindView(R.id.yanzhengma_btn)
    Button yanzhengmaBtn;
    @BindView(R.id.regist_finish_btn)
    Button registFinishBtn;
    @BindView(R.id.hotlint_tv)
    TextView hotlintTv;
    private RegistPresenter mPresenter;
    private Bundle bundle;
    private TimerUtils mTimerUtils;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_fast_regist2);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        mPresenter = new RegistPresenter(this);
        bundle = this.getIntent().getExtras();
        mTimerUtils = new TimerUtils(this);
        setHotLine();
        setViewDefalutValue();
    }

    @OnClick({R.id.yanzhengma_btn, R.id.regist_finish_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yanzhengma_btn:
                setYanZhengMaBtn();
                break;
            case R.id.regist_finish_btn:
                break;
        }
    }

    private void setYanZhengMaBtn() {
        yanzhengmaBtn.setEnabled(false);
        mTimerUtils.start();
    }

    @Override
    public void setHotLine() {
        super.setHotLine(hotlintTv);
    }

    @Override
    public void setViewDefalutValue() {
        userphoneTv.setText(this.getResources().getString(R.string.info_userphone, bundle.getString(FastRegisterActivity.REGISTER_PHONE)));
        setYanZhengMaBtn();
    }

    @Override
    public void setTitle(String title) {
        mPresenter.getTitle(IPresenter.TITLE_TYPE_REGISTER);
    }

    @Override
    public void onCountDown(int count, boolean isFinish) {
        mPresenter.setYanZhengMaInfo(yanzhengmaBtn, count, isFinish);
    }
}

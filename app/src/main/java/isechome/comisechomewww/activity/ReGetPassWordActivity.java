package isechome.comisechomewww.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import isechome.comisechomewww.R;
import isechome.comisechomewww.presenter.IPresenter;
import isechome.comisechomewww.presenter.ReGetPassWordPresenter;
import isechome.comisechomewww.view.IReGetPassWordView;

/**
 * Created by Administrator on 2016/7/13.
 */

public class ReGetPassWordActivity extends BaseActivity implements IReGetPassWordView {
    //控件
    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.yanzhengma_editview)
    EditText yanzhengmaEditview;
    @BindView(R.id.yanzhengma_iv)
    ImageView yanzhengmaIv;
    @BindView(R.id.next_btn)
    Button extBtn;
    /**
     * 是否显示用户姓名信息
     */
    public static final String ISSHOWUSERINFO = "isshow";
    private ReGetPassWordPresenter mReGetPassWordPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_reget_password);
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        mReGetPassWordPresenter = new ReGetPassWordPresenter(this);
        mReGetPassWordPresenter.getTitle(IPresenter.TITLE_TYPE_REGETPASSWORD);
        setViewDefalutValue();
    }

    @OnClick({R.id.yanzhengma_iv, R.id.next_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yanzhengma_iv:
                mReGetPassWordPresenter.setYanZhengMa(view);
                break;
            case R.id.next_btn:
                mReGetPassWordPresenter.jump2Where(YanZhengMaCheckActivity.class, setBundle(R.id.next_btn));
                break;
        }
    }

    @Override
    public void setViewDefalutValue() {
    }

    @Override
    public void setTitle(String title) {
        titleTextview.setText(title);
    }

    @Override
    public Bundle setBundle(int id) {
        Bundle bundle = new Bundle();
        switch (id) {
            case R.id.next_btn:
                bundle.putBoolean(ISSHOWUSERINFO, true);
                break;
            default:
                break;
        }
        return bundle;
    }
}

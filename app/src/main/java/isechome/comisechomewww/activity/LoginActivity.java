package isechome.comisechomewww.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import isechome.comisechomewww.R;
import isechome.comisechomewww.presenter.IPresenter;
import isechome.comisechomewww.presenter.LoginPresenter;
import isechome.comisechomewww.tools.ToastUtil;
import isechome.comisechomewww.view.ILoginView;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements ILoginView {


    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.username)
    AutoCompleteTextView username;
    @BindView(R.id.clear_iv)
    ImageButton clearIv;
    @BindView(R.id.password)
    AppCompatAutoCompleteTextView password;
    @BindView(R.id.show_full)
    CheckBox showFull;
    @BindView(R.id.sign_in_button)
    Button signInButton;
    @BindView(R.id.regist_textview)
    TextView registTextview;
    @BindView(R.id.re_password_textview)
    TextView rePasswordTextview;
    @BindView(R.id.aboutsoft_textview)
    TextView aboutsoftTextview;
    @BindView(R.id.loginview)
    LinearLayout loginview;

    private LoginPresenter persenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);
        persenter = new LoginPresenter(this);
        initView();
        setViewDefalutValue();
    }

    @Override
    public void initView() {
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    clearIv.setVisibility(View.VISIBLE);
                } else {
                    clearIv.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    @OnClick({R.id.clear_iv, R.id.show_full, R.id.sign_in_button, R.id.regist_textview, R.id.re_password_textview, R.id.aboutsoft_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clear_iv:
                //清空用户名
                username.setText("");
                break;
            case R.id.show_full:
                persenter.showPsd(showFull, password);
                break;
            case R.id.sign_in_button:
                break;
            case R.id.regist_textview:
                persenter.jump2Where(FastRegisterActivity.class, null);
                break;
            case R.id.re_password_textview:
                persenter.jump2Where(ReGetPassWordActivity.class, null);
                break;
            case R.id.aboutsoft_textview:
                ToastUtil.showMsg_By_String(this, "跳转单html页面", Toast.LENGTH_SHORT);
                break;
        }
    }

    @Override
    public void setViewDefalutValue() {
        persenter.getTitle(IPresenter.TITLE_TYPE_LOGIN);
    }

    @Override
    public void setTitle(String title) {
        this.titleTextview.setText(title);
    }
}

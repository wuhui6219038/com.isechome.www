package isechome.comisechomewww.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import isechome.comisechomewww.R;
import isechome.comisechomewww.tools.ToastUtil;

/**
 * Created by Administrator on 2016/7/13.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    public void setHotLine(TextView tv) {
        SpannableString hotlineSpannable = null;
        hotlineSpannable = new SpannableString(this.getResources().getString(R.string.action_hotline));
        hotlineSpannable.setSpan(new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(BaseActivity.this.getResources().getColor(android.R.color.holo_red_light));
                ds.setUnderlineText(true);
            }

            @Override
            public void onClick(View view) {
                //TODO
                ToastUtil.showMsg_By_String(BaseActivity.this, "弹出打电话对话框", Toast.LENGTH_SHORT);
            }

        }, 6, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(hotlineSpannable);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

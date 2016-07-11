package isechome.comisechomewww.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import isechome.comisechomewww.R;

/**
 * Created by Administrator on 2016/7/5.
 */

public class SaleFragment extends Fragment {
    private String msg;

    public SaleFragment() {
        super();
    }

    public SaleFragment(String msg) {
        this.msg = msg;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sale, null);


        return view;

    }
}

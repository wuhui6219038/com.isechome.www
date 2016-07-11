package isechome.comisechomewww.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import isechome.comisechomewww.fragment.HomeFragment;

/**
 * Created by Administrator on 2016/7/5.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private String[] menus;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * @param fm
     * @param menus 菜单数组
     */
    public SectionsPagerAdapter(FragmentManager fm, String[] menus) {
        super(fm);
        this.menus = menus;
    }

    @Override
    public Fragment getItem(int position) {

        return HomeFragment.PlaceholderFragment.newInstance(position);

    }

    @Override
    public int getCount() {
        int count = 0;
        if (menus != null && menus.length != 0) {
            count = menus.length;
        }
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (menus != null) {
            return menus[position];
        } else
            return super.getPageTitle(position);
    }
}

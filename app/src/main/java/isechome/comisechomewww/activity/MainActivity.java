package isechome.comisechomewww.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import isechome.comisechomewww.R;
import isechome.comisechomewww.fragment.CustomFragment;
import isechome.comisechomewww.fragment.HomeFragment;
import isechome.comisechomewww.fragment.MoreFragment;
import isechome.comisechomewww.fragment.SaleFragment;
import isechome.comisechomewww.fragment.TradeFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    private RadioGroup rg_ButtomMenu;
    private Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        initView();
        test();

//        initTabLayout();
    }

    private void test() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }


    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        //返回按钮
//etSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rg_ButtomMenu = (RadioGroup) findViewById(R.id.buttom_menu);

        initLinstener();
        setDefaultFragment();
    }

    private void initLinstener() {

        rg_ButtomMenu.setOnCheckedChangeListener(this);
    }

    private void setDefaultFragment() {
        FragmentManager manger = this.getSupportFragmentManager();
        FragmentTransaction transaction = manger.beginTransaction();
        Fragment fragment = HomeFragment.getHomeFragment();
        transaction.replace(R.id.main_content, fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        initSearchView(menu);
        /*MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed
                Toast.makeText(MainActivity.this, "hello expand", Toast.LENGTH_LONG).show();
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                Toast.makeText(MainActivity.this, "hello expand", Toast.LENGTH_LONG).show();
                return true;  // Return true to expand action view
            }
        });*/
        return super.onCreateOptionsMenu(menu);
    }

    private void initSearchView(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.e("MainActivity", "setOnQueryTextFocusChangeListener");

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("MainActivity", "onQueryTextSubmit");


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("MainActivity", "onQueryTextChange");

                return false;
            }
        });
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "搜索", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int id) {
        FragmentManager manger = this.getSupportFragmentManager();
        FragmentTransaction transaction = manger.beginTransaction();
        Fragment fragment = null;
        switch (id) {
            case R.id.home: {
                fragment = HomeFragment.getHomeFragment();
                break;
            }
            case R.id.sale: {
                fragment = new SaleFragment("销售采购");
                break;
            }
            case R.id.trading: {
                fragment = new TradeFragment("交易");
                break;
            }
            case R.id.custom: {
                fragment = new CustomFragment("定制");
                break;
            }
            case R.id.more: {
                fragment = new MoreFragment("更多");
                break;
            }
            default:
                break;
        }

        transaction.replace(R.id.main_content, fragment);
        transaction.commit();
    }


}

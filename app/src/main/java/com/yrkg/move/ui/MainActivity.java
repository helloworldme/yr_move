package com.yrkg.move.ui;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.WindowManager;

import com.yc.yclibrary.base.YcAppCompatActivity;
import com.yc.yclibrary.utils.ActivityUtils;
import com.yrkg.move.R;
import com.yrkg.move.adapter.ViewPagerAdapter;
import com.yrkg.move.fragment.ChartFragment;
import com.yrkg.move.fragment.HomeFragment;
import com.yrkg.move.fragment.PersonFragment;
import com.yrkg.move.tool.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends YcAppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private MenuItem menuItem;
    private ChartFragment mchartfragment;
    private HomeFragment mhomefragment ;
    private PersonFragment mpersonfragment;
    private  long exitTime=0;

    @Override
    protected int getLayoutId() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle bundle) {
        mchartfragment = new ChartFragment();
        mhomefragment =new HomeFragment();
        mpersonfragment = new PersonFragment();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        List<Fragment> list = new ArrayList<>();
        list.add(mhomefragment);
        list.add(mchartfragment);
        list.add(mpersonfragment);
        viewPagerAdapter.setList(list);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_main);
//        mchartfragment = new ChartFragment();
//        mhomefragment =new HomeFragment();
//        mpersonfragment = new PersonFragment();
//
//
//    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            menuItem = item;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_person:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
    /**
     * 监听back键处理DrawerLayout和SearchView
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitApp();
        }
        return true;
    }
    /**
     * 双击退出App
     */
    public  void exitApp() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            showToast("再按一次退出");
            exitTime = System.currentTimeMillis();
        } else {
            ActivityUtils.INSTANCE.finishAllActivity();
        }
    }
    //Activity创建或者从后台重新回到前台时被调用
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("111", "onStart called.");
    }

}

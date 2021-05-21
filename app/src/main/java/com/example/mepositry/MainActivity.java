package com.example.mepositry;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.mepositry.fragment.AffairsFragment;
import com.example.mepositry.fragment.CommunityFragment;
import com.example.mepositry.fragment.HomeFragment;
import com.example.mepositry.fragment.LifeFragment;
import com.example.mepositry.fragment.MineFragment;

import java.lang.reflect.Field;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentmanager;
    private FragmentTransaction fragmenttransaction;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomnavibar);

    disableShiftMode(bottomNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                resetToDefaultIcon();
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Log.e("TAG","");
                        item.setIcon(R.mipmap.ic_home_pressed);
                        setFragment(0);
                        break;
                    case R.id.action_community:
                        item.setIcon(R.mipmap.ic_community_pressed);
                        setFragment(1);
                        break;
                    case R.id.action_affairs:
                        item.setIcon(R.mipmap.dangwu_press);
                        setFragment(2);
                        break;
                    case R.id.action_life:
                        item.setIcon(R.mipmap.ic_life_press);
                        setFragment(3);
                        break;
                    case R.id.action_mine:
                        item.setIcon(R.mipmap.ic_me_pressed);
                        setFragment(4);
                        break;
                }
                return true;
            }
        });




        setFragment(0);
    }
    private void resetToDefaultIcon() {
        //reset image
        MenuItem home =  bottomNavigationView.getMenu().findItem(R.id.action_home);
        home.setIcon(R.mipmap.ic_home_normal);
        MenuItem community =  bottomNavigationView.getMenu().findItem(R.id.action_community);
        community.setIcon(R.mipmap.ic_community_normal);
        MenuItem affairs =  bottomNavigationView.getMenu().findItem(R.id.action_affairs);
        affairs.setIcon(R.mipmap.dangwu_unpress);
        MenuItem life =  bottomNavigationView.getMenu().findItem(R.id.action_life);
        life.setIcon(R.mipmap.ic_life_normal);
        MenuItem mine =  bottomNavigationView.getMenu().findItem(R.id.action_mine);
        mine.setIcon(R.mipmap.ic_me_normal);
    }

    public void setFragment(int n) {
        fragmentmanager = getSupportFragmentManager();
        fragmenttransaction = fragmentmanager.beginTransaction();
        switch (n) {
            case 0:
                fragmenttransaction.replace(R.id.main_frame, HomeFragment.newInstance("首页"));
                fragmenttransaction.commit();
                break;
            case 1:
                fragmenttransaction.replace(R.id.main_frame, CommunityFragment.newInstance("学习"));
                fragmenttransaction.commit();
                break;
            case 2:
                fragmenttransaction.replace(R.id.main_frame, AffairsFragment.newInstance("党务"));
                fragmenttransaction.commit();
                break;
            case 3:
                fragmenttransaction.replace(R.id.main_frame,LifeFragment.newInstance("党建圈"));
                fragmenttransaction.commit();
                break;
            case 4:
                fragmenttransaction.replace(R.id.main_frame, MineFragment.newInstance("我的"));
                fragmenttransaction.commit();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView navigationView) {

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigationView.getChildAt(0);
        try {
            // 利用反射，改变 item 中 mShiftingMode 的值 ,从而改变 BottomNavigationView 默认的效果
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);

            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(i);
                itemView.setShiftingMode(false);
                itemView.setChecked(itemView.getItemData().isChecked());
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
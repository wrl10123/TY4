package com.sc.ty4.Controller.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sc.ty4.Controller.Fragment.MainFrag1;
import com.sc.ty4.Controller.Fragment.MainFrag2;
import com.sc.ty4.Controller.Fragment.MainFrag4;
import com.sc.ty4.Controller.Fragment.MainFrag5;
import com.sc.ty4.Controller.Fragment.MainFrag3;
import com.sc.ty4.R;

public class Main extends AppCompatActivity {

    private Button b1, b2, b3, b4, b5;
    private Fragment[] mFragment;
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (Build.VERSION.SDK_INT >= 21) {
            //获取到了当前界面的DecorView
            View decorView = getWindow().getDecorView();
            //让应用的主体内容占用系统状态栏的空间
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            //设置系统UI元素的可见性
            decorView.setSystemUiVisibility(option);
            //将状态栏设置成透明色
            //getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        Toast.makeText(Main.this,"~~~~@#",Toast.LENGTH_SHORT).show();

        iniv();
    }

    private void iniv() {
        b1 = findViewById(R.id.main_tab_butt1);
        b2 = findViewById(R.id.main_tab_butt2);
        b3 = findViewById(R.id.main_tab_butt3);
        b4 = findViewById(R.id.main_tab_butt4);
        b5 = findViewById(R.id.main_tab_butt5);
        //1.1初始化Fragment
        mFragment = new Fragment[4];
        mFragment[0] = new MainFrag1();
        mFragment[1] = new MainFrag2();
        mFragment[2] = new MainFrag3();
        mFragment[3] = new MainFrag4();
        mManager = getFragmentManager();    //获取Fragment的事物
        FragmentTransaction ft = mManager.beginTransaction();
        for (int i = 0; i < mFragment.length; i++) {
            //循环往主页面的FramaLayout组件里面添加Fragment
            ft.add(R.id.main_fragment1, mFragment[i]);
            ft.show(mFragment[0]);      //默认显示第一个
            ft.hide(mFragment[i]);      //隐藏所有的Fragment
            b1.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.shouye2_03, 0, 0);
        }
        ft.commit();    //提交事物
    }

    public void MainButt(View v) {
        hideFrag(); // 隐藏其它Fragment，重置小图标颜色
        FragmentTransaction ft = mManager.beginTransaction();
        switch (v.getId()) {
            case R.id.main_tab_butt1:
                ft.show(mFragment[0]);
                b1.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.shouye2_03, 0, 0);
                break;
            case R.id.main_tab_butt2:
                ft.show(mFragment[1]);
                b2.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.zhuanti2_03, 0, 0);
                break;
            case R.id.main_tab_butt3:
                ft.show(mFragment[2]);
                b3.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.huodong2_03, 0, 0);
                break;
            case R.id.main_tab_butt4:
                ft.show(mFragment[3]);
                b4.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.wode2_03, 0, 0);
                break;
            case R.id.main_tab_butt5:
                b5.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.fabu2_03, 0, 0);
                break;
            default:
                break;
        }
        ft.commit();
    }

    //统一操作，每次点击主页下方按钮都会执行该方法
    private void hideFrag() {
        FragmentTransaction ft = mManager.beginTransaction();
        defaultImage();
        for (Fragment f : mFragment) {
            ft.hide(f);
        }
        ft.commit();

    }

    private void defaultImage() {
        b1.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.shouye1_03, 0, 0);
        b2.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.zhuanti1_03, 0, 0);
        b3.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.huodong1_03, 0, 0);
        b4.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.wode1_03, 0, 0);
        b5.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.fabu1_03, 0, 0);
    }


    //设置沉浸模式需要重写的方法
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        /*if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }*/
    }

}

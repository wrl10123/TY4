package com.sc.ty4.Controller.Activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.sc.ty4.R;

public class ImgInfo2 extends AppCompatActivity {
    private RelativeLayout rl;
    private ImageView dianzan,pinglun,fenxiang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_info2);
        rl = findViewById(R.id.img_info2_relative);
        dianzan = findViewById(R.id.img_info2_dianzan);
        pinglun = findViewById(R.id.img_info2_pinglun);
        fenxiang = findViewById(R.id.img_info2_fenxiang);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl.setVisibility(View.INVISIBLE);
            }
        });


        //System.out.println(Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= 21) {
            //获取到了当前界面的DecorView
            View decorView = getWindow().getDecorView();
            //让应用的主体内容占用系统状态栏的空间
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            //设置系统UI元素的可见性
            decorView.setSystemUiVisibility(option);
            //将状态栏设置成透明色
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        //隐藏标题栏
        /*ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/
    }
}

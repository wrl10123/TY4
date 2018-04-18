package com.sc.ty4.Controller.Activity;

import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.sc.ty4.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImgInfo extends AppCompatActivity implements View.OnClickListener{
    private ImageView head,guanzhu,dianzan;
    private TextView dianzan2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_info);
        init();
    }

    private void init() {
        head = findViewById(R.id.img_info_head);
        guanzhu = findViewById(R.id.img_info_button1);
        dianzan = findViewById(R.id.img_info_dianzan);
        dianzan2 =findViewById(R.id.img_info_dianzan2);
        RoundedBitmapDrawable img1 =
                RoundedBitmapDrawableFactory.create(getResources(),
                        BitmapFactory.decodeResource(getResources(),
                                R.drawable.head3));
        img1.setCircular(true);
        //setCornerRadius(150);
        //setCornerRadius(30);
        head.setImageDrawable(img1);
        guanzhu.setOnClickListener(this);
        dianzan.setOnClickListener(this);
        dianzan2.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /*case R.id.img_info_button1:
                guanzhu.setImageDrawable(getResources().getDrawable(R.mipmap.guanzhu4));
                break;
            case R.id.img_info_dianzan:
                dianzan.setImageDrawable(getResources().getDrawable(R.mipmap.dianzan2));
                break;
            case R.id.img_info_dianzan2:
                dianzan.setImageDrawable(getResources().getDrawable(R.mipmap.dianzan2));
                break;
            default:
                break;*/
        }
    }
}

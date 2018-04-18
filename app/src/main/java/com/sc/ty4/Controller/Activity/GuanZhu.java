package com.sc.ty4.Controller.Activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.sc.ty4.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuanZhu extends AppCompatActivity {
    private String[] names = new String[] { "虎头"};
    private int[] imageIds = new int[]
            { R.mipmap.fabu2_03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guan_zhu);
        /*if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(R.color.guanzhuTitle);
        }*/
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", imageIds[i]);
            listItem.put("personName", names[i]);
            maps.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                maps,
                R.layout.simple_guanzhu_list,
                new String[]{"header","personName"},
                new int[]{R.id.simple_guanzhu_img1, R.id.simple_guanzhu_name,});
        ListView list = (ListView) findViewById(R.id.guanzhu_list);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);
    }
}

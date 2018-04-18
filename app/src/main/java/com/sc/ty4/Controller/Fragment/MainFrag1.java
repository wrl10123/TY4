package com.sc.ty4.Controller.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.sc.ty4.Controller.Activity.ImgInfo2;
import com.sc.ty4.Controller.Activity.ImgInfo;
import com.sc.ty4.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFrag1 extends Fragment implements View.OnClickListener{
    //
    private ImageView head,guanzhu,dianzan,img,mainBanner;
    private TextView dianzan2;
    private Button houtui;
    private TypedArray heads,photos;
    private String [] names,photonames;
    private Context mContent;
    private LinearLayout img_ll;
    private RoundedBitmapDrawable img1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_frag1,container,false);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContent = getActivity();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainBanner = getActivity().findViewById(R.id.main_banner);
        mainBanner.setOnClickListener(this);
        img_ll = getActivity().findViewById(R.id.main_img_ll);
        img_ll.setOnClickListener(this);
        frag1Lv();
    }

    private void frag1Lv() {
        heads = getResources().obtainTypedArray(R.array.main_lv_head);
        names = getResources().getStringArray(R.array.main_lv_name);
        photos = getResources().obtainTypedArray(R.array.main_lv_photo);
        photonames = getResources().getStringArray(R.array.main_lv_photoname);
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            img1 = RoundedBitmapDrawableFactory.create(getResources(),
                BitmapFactory.decodeResource(getResources(), heads.getResourceId(i,0)));
            img1.setCircular(true);
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("heads", heads.getResourceId(i,0));
            listItem.put("names", names[i]);
            listItem.put("photos",photos.getResourceId(i,0));
            listItem.put("pnames",photonames[i]);
            maps.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                mContent,
                maps,
                R.layout.simple_img_info_list,
                new String[]{"heads","names","photos","pnames"},
                new int[]{R.id.img_info3_head, R.id.img_info3_name,
                        R.id.img_info3_photo,R.id.img_info3_imgName});
        ListView list = getActivity().findViewById(R.id.fra1_listview);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_banner:
                startActivity(new Intent(mContent, ImgInfo2.class));
                break;
            case R.id.main_img_ll:
                startActivity(new Intent(mContent, ImgInfo.class));
                break;
        }
    }
}

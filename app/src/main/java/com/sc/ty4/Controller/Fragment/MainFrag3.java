package com.sc.ty4.Controller.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sc.ty4.Controller.Activity.HuodongInfo;
import com.sc.ty4.R;
public class MainFrag3 extends Fragment implements View.OnClickListener{
    private Context mContext;
    private ImageView hdImg;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_frag3,container,false);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hdImg = getActivity().findViewById(R.id.hd_img);
        hdImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.hd_img:
                startActivity(new Intent(mContext, HuodongInfo.class));
                break;
        }
    }
}

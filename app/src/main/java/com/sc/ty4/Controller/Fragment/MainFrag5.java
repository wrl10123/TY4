package com.sc.ty4.Controller.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sc.ty4.Controller.Activity.Camera1;
import com.sc.ty4.R;

import java.io.File;

public class MainFrag5 extends Fragment implements View.OnClickListener{
    private Context mContent;
    Button button, button2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_frag5, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContent = getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = getActivity().findViewById(R.id.main_frg3_button);
        button2 = getActivity().findViewById(R.id.main_frg3_button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_frg3_button:
                startActivity(new Intent(mContent, Camera1.class));
                break;
            case R.id.main_frg3_button2:
                Intent openCameraIntent = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {  //Android7.0以上
                   Uri uri = FileProvider.getUriForFile(mContent, "opencamera.baochen.com.fileprovider", new File(Environment
                            .getExternalStorageDirectory(), "image.jpg"));//通过FileProvider创建一个content类型的Uri

                    openCameraIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
                    openCameraIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);//设置Action为拍照
                    openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);//将拍取的照片保存到指定URI
                    startActivityForResult(openCameraIntent, TRIM_MEMORY_MODERATE);
                } else {
                    Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "image.jpg"));//7.0以下打开相机拍照的方法
                    openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);//保存照片
                    startActivityForResult(openCameraIntent, TRIM_MEMORY_MODERATE);
                }
                break;


        }
    }
}
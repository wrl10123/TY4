package com.sc.ty4.Controller.Fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.ImageView;
import android.widget.RadioButton;

import com.sc.ty4.Controller.Activity.GuanZhu;
import com.sc.ty4.R;

import java.io.File;

public class MainFrag4 extends Fragment implements View.OnClickListener {
    //获取上下文
    private Context mContext;

    private static final String TAG = "MainActivity";
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;
    private ImageView iv_personal_icon;
    private RadioButton b1,b2,b3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_frag4,container,false);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iv_personal_icon = getActivity().findViewById(R.id.iv_personal_icon);
        b1 = getActivity().findViewById(R.id.main_frg5_guanzhu);
        iv_personal_icon.setOnClickListener(this);
        b1.setOnClickListener(this);
    }
    /**
     * 显示修改头像的对话框
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_personal_icon:
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("设置头像");
                String[] items = { "选择本地照片", "拍照" };
                builder.setNegativeButton("取消", null);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case CHOOSE_PICTURE: // 选择本地照片
                        /*
                        * ACTION_GET_CONTENT：允许用户选择特殊种类的数据，
                        * 并返回（特殊种类的数据：照一张相片或录一段音）剪切图片
                        * */
                                Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
                                openAlbumIntent.setType("image/*");
                                startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                                break;
                            case TAKE_PICTURE: // 拍照

                                break;
                        }
                    }
                });
                builder.create().show();
                break;
            case R.id.main_frg5_guanzhu:
                startActivity(new Intent(getActivity(), GuanZhu.class));
                break;
        }
    }
    private void getPicFromCamera() {
        // 启动系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri mImageCaptureUri;
        // 判断7.0android系统
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //临时添加一个拍照权限
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            //通过FileProvider获取uri
            Uri contentUri = FileProvider.getUriForFile(mContext, "com.sc.ty4.fileProvider",
                    new File(Environment.getExternalStorageDirectory(), "temp.jpg"));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {
            mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "temp.jpg"));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
        }
        //startActivityForResult(intent, PHOTO_PZ);
    }
    /**
     * 自动获取相机权限
     */

}

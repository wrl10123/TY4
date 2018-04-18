package com.sc.ty4.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;


public class GetImgXY extends View{

    int i,j;

    public GetImgXY(Context context, AttributeSet abs) {
        super(context,abs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public ImageView getImg(Bitmap img){
        i = img.getWidth();
        j = img.getHeight();

        return null;
    }
}

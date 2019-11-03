package com.sty.ne.paint.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 只能是一种颜色与图片进行混合
 * Created by tian on 2019/10/10.
 */

public class ColorFilterView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private ColorMatrixColorFilter mColorMatrixColorFilter;

    public ColorFilterView(Context context) {
        this(context, null);

    }

    public ColorFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint  = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.girl);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 颜色过滤器-第一种实现方式-光照效果
         * R' = R * mul.R / 0xff + add.R
         * G' = G * mul.G / 0xff + add.G
         * B' = B * mul.B / 0xff + add.B
         */
        //红色去除
//        LightingColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff, 0x000000);
//        mPaint.setColorFilter(lightingColorFilter);
//        canvas.drawBitmap(mBitmap, 0, 0, mPaint);

        //原图效果
//        LightingColorFilter lightingColorFilter = new LightingColorFilter(0xffffff, 0x000000);
//        mPaint.setColorFilter(lightingColorFilter);
//        canvas.drawBitmap(mBitmap, 0, 0, mPaint);

        //绿色更亮
//        LightingColorFilter lightingColorFilter = new LightingColorFilter(0xffffff, 0x003000);
//        mPaint.setColorFilter(lightingColorFilter);
//        canvas.drawBitmap(mBitmap, 0, 0, mPaint);

        /**
         * 颜色过滤器-第二种实现方式
         */
//        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN);
//        mPaint.setColorFilter(porterDuffColorFilter);
//        canvas.drawBitmap(mBitmap, 100, 0, mPaint);

        /**
         * 颜色矩阵-矩阵实现
         */
//        float[] colorMatrixArray = {
//        //      R, G, B, A, offset(颜色偏移量）
//                2, 0, 0, 0, 0,  //red
//                0, 1, 0, 0, 0,  //green
//                0, 0, 1, 0, 0,  //blue
//                0, 0, 0, 1, 0,  //alpha
//        };
//        mColorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrixArray);
//        mPaint.setColorFilter(mColorMatrixColorFilter);
//        canvas.drawBitmap(mBitmap, 100, 0, mPaint);

        /**
         * 颜色矩阵-类实现->实现灰色图像 参考show/gray.png
         */
        ColorMatrix colorMatrix = new ColorMatrix();
        //亮度调节
//        colorMatrix.setScale(2, 1, 1, 1);
        //饱和度调节0-无色彩 1-默认效果 >1-饱和度加强
        colorMatrix.setSaturation(0);
        //色调调节
//        colorMatrix.setRotate(0, 45);
        mColorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        mPaint.setColorFilter(mColorMatrixColorFilter);
        canvas.drawBitmap(mBitmap, 100, 0, mPaint);


//        int width, height;
//        height = mBitmap.getHeight();
//        width = mBitmap.getWidth();
//        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
//        Canvas c = new Canvas(bmpGrayscale);
//        ColorMatrix cm = new ColorMatrix();
//        cm.setSaturation(0);
//        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
//        mPaint.setColorFilter(f);
//        c.drawBitmap(mBitmap, 0, 0, mPaint);
    }
}

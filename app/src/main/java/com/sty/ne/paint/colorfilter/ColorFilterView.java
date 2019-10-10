package com.sty.ne.paint.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tian on 2019/10/10.
 */

public class ColorFilterView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;

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
         * R' = R * mul.R / 0xff + add.R
         * G' = G * mul.G / 0xff + add.G
         * B' = B * mul.B / 0xff + add.B
         */

        //红色去除
        LightingColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff, 0x000000);
        mPaint.setColorFilter(lightingColorFilter);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }
}

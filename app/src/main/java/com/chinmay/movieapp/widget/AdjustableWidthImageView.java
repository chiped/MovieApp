package com.chinmay.movieapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by ChiP on 1/10/2016.
 */
public class AdjustableWidthImageView extends ImageView {


        public AdjustableWidthImageView(Context context) {
            super(context);
        }

        public AdjustableWidthImageView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public AdjustableWidthImageView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            if(getDrawable() == null) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                return;
            }
            int height = View.MeasureSpec.getSize(heightMeasureSpec);
            int width = height * getDrawable().getIntrinsicWidth() / getDrawable().getIntrinsicHeight();
            setMeasuredDimension(width, height);
        }
}

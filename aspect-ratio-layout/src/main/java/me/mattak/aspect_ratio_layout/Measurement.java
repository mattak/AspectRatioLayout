package me.mattak.aspect_ratio_layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Measurement calculation for aspect based layout.
 * Created by pine on 15/10/10.
 */
class Measurement {
    private int mAspectRatioWidth = 1;
    private int mAspectRatioHeight = 1;
    private int mAspectOrientation = 0;
    private float mRelativeWidth = 1.0f;
    private float mRelativeHeight = 1.0f;

    public void init(Context context, AttributeSet attrs) {
        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.FixedAspectRatio);

        mAspectRatioWidth = array.getInt(R.styleable.FixedAspectRatio_aspect_width, 1);
        mAspectRatioHeight = array.getInt(R.styleable.FixedAspectRatio_aspect_height, 1);
        mAspectOrientation = array.getInt(R.styleable.FixedAspectRatio_aspect_orientation, 0);
        mRelativeWidth = array.getFloat(R.styleable.FixedAspectRatio_relative_width, 1.0f);
        mRelativeHeight = array.getFloat(R.styleable.FixedAspectRatio_relative_height, 1.0f);

        array.recycle();
    }

    public int[] getMeasuredDimension(int widthMeasureSpec, int heightMeasureSpec) {
        final int originalWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        final int originalHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        final int calculatedWidth = originalHeight * mAspectRatioWidth / mAspectRatioHeight;
        final int calculatedHeight = originalWidth * mAspectRatioHeight / mAspectRatioWidth;

        int finalWidth;
        int finalHeight;

        switch (mAspectOrientation) {
            case 1: // width
                finalWidth = originalWidth;
                finalHeight = calculatedHeight;
                break;

            case 2: // height
                finalWidth = calculatedWidth;
                finalHeight = originalHeight;
                break;

            default: // auto
                if (calculatedHeight > originalHeight) {
                    finalWidth = calculatedWidth;
                    finalHeight = originalHeight;
                } else {
                    finalWidth = originalWidth;
                    finalHeight = calculatedHeight;
                }
                break;
        }

        finalWidth = (int) (finalWidth * mRelativeWidth);
        finalHeight = (int) (finalHeight * mRelativeHeight);

        return new int[]{finalWidth, finalHeight};
    }
}
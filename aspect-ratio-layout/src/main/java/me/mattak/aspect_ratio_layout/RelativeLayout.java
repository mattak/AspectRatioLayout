package me.mattak.aspect_ratio_layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

public class RelativeLayout extends android.widget.RelativeLayout {
    private int mAspectRatioWidth = 1;
    private int mAspectRatioHeight = 1;
    private float mRelativeWidth = 1.0f;
    private float mRelativeHeight = 1.0f;

    public RelativeLayout(Context context) {
        super(context);
    }

    public RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public RelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.FixedAspectRatio);

        mAspectRatioWidth = array.getInt(R.styleable.FixedAspectRatio_aspect_width, 1);
        mAspectRatioHeight = array.getInt(R.styleable.FixedAspectRatio_aspect_height, 1);
        mRelativeWidth = array.getFloat(R.styleable.FixedAspectRatio_relative_width, 1.0f);
        mRelativeHeight = array.getFloat(R.styleable.FixedAspectRatio_relative_height, 1.0f);

        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int originalWidth = MeasureSpec.getSize(widthMeasureSpec);
        final int originalHeight = MeasureSpec.getSize(heightMeasureSpec);
        final int calculatedHeight = originalWidth * mAspectRatioHeight / mAspectRatioWidth;

        int finalWidth;
        int finalHeight;

        if (calculatedHeight > originalHeight) {
            finalWidth = originalHeight * mAspectRatioWidth / mAspectRatioHeight;
            finalHeight = originalHeight;
        } else {
            finalWidth = originalWidth;
            finalHeight = calculatedHeight;
        }

        finalWidth = (int)(finalWidth * mRelativeWidth);
        finalHeight = (int)(finalHeight * mRelativeHeight);

        super.onMeasure(
                MeasureSpec.makeMeasureSpec(finalWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(finalHeight, MeasureSpec.EXACTLY));
    }
}

package me.mattak.aspect_ratio_layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import me.mattak.aspect_ratio_layout.R;

public class FixedAspectRatioLinearLayout extends LinearLayout {
    private int mAspectRatioWidth = 1;
    private int mAspectRatioHeight = 1;

    public FixedAspectRatioLinearLayout(Context context) {
        super(context);
    }

    public FixedAspectRatioLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public FixedAspectRatioLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FixedAspectRatioLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.FixedAspectRatio);

        mAspectRatioWidth = array.getInt(R.styleable.FixedAspectRatio_aspect_width, 1);
        mAspectRatioHeight = array.getInt(R.styleable.FixedAspectRatio_aspect_height, 1);

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

        super.onMeasure(
                MeasureSpec.makeMeasureSpec(finalWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(finalHeight, MeasureSpec.EXACTLY));
    }
}

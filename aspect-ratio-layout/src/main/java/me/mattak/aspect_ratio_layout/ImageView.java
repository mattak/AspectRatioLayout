package me.mattak.aspect_ratio_layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

/**
 * AspectRatioLayout for ImageView.
 * Created by mattak on 15/08/12.
 */
public class ImageView extends android.widget.ImageView {
    private Measurement mMeasurement = new Measurement();

    public ImageView(Context context) {
        super(context);
    }

    public ImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mMeasurement.init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public ImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mMeasurement.init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mMeasurement.init(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int[] measuredDimension = mMeasurement.getMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measuredDimension[0], measuredDimension[1]);
    }
}
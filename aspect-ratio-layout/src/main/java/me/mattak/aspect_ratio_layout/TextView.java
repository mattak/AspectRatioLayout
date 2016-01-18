package me.mattak.aspect_ratio_layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

/**
 * AspectRatioLayout for TextView.
 * Created by pine on 1/17/16.
 */
public class TextView extends android.widget.TextView {
    private Measurement mMeasurement = new Measurement();

    public TextView(Context context) {
        super(context);
    }

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mMeasurement.init(context, attrs);
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mMeasurement.init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mMeasurement.init(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int[] measuredDimension = mMeasurement.getMeasuredDimension(widthMeasureSpec, heightMeasureSpec);

        super.onMeasure(
                MeasureSpec.makeMeasureSpec(measuredDimension[0], MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(measuredDimension[1], MeasureSpec.EXACTLY));
    }
}

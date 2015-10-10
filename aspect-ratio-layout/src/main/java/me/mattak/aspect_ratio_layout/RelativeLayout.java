package me.mattak.aspect_ratio_layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

/**
 * RelativeLayout for LinearLayout.
 * Created by mattak on 2015/10/10.
 */
public class RelativeLayout extends android.widget.RelativeLayout {
    private Measurement mMeasurement = new Measurement();

    public RelativeLayout(Context context) {
        super(context);
    }

    public RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mMeasurement.init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public RelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mMeasurement.init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
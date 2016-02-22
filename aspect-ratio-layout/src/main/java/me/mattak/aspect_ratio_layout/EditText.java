package me.mattak.aspect_ratio_layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

/**
 * EditText
 * Created by mattak on 2016/02/22.
 */
public class EditText extends android.widget.EditText {
    private Measurement mMeasurement = new Measurement();

    public EditText(Context context) {
        super(context);
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mMeasurement.init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public EditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mMeasurement.init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mMeasurement.init(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int[] measuredDimension = mMeasurement.getMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        this.setMeasuredDimension(measuredDimension[0], measuredDimension[1]);
    }
}

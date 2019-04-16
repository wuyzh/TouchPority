package com.wuyazhou.learn.touchprority.typeone;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author wuyzh
 * */
public class ScrollViewByLayoutParams extends Button {
    private int lastX;
    private int lastY;
    public ScrollViewByLayoutParams(Context context) {
        super(context);
    }

    public ScrollViewByLayoutParams(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewByLayoutParams(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ScrollViewByLayoutParams(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x-lastX;
                int offsetY = y-lastY;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);
                break;
        }
        return true;
    }
}

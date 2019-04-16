package com.wuyazhou.learn.touchprority.typeone;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wuyazhou.learn.logview.LogShowUtil;
import com.wuyazhou.learn.touchprority.R;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class TypeOnePagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;
    private ScrollViewByLayoutParams mScrollViewByLayoutParams;

    public TypeOnePagerView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public TypeOnePagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public TypeOnePagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_type_one_layout, null);

        addView(mLayout);

        mScrollViewByLayoutParams = mLayout.findViewById(R.id.scroll_view);
        mScrollViewByLayoutParams.setOnClickListener(this);

        mScrollViewByLayoutParams.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        LogShowUtil.addLog("分发优先级","onTouch down",true);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        LogShowUtil.addLog("分发优先级","onTouch move",true);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.scroll_view){
            LogShowUtil.addLog("分发优先级","onClick",true);
        }
    }
}

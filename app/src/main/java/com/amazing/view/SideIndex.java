package com.amazing.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lalo.zhang on 2015/8/28.
 */
public class SideIndex extends LinearLayout {

    private int sideHeight;
    private float heightPerItem;

    public SideIndex(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.VERTICAL);
    }

    public SideIndex(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
    }


    public void genIndexBar(Context context,final AmazingListView amazingListView,int letterColor,int textSize) {
        sideHeight = this.getHeight();
        this.removeAllViews();
        List<Pair<String, List<Object>>> data = amazingListView.getAdapter().getData();
        for (int i = 0; i < data.size(); i++) {
            TextView tmpTV = new TextView(context);
            String tmpLetter = data.get(i).first;
            tmpTV.setText(tmpLetter);
            tmpTV.setGravity(Gravity.CENTER);
            tmpTV.setTextColor(letterColor);
            tmpTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize);
            LayoutParams params = new LayoutParams(-1, LayoutParams.WRAP_CONTENT, 1);
            tmpTV.setLayoutParams(params);
            this.addView(tmpTV);
        }

        if (amazingListView.getAdapter().getData().size() > 0) {
            heightPerItem = sideHeight / this.getChildCount();
            this.setTouchDelegate(new TouchDelegate(new Rect(), this) {
                @Override
                public boolean onTouchEvent(MotionEvent event) {
                    int index = (int) (event.getY() / heightPerItem);
                    int position = amazingListView.getAdapter().getPositionForSection(index);
                    amazingListView.setSelection(position);
                    return true;
                }
            });
        }
    }
}

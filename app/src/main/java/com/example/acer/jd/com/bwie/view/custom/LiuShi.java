package com.example.acer.jd.com.bwie.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by acer on 2018/10/20.
 */

public class LiuShi extends ViewGroup {
    public LiuShi(Context context) {
        super(context,null);
    }

    public LiuShi(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public LiuShi(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void addchild(View view){
        if(view!=null){
            addView(view);
            invalidate();
            postInvalidate();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int lineWidth = 0;
        int lineHeight = 0;
        int left = 0;
        int top = 0;
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            MarginLayoutParams layoutParam = (MarginLayoutParams) child.getLayoutParams();
            int cWidth = child.getMeasuredWidth() + layoutParam.leftMargin + layoutParam.rightMargin;
            int cHeight = child.getMeasuredHeight() + layoutParam.topMargin + layoutParam.bottomMargin;
            //换行
            if (cWidth + lineWidth > getMeasuredWidth()) {
                left = 0; top = lineHeight;
                child.layout(left + layoutParam.leftMargin, top + layoutParam.topMargin, left + layoutParam.leftMargin + child.getMeasuredWidth(), top + layoutParam.topMargin + child.getMeasuredHeight());
                left += layoutParam.leftMargin + child.getMeasuredWidth();
                lineWidth = cWidth; lineHeight += cHeight;
            } else {
                lineWidth += cWidth;
                lineHeight = Math.max(lineHeight, cHeight);
                child.layout(left + layoutParam.leftMargin, top + layoutParam.topMargin, left + layoutParam.leftMargin + child.getMeasuredWidth(), top + layoutParam.topMargin + child.getMeasuredHeight());
                left += layoutParam.leftMargin + child.getMeasuredWidth();
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //当前控件最终需要的高度
        int measureWidth=0; int measureHeight=0;
        // 获取侧栏模式的大小和宽度
         int measureWidthSize = MeasureSpec.getSize(widthMeasureSpec);
         int measureHeightSize = MeasureSpec.getSize(heightMeasureSpec);
         int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
         int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);
         //测量子view
         int childCount = getChildCount();
         for (int i = 0; i < childCount; i++) {
             View child = getChildAt(i);
             measureChild(child, widthMeasureSpec, heightMeasureSpec);
             //测量子view
             MarginLayoutParams layoutParam = (MarginLayoutParams) child.getLayoutParams();
             //控件的宽度和左右间隔
             int cWidth = child.getMeasuredWidth() + layoutParam.leftMargin + layoutParam.rightMargin;
             int cHeight = child.getMeasuredHeight() + layoutParam.topMargin + layoutParam.bottomMargin;
             //换行
             if (measureWidth + cWidth > this.getMeasuredWidth()) {
                 measureWidth = Math.max(measureWidth, cWidth);
                 measureHeight += cHeight;
             } else {
                 //当前行
                 measureHeight = Math.max(measureHeight, cHeight); measureWidth += cWidth; } }
                 //把测量的子view的大小设置给当前控件
                 setMeasuredDimension(measureWidthMode == MeasureSpec.EXACTLY ? measureWidthSize : measureWidth, measureHeightMode == MeasureSpec.EXACTLY ? measureHeightSize : measureHeight);
             }
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
    return new MarginLayoutParams(getContext(), attrs);
}
}

package com.qiangyuyang.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.qiangyuyang.demo.R;

/**
 * yangqiangyu on 2017/2/22 14:36
 * email:168553877@qq.com
 * blog:http://blog.csdn.net/yissan
 */

public class CommonLoadingLayout extends FrameLayout {

    private View contentView;
    private Context mContext;
    private CommonLoadingView mLoadingView;

    public CommonLoadingLayout(Context context) {
        this(context,null);
    }

    public CommonLoadingLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CommonLoadingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = this.getChildCount();
        if (childCount >1) {
            throw new RuntimeException("CommonLoadingLayout only can has one childView");
        }
        mLoadingView = (CommonLoadingView) LayoutInflater.from(mContext).inflate(R.layout.common_loading,this,false);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        mLoadingView.setLayoutParams(layoutParams);
        this.addView(mLoadingView);
        contentView = getChildAt(0);
    }


    public void load(){
        mLoadingView.load();
        if (contentView != null) {
            contentView.setVisibility(INVISIBLE);
        }
    }

    public void loadSuccess(){
        mLoadingView.loadSuccess();
        if (contentView != null) {
            contentView.setVisibility(VISIBLE);
        }
    }

    public void loadSuccess(boolean isEmpty){
        mLoadingView.loadSuccess(isEmpty);
        if (contentView != null) {
            contentView.setVisibility(VISIBLE);
        }
    }

    public void loadError(){
        mLoadingView.loadError();
        if (contentView!=null){
            contentView.setVisibility(INVISIBLE);
        }
    }


    public void setLoadingErrorView(View loadingErrorView) {
        this.mLoadingView.setLoadingErrorView(loadingErrorView);
    }

    public void setLoadingView(View loadingView) {
        this.mLoadingView.setLoadingView(loadingView);
    }

    public void setLoadingHandler(CommonLoadingView.LoadingHandler loadingHandler) {
        mLoadingView.setLoadingHandler(loadingHandler);
    }


}

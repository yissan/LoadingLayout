package com.qiangyuyang.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qiangyuyang.demo.widget.CommonLoadingLayout;
import com.qiangyuyang.demo.widget.CommonLoadingView;

public class LoadingLayoutActivity extends AppCompatActivity {

    protected CommonLoadingLayout mLoadingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_loading_layout);


        mLoadingLayout = (CommonLoadingLayout) findViewById(R.id.loadingLayout);

        //设置错误视图点击重新加载事件
        mLoadingLayout.setLoadingHandler(new CommonLoadingView.LoadingHandler() {
            @Override
            public void doRequestData() {
                mLoadingLayout.load();
                mLoadingLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingLayout.loadSuccess();
                    }
                }, 3000);
            }
        });

        //模拟加载网络请求后出现错误
        mLoadingLayout.load();
        mLoadingLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoadingLayout.loadError();
            }
        }, 3000);

    }

}

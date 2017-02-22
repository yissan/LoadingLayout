package com.qiangyuyang.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.qiangyuyang.demo.widget.CommonLoadingView;

import java.util.ArrayList;
import java.util.List;

/**
 * yangqiangyu on 09/01/2017 22:32
 * e-mail:168553877@qq.com
 * blog:http://blog.csdn.net/yissan
 */
public class CustomViewActivity extends AppCompatActivity {

    protected ListView mListView;
    protected CommonLoadingView mLoadingView;
    private List<String> mList = new ArrayList<>();
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_default_view);
        initView();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.listView);
        mLoadingView = (CommonLoadingView) findViewById(R.id.loadingView);


        //设置自定义视图
        ProgressBar progressBar = new ProgressBar(this);
        this.mLoadingView.setLoadingView(progressBar);
        TextView textView = new TextView(this);
        textView.setText("加载失败...");
        this.mLoadingView.setLoadingErrorView(textView);

        mLoadingView.load();

        //设置点击错误视图重新加载事件
        mLoadingView.setLoadingHandler(new CommonLoadingView.LoadingHandler() {
            @Override
            public void doRequestData() {
                mLoadingView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <=20 ; i++) {
                            mList.add(i+"");
                        }
                        adapter = new ArrayAdapter(CustomViewActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, mList);
                        mListView.setAdapter(adapter);
                        mLoadingView.loadSuccess(false);
                    }
                },2500);
            }
        });

        //模拟网络错误，加载失败
        mLoadingView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoadingView.loadError();
            }
        },2500);
    }
}

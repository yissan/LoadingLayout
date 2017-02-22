package com.qiangyuyang.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * yangqiangyu on 09/01/2017 22:32
 * e-mail:168553877@qq.com
 * blog:http://blog.csdn.net/yissan
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    protected Button mDefaultBtn;
    protected Button mCustomBtn;
    protected Button mLayoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.default_btn) {
            Intent intent = new Intent(this, DefaultViewActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.custom_btn) {
            Intent intent = new Intent(this, CustomViewActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.layout_btn) {
            Intent intent = new Intent(this, LoadingLayoutActivity.class);
            startActivity(intent);
        }
    }

    private void initView() {
        mDefaultBtn = (Button) findViewById(R.id.default_btn);
        mDefaultBtn.setOnClickListener(MainActivity.this);
        mCustomBtn = (Button) findViewById(R.id.custom_btn);
        mCustomBtn.setOnClickListener(MainActivity.this);
        mLayoutBtn = (Button) findViewById(R.id.layout_btn);
        mLayoutBtn.setOnClickListener(MainActivity.this);
    }
}

# LoadingLayout
This is a view for simplify the operation to loading


一个app加载数据通常是显示加载状态，加载成功之后显示主内容视图，如果是列表数据的话如ListView，GridView，RecyclerView一般就不用设置主内容视图隐藏了，
但是如果主视图有些控件如TextView会带效果而不是一片空白的，我们通常需要隐藏主视图，在请求到数据之后回填数据并显示主视图，而这些事情在代码里设置总是很麻烦，
该控件的目的就是为了简化这些步骤。


# 特点
1、使用简单，实现原理也简单。


2、支持自定义各种视图，只需要把你要显示的视图set进去即可


![这里写图片描述](http://img.blog.csdn.net/20170118131628163?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveWlzc2Fu/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


3、支持设置错误视图点击事件。

这里只是提供个思路，大家可以下载源码去修改成最适合你的view。


# 使用

1、xml里声明view，包裹在内容视图的外层。

```
<?xml version="1.0" encoding="utf-8"?>
<com.qiangyuyang.demo.widget.CommonLoadingLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/loadingLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin">
    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="计算机代理费了看似简单傅雷家书的法律会计师的浪费空间塑料袋看风景塑料袋看风景说楼顶会计法世纪东方塑料袋看风景说楼顶会计法说楼顶会计法商店里会计法商店里看风景商店里会计法sdk龙卷风老师的傅雷家书东方丽景商店里放假计算机代理费了看似简单傅雷家书的法律会计师的浪费空间塑料袋看风景塑料袋看风景说楼顶会计法世纪东方塑料袋看风景说楼顶会计法说楼顶会计法商店里会计法商店里看风景商店里会计法sdk龙卷风老师的傅雷家书东方丽景商店里放假计算机代理费了看似简单傅雷家书的法律会计师的浪费空间塑料袋看风景塑料袋看风景说楼顶会计法世纪东方塑料袋看风景说楼顶会计法说楼顶会计法商店里会计法商店里看风景商店里会计法sdk龙卷风老师的傅雷家书东方丽景商店里放假计算机代理费了看似简单傅雷家书的法律会计师的浪费空间塑料袋看风景塑料袋看风景说楼顶会计法世纪东方塑料袋看风景说楼顶会计法说楼顶会计法商店里会计法商店里看风景商店里会计法sdk龙卷风老师的傅雷家书东方丽景商店里放假计算机代理费了看似简单傅雷家书的法律会计师的浪费空间塑料袋看风景塑料袋看风景说楼顶会计法世纪东方塑料袋看风景说楼顶会计法说楼顶会计法商店里会计法商店里看风景商店里会计法sdk龙卷风老师的傅雷家书东方丽景商店里放假计算机代理费了看似简单傅雷家书的法律会计师的浪费空间塑料袋看风景塑料袋看风景说楼顶会计法世纪东方塑料袋看风景说楼顶会计法说楼顶会计法商店里会计法商店里看风景商店里会计法sdk龙卷风老师的傅雷家书东方丽景商店里放假"/>
</com.qiangyuyang.demo.widget.CommonLoadingLayout>

```

2、Java代码里获取控件并在合适的时候调用加载，加载失败，加载成功等方法。

```

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
```


3、自定义加载、加载错误、等视图。

```
        ProgressBar progressBar = new ProgressBar(this);
        this.mLoadingLayout.setLoadingView(progressBar);
        TextView textView = new TextView(this);
        textView.setText("加载失败...");
        this.mLoadingLayout.setLoadingErrorView(textView);

        mLoadingLayout.load();
```
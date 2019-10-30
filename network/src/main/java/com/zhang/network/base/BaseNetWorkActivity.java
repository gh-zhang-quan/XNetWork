package com.zhang.network.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public abstract class BaseNetWorkActivity<p extends BasePresenter> extends AppCompatActivity {
    public p presener;
    private AppCompatDelegate mDelegate;

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = initLayout();
        getDelegate().setContentView(layout);
        initView(savedInstanceState);
        initNetWork();
        initData();
    }

    @SuppressWarnings("unchecked")
    private void initNetWork() {
        presener = initPresener();
        //把所有继承此类的Activity都绑定到这里了，这样View就和Present联系起来了。
        presener.addView(this);
    }

    @NonNull
    public AppCompatDelegate getDelegate() {
        if (mDelegate == null) {
            //第一次为空，创建了AppCompatDelegate
            mDelegate = AppCompatDelegate.create(this, this);
        }
        return mDelegate;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presener.detattch();
    }

    //初始化页面
    protected abstract int initLayout();

    //初始化页面布局
    protected abstract void initView(Bundle savedInstanceState);

    //初始化数据
    protected abstract void initData();

    //初始化resenerp
    protected abstract p initPresener();

}

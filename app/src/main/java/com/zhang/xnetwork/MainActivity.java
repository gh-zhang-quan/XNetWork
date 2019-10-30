package com.zhang.xnetwork;

import android.os.Bundle;

import com.zhang.network.base.BaseNetWorkActivity;
import com.zhang.network.presenter.CommonPresenter;
import com.zhang.network.view.CommonView;

public class MainActivity extends BaseNetWorkActivity<CommonPresenter> implements CommonView {

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        presener.getLiveRoomToken(1, 10);
    }

    @Override
    protected CommonPresenter initPresener() {
        return new CommonPresenter(this, "http://219.134.137.178:83/");
    }

    @Override
    public void getResponseSucc(Object data) {

    }

    @Override
    public void getResponseFail(String fail) {

    }
}

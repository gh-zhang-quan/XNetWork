package com.zhang.network.model;

import android.content.Context;

import com.zhang.network.net.ApiInterface;
import com.zhang.network.net.RetrofitManager;
import com.zhang.network.net.nethelper.MyObsever;

import java.util.Map;

@SuppressWarnings("unchecked")
public class CommonModel {

    private final ApiInterface mApiInterface;

    public CommonModel(Context mContext, String url) {
        mApiInterface = RetrofitManager.getInstance(mContext, url).getApiInterface();
    }

    //test接口
    public void getLiveRoomToken(Map<String, String> params, MyObsever<String> obsever) {
        RetrofitManager.requestHandler(mApiInterface.getJewelryMerchantList(params)).subscribe(obsever);
    }

}

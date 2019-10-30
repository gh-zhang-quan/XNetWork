package com.zhang.network.net;

import io.reactivex.Observable;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Author: kuencheung
 * Date:   2018/6/21
 * Des:    统一联网请求接口
 */

public interface ApiInterface {
    //test接口
    @GET("app/search/jewelryMerchant")
    Observable<String> getJewelryMerchantList(@QueryMap Map<String, String> params);
}

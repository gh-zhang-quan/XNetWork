package com.zhang.network.net.interceptor;

import android.content.Context;

import java.io.IOException;

import androidx.annotation.NonNull;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.zhang.network.utils.IsHadNetWorkUtils.isNetworkConnected;
import static com.zhang.network.utils.IsHadNetWorkUtils.ping;

/**
 * Author: kuencheung
 * Date:   2018/8/7
 * Des:    设置缓存
 */
public class MyCacheInterceptor implements Interceptor {
    private Context mContext;

    public MyCacheInterceptor(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        //设置缓存机制
        if (isNetworkConnected(mContext) && ping()) {
            request = request.newBuilder()
                    //网络可用 强制从网络获取数据
                    .cacheControl(CacheControl.FORCE_NETWORK)
                    .build();
        } else {
            request = request.newBuilder()
                    //网络不可用 从缓存获取
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response response = chain.proceed(request);
        if (isNetworkConnected(mContext) && ping()) {
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    // 有网络时 设置缓存超时时间1个小时
                    .header("Cache-Control", "public, max-age=" + 60 * 60)
                    .build();
        } else {
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    // 无网络时，设置超时为4周
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + 7 * 24 * 60 * 60 * 4)
                    .build();
        }

        return response;
    }
}

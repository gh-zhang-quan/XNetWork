package com.zhang.network.net.nethelper;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author: kuencheung
 * Date:   2018/6/21
 * Des:    订阅事件关系,统一处理后台返回数据
 */

public abstract class MyObsever<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        SubscriptionManager.getInstance().add(d);
    }

    @Override
    public void onNext(T t) {
        if (t == null) {
            OnFail("数据为空");
        } else {
            OnSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        //自定义异常的传递
        String fail = ExceptionHandle.handleException(e);
        OnFail(fail);
    }

    public abstract void OnSuccess(T t);

    public abstract void OnFail(String fail);

    public void onComplete() {

    }
}

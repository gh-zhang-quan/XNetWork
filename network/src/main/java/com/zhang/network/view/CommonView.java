package com.zhang.network.view;

public interface CommonView<T> {
    void getResponseSucc(T data);

    void getResponseFail(String fail);

}

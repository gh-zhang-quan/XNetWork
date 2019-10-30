package com.zhang.network.presenter;

import android.content.Context;

import com.zhang.network.base.BasePresenter;
import com.zhang.network.model.CommonModel;
import com.zhang.network.net.nethelper.MyObsever;
import com.zhang.network.view.CommonView;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class CommonPresenter extends BasePresenter<CommonView> {
    private CommonModel mCommonModel;

    public CommonPresenter(Context mContext, String url) {
        mCommonModel = new CommonModel(mContext, url);
    }


    //售后列表
    public void getLiveRoomToken(int offset, int limit) {
        Map<String, String> params = new HashMap<>();
        params.put("offset", String.valueOf(offset));
        params.put("limit", String.valueOf(limit));
        mCommonModel.getLiveRoomToken(params, new MyObsever() {
            @Override
            public void OnSuccess(Object o) {
                if (view != null) {
                    view.getResponseSucc(o);
                }
            }

            @Override
            public void OnFail(String fail) {
                if (view != null) {
                    view.getResponseFail(fail);
                }
            }
        });
    }

}

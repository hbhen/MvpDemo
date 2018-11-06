package com.recyclerviewstickytop30.model;

import android.content.Context;

public class RecyclerViewModel implements ModelManager {
    Context context;
    public onFinish mOnFinish;

    public interface onFinish {
        void OnFinishListener(String string);
    }

    public void setOnFinishListener(onFinish onFinish) {
        this.mOnFinish = onFinish;
    }

//    public RecyclerViewModel(Context context) {
//        this.context = context;
//    }

    public RecyclerViewModel(onFinish onFinish) {
        mOnFinish = onFinish;
    }

    @Override
    public void managerModel() {
        //网络请求,获取到数据以后,再利用接口,把数据传出去,调用者调用
        //网络请求用Retrofit ,用RxJava分线程处理!
        //从基本的请求,添加
        String string = "请求的数据";
        mOnFinish.OnFinishListener(string);
    }
}

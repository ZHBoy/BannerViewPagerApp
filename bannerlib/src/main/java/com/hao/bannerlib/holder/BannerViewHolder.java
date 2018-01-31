package com.hao.bannerlib.holder;

import android.content.Context;
import android.view.View;

/**
* @作者 hao
* @创建日期 2018/1/31 11:13
* Description:
*/
public interface BannerViewHolder<T> {
    /**
     * 创建View
     * @param context
     * @return
     */
    View createView(Context context);

    /**
     * 绑定数据
     * @param context
     * @param position
     * @param data
     */
    void onBind(Context context, int position, T data);
}

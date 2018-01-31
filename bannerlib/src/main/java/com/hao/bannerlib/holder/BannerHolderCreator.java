package com.hao.bannerlib.holder;

/**
* @作者 hao
* @创建日期 2018/1/31 11:13
* Description:
*/

public interface BannerHolderCreator<VH extends BannerViewHolder> {
    /**
     * 创建ViewHolder
     * @return
     */
    VH createViewHolder();
}

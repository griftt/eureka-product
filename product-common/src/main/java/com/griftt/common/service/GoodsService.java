package com.griftt.common.service;

import com.griftt.common.entity.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * 获取所有上架商品
     * @return
     */
    List<Goods> getAllOnSaleGoods();

}

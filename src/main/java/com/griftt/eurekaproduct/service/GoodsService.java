package com.griftt.eurekaproduct.service;

import com.griftt.eurekaproduct.entity.Goods;

import javax.validation.constraints.Max;
import java.util.List;

public interface GoodsService {

    /**
     * 获取所有上架商品
     * @return
     */
    List<Goods> getAllOnSaleGoods();

}

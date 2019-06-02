package com.griftt.eurekaproduct.service.impl;

import com.griftt.eurekaproduct.entity.Goods;
import com.griftt.eurekaproduct.repository.GoodsRepository;
import com.griftt.eurekaproduct.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public List<Goods> getAllOnSaleGoods() {
        return goodsRepository.findAllByRecordStatus(1);
    }
}

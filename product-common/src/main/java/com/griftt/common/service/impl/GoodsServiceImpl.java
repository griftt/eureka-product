package com.griftt.common.service.impl;

import com.griftt.common.entity.Goods;
import com.griftt.common.repository.GoodsRepository;
import com.griftt.common.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Goods getGoodsById(Integer id) {
        return goodsRepository.findAllById(id);
    }

    @Override
    public Goods updateGoodsById(Integer id,String batchNo) {
        Goods goods = goodsRepository.findAllById(id);
        goods.setBatchNo(batchNo);
        return goods;
    }
}

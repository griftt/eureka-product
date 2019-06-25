package com.griftt.server.controller;
import com.griftt.common.entity.Goods;
import com.griftt.common.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goods")
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("all")
    public List<Goods> getAllGoods(){
        return  goodsService.getAllOnSaleGoods();
    }
    @RequestMapping("more")
    public List<Goods> getAllGoodsMore(){
        log.debug("hello seluth more");
        return  goodsService.getAllOnSaleGoods();
    }

    @RequestMapping("one")
    public Goods getAllGoodById(Integer id){
        log.debug("hello seluth one");
        return  goodsService.getGoodsById(id);
    }

}

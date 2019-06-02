package com.griftt.eurekaproduct.controller;

import com.griftt.eurekaproduct.entity.Goods;
import com.griftt.eurekaproduct.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @GetMapping("/all")
    public List<Goods> getAllGoods(){
        return  goodsService.getAllOnSaleGoods();
    }

}

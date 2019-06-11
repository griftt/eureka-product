package com.griftt.server.controller;
import com.griftt.common.entity.Goods;
import com.griftt.common.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("all")
    public List<Goods> getAllGoods(){
        return  goodsService.getAllOnSaleGoods();
    }

}

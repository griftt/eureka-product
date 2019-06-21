package com.griftt.productclient.client;

import com.griftt.common.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product")
public interface GoodsTestFeign {

    @GetMapping("/goods/more")
    public List<Goods> getGoodsMore();
}

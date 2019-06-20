package com.griftt.productclient.client;

import com.griftt.common.entity.Goods;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product",fallback = GoodsOrderFeignClient.ProductClientFallBack.class)
@EntityScan("com.griftt.common")
public interface GoodsOrderFeignClient {

    @GetMapping("/goods/all")
    public List<Goods> getGoodsList();

    @GetMapping("/goods/one")
    public Goods getGoodsById(Integer id);


    @Component
   public static class ProductClientFallBack implements GoodsOrderFeignClient{

        @Override
        public List<Goods> getGoodsList() {
            return null;
        }

        @Override
        public Goods getGoodsById(Integer id) {
            return null;
        }
    }
}

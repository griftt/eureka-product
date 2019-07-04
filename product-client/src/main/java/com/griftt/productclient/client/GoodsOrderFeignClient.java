package com.griftt.productclient.client;

import com.griftt.common.entity.Goods;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "product",fallback = GoodsOrderFeignClient.ProductClientFallBack.class)
public interface GoodsOrderFeignClient {

    @GetMapping("/goods/all")
    public List<Goods> getGoodsList();

    @GetMapping("/goods/one")
    public Goods getGoodsById(Integer id);

    @GetMapping("/goods/jta")
    public Goods updateGoodsById(Integer id,String batchNo);


    @Component
    public static class ProductClientFallBack implements GoodsOrderFeignClient{

        @Override
        public List<Goods> getGoodsList() {
            Goods goods = new Goods();
            goods.setBatchNo(" 服务降级启动list");
            List<Goods> list = new ArrayList<>();
             list.add(goods);
             return list;
        }

        @Override
        public Goods getGoodsById(Integer id) {
            Goods goods = new Goods();
            goods.setBatchNo(" 服务降级启动one ");
            return goods;
        }


        @Override
        public Goods updateGoodsById(Integer id, String batchNo) {
            Goods goods = new Goods();
            goods.setBatchNo("test jt fail : 服务降级启动  ");
            return goods;
        }
    }
}

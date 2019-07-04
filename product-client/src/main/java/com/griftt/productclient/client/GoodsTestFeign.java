package com.griftt.productclient.client;

import com.griftt.common.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "product",fallback =GoodsTestFeign.GoodsTestFallBack.class )
public interface GoodsTestFeign {

    @GetMapping("/goods/more")
    public List<Goods> getGoodsMore();

    @Component
    public class GoodsTestFallBack implements GoodsTestFeign{
        @Override
        public List<Goods> getGoodsMore() {
            return new ArrayList<Goods>();
        }
    }
}

package com.griftt.productclient;

import com.griftt.productclient.client.GoodsOrderFeignClient;
import com.griftt.productclient.client.GoodsTestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Autowired
    private GoodsTestFeign goodsTestFeign;


}

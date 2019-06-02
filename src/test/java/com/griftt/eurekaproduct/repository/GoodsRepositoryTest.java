package com.griftt.eurekaproduct.repository;

import com.griftt.eurekaproduct.entity.Goods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsRepositoryTest {

    @Autowired
    GoodsRepository goodsRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findAllByRecordStatus() {
        List<Goods> goodsList = goodsRepository.findAllByRecordStatus(1);
        Assert.assertNotNull(goodsList);
    }
}
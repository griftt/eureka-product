package com.griftt.eurekaproduct.repository;

import com.griftt.eurekaproduct.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GoodsRepository extends JpaRepository<Goods,Integer> {
    List<Goods> findAllByRecordStatus(Integer recordStatus);
}

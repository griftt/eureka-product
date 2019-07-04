package com.griftt.common.repository;

import com.griftt.common.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GoodsRepository extends JpaRepository<Goods,Integer> {
    List<Goods> findAllByRecordStatus(Integer recordStatus);

    Goods findAllById(Integer id);


}

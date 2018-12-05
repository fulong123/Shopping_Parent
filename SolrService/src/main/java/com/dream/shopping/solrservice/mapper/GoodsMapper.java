package com.dream.shopping.solrservice.mapper;

import com.dream.shopping.solrservice.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/12/4
 * Time: 20:22
 */
@Mapper
@Repository
public interface GoodsMapper  {

    List<Goods> selectAll();
}

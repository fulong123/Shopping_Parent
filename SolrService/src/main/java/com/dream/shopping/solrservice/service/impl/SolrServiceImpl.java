package com.dream.shopping.solrservice.service.impl;

import com.dream.shopping.solrservice.mapper.GoodsMapper;
import com.dream.shopping.solrservice.pojo.Goods;
import com.dream.shopping.solrservice.service.SolrService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/12/5
 * Time: 14:48
 */
@Service
public class SolrServiceImpl implements SolrService {

    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private SolrTemplate solrTemplate;
    @Resource
    private RedisTemplate redisTemplate;

    public List<Goods> selectAll(){

    }
    @Override
    public Map<String, Object> search(Map searchMap) {
        return null;
    }
}

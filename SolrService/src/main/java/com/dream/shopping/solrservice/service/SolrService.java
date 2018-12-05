package com.dream.shopping.solrservice.service;

import com.dream.shopping.facade.po.Goods;

import java.util.Map;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/12/5
 * Time: 14:43
 */
public interface SolrService {

    /**
     * 搜索 -- 从Solr索引库中
     *
     * @param searchMap
     * @return
     */
    Map<String, Object> search(Map searchMap);

}

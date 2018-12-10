package com.dream.shopping.solrservice.controller;

import com.dream.shopping.solrservice.pojo.Goods;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/12/5
 * Time: 12:02
 */
@Controller
@RequestMapping("/solr")
public class SolrController {

    @Resource
    private SolrClient solrClient;

    @RequestMapping("/select")
    @ResponseBody
    public Map<String, Object> select(String keyword, int page, int rows) {

        SolrQuery query = new SolrQuery();
        query.setQuery(keyword);
        query.addSort("goodsPrice", SolrQuery.ORDER.desc);
        query.setStart((page - 1) * rows);
        query.setRows(rows);
        query.set("df", "");
        query.setHighlight(true);
        query.addHighlightField("goodsTitle");
        query.setHighlightSimplePre("<span style='color:red'>");
        query.setHighlightSimplePost("</span>");
        QueryResponse queryResponse;
        try {
            queryResponse = solrClient.query("goods", query);
            SolrDocumentList results = queryResponse.getResults();
            long total = results.getNumFound();
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
            Map<String, Object> map = new HashMap<>();
            map.put("total", total);
            map.put("data", highlight);
            return map;
        } catch (SolrServerException |IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/add")
    public String addSolr() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        Goods goods = new Goods();
        try {
            SolrInputDocument document = new SolrInputDocument();
            document.setField("goodsId", uuid);
            document.setField("goodsType", goods.getGoodsType());
            document.setField("goodsTitle", goods.getGoodsTitle());
            document.setField("goodsPrice", goods.getGoodsPrice());
            document.setField("goodsPhoto", goods.getGoodsPhoto());
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        try {
            solrClient.deleteById(id);
            solrClient.commit();
            return id;
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("deleteAll")
    public String deleteAll() {
        try {

            solrClient.deleteByQuery("*:*");
            solrClient.commit();

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

}

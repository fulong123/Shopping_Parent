package com.dream.shopping.productserver.service;

import com.dream.shopping.facade.po.Goods;

import java.util.List;

/**
 * 描述:  商品的服务
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/21
 * Time: 20:41
 */
public interface GoodsService {

    /**
     * 描述 通过条件查询所有
     * @author huiliao
     * @date 2018/11/21 17:06
     * @param goods
     * @return java.util.List<com.dream.shopping.facade.po.Goods>
     */
    List<Goods> selectGoodsAll(Goods goods);

    /**
     * 描述  通过id查询
     * @author huiliao
     * @date 2018/11/21 17:09
     * @param id
     * @return com.dream.shopping.facade.po.Goods
     */
    Goods selectGoodsById(Integer id);

    /**
     * 描述    添加商品
     * @author huiliao
     * @date 2018/11/21 17:20
     * @param goods
     * @return int
     */
    int insertGoods(Goods goods);

    /**
     * 描述     修改商品
     * @author huiliao
     * @date 2018/11/21 17:41
     * @param goods
     * @return int
     */
    int updateGoods(Goods goods);

    /**
     * 描述   通过id删除商品
     * @author huiliao
     * @date 2018/11/21 17:48
     * @param id
     * @return int
     */
    int deleteGoodsById(Integer id);
}

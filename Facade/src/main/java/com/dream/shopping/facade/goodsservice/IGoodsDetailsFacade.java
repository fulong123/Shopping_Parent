package com.dream.shopping.facade.goodsservice;

import com.dream.shopping.facade.po.GoodsDetails;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/22
 * Time: 10:16
 */
public interface IGoodsDetailsFacade {
    /**
     * 描述  通过条件查询所有
     * @author huiliao
     * @date 2018/11/21 19:50
     * @param [goodsDetails]
     * @return java.util.List<com.dream.shopping.facade.po.GoodsDetails>
     */
    List<GoodsDetails> selectAll(GoodsDetails goodsDetails);

    /**
     * 描述    通过id查询商品详情
     * @author huiliao
     * @date 2018/11/21 20:08
     * @param [id]
     * @return com.dream.shopping.facade.po.GoodsDetails
     */
    GoodsDetails selectGoodsDetailsById(Integer id);

    /**
     * 描述   添加商品详情
     * @author huiliao
     * @date 2018/11/21 20:19
     * @param [goodsDetails]
     * @return int
     */
    int insertGoodsDetails(GoodsDetails goodsDetails);

    /**
     * 描述  修改商品详情
     * @author huiliao
     * @date 2018/11/21 20:20
     * @param [goodsDetails]
     * @return int
     */
    int updateGoodsDetails(GoodsDetails goodsDetails);

    /**
     * 描述    通过id删除
     * @author huiliao
     * @date 2018/11/21 20:22
     * @param [id]
     * @return int
     */
    int deleteGoodsDetailsById(Integer id);

}

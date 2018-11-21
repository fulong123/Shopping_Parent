package com.dream.shopping.productypeserver.service;

import com.dream.shopping.facade.po.GoodsType;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/21
 * Time: 20:33
 */
public interface IGoods_TypeService {
    /**
     * 描述 添加商品类别
     * @author cqq
     * @date 2018/11/21 20:22
     * @param []
     * @return int
     */
    int insertGoods_Type();
    /**
     * 描述 根据Id删除商品类别
     * @author cqq
     * @date 2018/11/21 20:23
     * @param [id]
     * @return int
     */
    int deleteGoods_TypeById(int id);
    /**
     * 描述 根据父Id删除商品类别
     * @author cqq
     * @date 2018/11/21 20:25
     * @param [id]
     * @return int
     */
    int deleteGoods_TypeByParent_id(int id);
    /**
     * 描述 查询商品类别
     * @author cqq
     * @date 2018/11/21 20:26
     * @param []
     * @return java.util.List<com.dream.shopping.facade.po.GoodsType>
     */
    List<GoodsType> selectGoods_Type();
    /**
     * 描述 根据等级查询商品类别
     * @author cqq
     * @date 2018/11/21 20:29
     * @param [num]
     * @return java.util.List<com.dream.shopping.facade.po.GoodsType>
     */
    List<GoodsType> selectGoods_TypeByGoodsTypeGrade(int num);
    /**
     * 描述 根据父id查询商品类别
     * @author cqq
     * @date 2018/11/21 20:30
     * @param [id]
     * @return java.util.List<com.dream.shopping.facade.po.GoodsType>
     */
    List<GoodsType> selectGoods_TypeByParentId(int id);
    /**
     * 描述 根据Id查询商品类别
     * @author cqq
     * @date 2018/11/21 20:32
     * @param [id]
     * @return com.dream.shopping.facade.po.GoodsType
     */
    GoodsType selectGoods_TypeByGoodsTypeId(int id);
}

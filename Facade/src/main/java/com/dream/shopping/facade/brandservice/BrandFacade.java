package com.dream.shopping.facade.brandservice;

import com.dream.shopping.facade.po.Brand;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/22
 * Time: 19:53
 */
public interface BrandFacade {
    /**
     * 描述 查询所有
     * @author huiliao
     * @date 2018/11/21 13:53
     * @param [brand]
     * @return java.util.List<com.dream.shopping.facade.po.Brand>
     */
    List<Brand> selectAll(Brand brand);
    /**
     * 描述 通过id查询品牌
     * @author huiliao
     * @date 2018/11/21 13:54
     * @param [id]
     * @return com.dream.shopping.facade.po.Brand
     */
    Brand selectBrandById(Integer id);

    /**
     * 描述 添加品牌
     * @author huiliao
     * @date 2018/11/21 13:58
     * @param [brand]
     * @return int
     */
    int insertBrand(Brand brand);

    /**
     * 描述 修改品牌
     * @author huiliao
     * @date 2018/11/21 13:59
     * @param [brand]
     * @return int
     */
    int updateBrand(Brand brand);

    /**
     * 描述 通过id删除品牌
     * @author huiliao
     * @date 2018/11/21 14:01
     * @param [id]
     * @return int
     */
    int deleteBrandById(Integer id);
}

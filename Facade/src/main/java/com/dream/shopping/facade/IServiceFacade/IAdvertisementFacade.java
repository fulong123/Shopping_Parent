package com.dream.shopping.facade.IServiceFacade;

import com.dream.shopping.facade.po.Advertisement;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/26
 * Time: 19:12
 */
public interface IAdvertisementFacade {

    /**
     * 描述 按条件查询所有广告
     * @author cx
     * @date 2018/11/21 11:09
     * @param [advertisement]
     * @return java.util.List<com.dream.shopping.facade.po.Advertisement>
     */
    List<Advertisement> selectAll(Advertisement advertisement);
    /**
     * 描述 添加广告
     * @author cx
     * @date 2018/11/21 11:09
     * @param [advertisement]
     * @return int
     */
    int insertAdvertisement(Advertisement advertisement);
    /**
     * 描述 通过ID更新广告
     * @author cx
     * @date 2018/11/21 11:08
     * @param [advertisement]
     * @return int
     */
    int updateById(Advertisement advertisement);

    /**
     * 描述 通过ID删除广告
     * @author cx
     * @date 2018/11/21 11:08
     * @param [advertisementId]
     * @return int
     */
    int deleteById(Integer advertisementId);

    /**
     * 描述 通过ID查找广告
     * @author cx
     * @date 2018/11/21 11:08
     * @param [advertisementId]
     * @return com.dream.shopping.facade.po.Advertisement
     */
    Advertisement selectById(Integer advertisementId);
}

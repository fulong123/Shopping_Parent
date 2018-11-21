package com.dream.shopping.adserver.mapper;

import com.dream.shopping.adserver.vo.AdvertisementVo;
import com.dream.shopping.adserver.vo.CustomerAdvertisement;
import com.dream.shopping.facade.po.Advertisement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:广告的Mapper
 * Created with IntelliJ IDEA.
 * User: cx
 * Date: 2018/11/20
 * Time: 11:54
 */
@Mapper
@Repository
public interface AdvertisementMapper {
    /**
     * 描述 按条件查询所有广告
     * @author cx
     * @date 2018/11/20 12:02
     * @param [advertisement]
     * @return java.util.List<com.dream.shopping.pojo.po.Advertisement>
     */
    List<Advertisement> selectAll(Advertisement advertisement);
    /**
     * 描述 添加广告
     * @author cx
     * @date 2018/11/20 14:22
     * @param [advertisement]
     * @return java.lang.Integer
     */
    int insertAdvertisement(Advertisement advertisement);
    /**
     * 描述 通过ID更新广告
     * @author cx
     * @date 2018/11/20 14:23
     * @param [advertisement]
     * @return java.lang.Integer
     */
    int updateById(Advertisement advertisement);
    /**
     * 描述 通过ID删除广告
     * @author cx
     * @date 2018/11/20 14:25
     * @param [advertisementId]
     * @return java.lang.Integer
     */
    int deleteById(Integer advertisementId);

    /**
     * 描述 通过ID查找广告
     * @author cx
     * @date 2018/11/20 17:04
     * @param [advertisementId]
     * @return com.dream.shopping.facade.po.Advertisement
     */
    Advertisement selectById(Integer advertisementId);
}

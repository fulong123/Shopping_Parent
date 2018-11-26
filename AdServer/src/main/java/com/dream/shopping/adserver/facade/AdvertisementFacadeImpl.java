package com.dream.shopping.adserver.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.adserver.service.AdvertisementService;
import com.dream.shopping.facade.IServiceFacade.IAdvertisementFacade;
import com.dream.shopping.facade.po.Advertisement;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/26
 * Time: 19:13
 */
@Service(version = "1.0.0")
public class AdvertisementFacadeImpl implements IAdvertisementFacade {

    @Resource
    private AdvertisementService advertisementService;

    @Override
    public List<Advertisement> selectAll(Advertisement advertisement) {
        return advertisementService.selectAll(advertisement);
    }

    @Override
    public int insertAdvertisement(Advertisement advertisement) {
        return advertisementService.insertAdvertisement(advertisement);
    }

    @Override
    public int updateById(Advertisement advertisement) {
        return advertisementService.updateById(advertisement);
    }

    @Override
    public int deleteById(Integer advertisementId) {
        return advertisementService.deleteById(advertisementId);
    }

    @Override
    public Advertisement selectById(Integer advertisementId) {
        return advertisementService.selectById(advertisementId);
    }
}
package com.dream.shopping.adserver.service.impl;

import com.dream.shopping.adserver.mapper.AdvertisementMapper;
import com.dream.shopping.adserver.service.AdvertisementService;
import com.dream.shopping.facade.po.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:广告的Service实现类
 * Created with IntelliJ IDEA.
 * User: cx
 * Date: 2018/11/21
 * Time: 11:09
 */

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementMapper advertisementMapper;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementMapper advertisementMapper){
        this.advertisementMapper=advertisementMapper;
    }

    @Override
    public List<Advertisement> selectAll(Advertisement advertisement) {
        return advertisementMapper.selectAll(advertisement);
    }

    @Override
    public int insertAdvertisement(Advertisement advertisement) {
        return advertisementMapper.insertAdvertisement(advertisement);
    }

    @Override
    public int updateById(Advertisement advertisement) {
        return advertisementMapper.updateById(advertisement);
    }

    @Override
    public int deleteById(Integer advertisementId) {
        return advertisementMapper.deleteById(advertisementId);
    }

    @Override
    public Advertisement selectById(Integer advertisementId) {
        return advertisementMapper.selectById(advertisementId);
    }
}

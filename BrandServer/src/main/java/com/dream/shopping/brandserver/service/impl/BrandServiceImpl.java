package com.dream.shopping.brandserver.service.impl;

import com.dream.shopping.brandserver.mapper.BrandMapper;
import com.dream.shopping.brandserver.service.BrandService;
import com.dream.shopping.facade.po.Brand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/21
 * Time: 14:14
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    BrandMapper brandMapper;
    @Override
    public List<Brand> selectAll(Brand brand) {
        return brandMapper.selectAll(brand);
    }

    @Override
    public Brand selectBrandById(Integer id) {
        return brandMapper.selectBrandById(id);
    }

    @Override
    public int insertBrand(Brand brand) {
        return brandMapper.insertBrand(brand);
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.updateBrand(brand);
    }

    @Override
    public int deleteBrandById(Integer id) {
        return brandMapper.deleteBrandById(id);
    }
}

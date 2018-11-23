package com.dream.shopping.brandserver.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.brandserver.service.BrandService;
import com.dream.shopping.facade.IServiceFacade.IBrandFacade;
import com.dream.shopping.facade.po.Brand;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/22
 * Time: 19:56
 */
@Component
@Service(version = "1.0.0")
public class BrandFacadeImpl implements IBrandFacade {

    @Resource
    BrandService brandService;
    @Override
    public List<Brand> selectAll(Brand brand) {
        return brandService.selectAll(brand);
    }

    @Override
    public Brand selectBrandById(Integer id) {
        return brandService.selectBrandById(id);
    }

    @Override
    public int insertBrand(Brand brand) {
        return brandService.insertBrand(brand);
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandService.updateBrand(brand);
    }

    @Override
    public int deleteBrandById(Integer id) {
        return brandService.deleteBrandById(id);
    }
}

package com.dream.shopping.administrationserver.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.administrationserver.service.IAdministraterService;
import com.dream.shopping.facade.IServiceFacade.IAdministerFacade;
import com.dream.shopping.facade.po.Administrator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/24
 * Time: 11:12
 */
@Component
@Service(version = "1.0.0")
public class AdministerFacadeImpl implements IAdministerFacade {

    @Resource
    private IAdministraterService administraterService;

    @Override
    public Integer insertAdmin(Administrator admin) {
        return administraterService.insertAdmin(admin);
    }

    @Override
    public Integer deleteAdminById(Integer admin_id) {
        return administraterService.deleteAdminById(admin_id);
    }

    @Override
    public Integer deleteByBatch(List<Administrator> admin) {
        return administraterService.deleteByBatch(admin);
    }

    @Override
    public Integer deleteAll() {
        return administraterService.deleteAll();
    }

    @Override
    public Administrator selectById(Integer admin_id) {
        return administraterService.selectById(admin_id);
    }

    @Override
    public List<Administrator> selectByAdmin(Administrator admin) {
        return administraterService.selectByAdmin(admin);
    }

    @Override
    public Integer updateAdmin(Administrator admin) {
        return administraterService.updateAdmin(admin);
    }
}
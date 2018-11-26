package com.dream.shopping.administrationserver.service.impl;

import com.dream.shopping.administrationserver.mapper.AdministerMapper;
import com.dream.shopping.administrationserver.service.IAdministraterService;
import com.dream.shopping.facade.po.Administrator;
import com.dream.shopping.facade.vo.AdminVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/24
 * Time: 11:09
 */
@Service
public class AdministerService implements IAdministraterService {

    private final AdministerMapper administerMapper;

    @Autowired
    public AdministerService (AdministerMapper administerMapper){
        this.administerMapper = administerMapper;
    }

    @Override
    public Integer insertAdmin(Administrator admin) {
        return administerMapper.insertAdmin(admin);
    }

    @Override
    public Integer deleteAdminById(Integer admin_id) {
        return administerMapper.deleteAdminById(admin_id);
    }

    @Override
    public Integer deleteByBatch(List<Administrator> admin) {
        return administerMapper.deleteByBatch(admin);
    }

    @Override
    public Integer deleteAll() {
        return administerMapper.deleteAll();
    }

    @Override
    public Administrator selectById(Integer admin_id) {
        return administerMapper.selectById(admin_id);
    }

    @Override
    public List<Administrator> selectByAdmin(AdminVo adminVo) {
        return administerMapper.selectByAdmin(adminVo);
    }

    @Override
    public Integer updateAdmin(Administrator admin) {
        return administerMapper.updateAdmin(admin);
    }
}
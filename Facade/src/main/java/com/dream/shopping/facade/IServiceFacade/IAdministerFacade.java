package com.dream.shopping.facade.IServiceFacade;

import com.dream.shopping.facade.po.Administrator;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/24
 * Time: 11:13
 */
public interface IAdministerFacade {

    /**
     * 描述 添加用户
     * @author sky
     * @date 2018/11/20 12:23
     * @param [userVo]
     * @return java.a.Integer
     */
    Integer insertAdmin(Administrator admin);

    /**
     * 描述 通过id删除用户
     * @author sky
     * @date 2018/11/20 12:24
     * @param [userVo]
     * @return java.a.Integer
     */
    Integer deleteAdminById(Integer admin_id);

    /**
     * 描述 批量删除
     * @author sky
     * @date 2018/11/20 14:56
     * @param [userVos]
     * @return java.a.Integer
     */
    Integer deleteByBatch(List<Administrator> admin);

    /**
     * 描述 通过某一属性删除全部
     * @author sky
     * @date 2018/11/20 12:27
     * @param [userVo]
     * @return java.a.Integer
     */
    Integer deleteAll();

    /**
     * 描述 通过id查找user
     * @author sky
     * @date 2018/11/20 11:12
     * @param [uId]
     * @return User
     */
    Administrator selectById(Integer admin_id);

    /**
     * 描述 查询所有
     * @author sky
     * @date 2018/11/20 11:55
     * @param []
     * @return java.util.List<User>
     */
    List<Administrator> selectByAdmin(Administrator admin);

    /**
     * 描述 通过id修改
     * @author sky
     * @date 2018/11/20 12:29
     * @param [uId]
     * @return java.a.Integer
     */
    Integer updateAdmin(Administrator admin);
}

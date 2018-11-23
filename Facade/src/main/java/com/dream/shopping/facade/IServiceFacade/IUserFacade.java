package com.dream.shopping.facade.IServiceFacade;

import com.dream.shopping.facade.po.User;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 23:55
 */
public interface IUserFacade {

    /**
     * 描述 添加用户
     * @author sky
     * @date 2018/11/20 12:23
     * @param [userVo]
     * @return java.a.Integer
     */
    Integer insertUser(User user);

    /**
     * 描述 通过id删除用户
     * @author sky
     * @date 2018/11/20 12:24
     * @param [userVo]
     * @return java.a.Integer
     */
    Integer deleteUserById(Integer uId);

    /**
     * 描述 批量删除
     * @author sky
     * @date 2018/11/20 14:56
     * @param [userVos]
     * @return java.a.Integer
     */
    Integer deleteByBatch(List<User> user);

    /**
     * 描述 删除全部
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
     * @return com.dream.shopping.facade.po.User
     */
    User selectById(Integer uId);

    /**
     * 描述 通过某一属性查询
     * @author sky
     * @date 2018/11/20 11:55
     * @param []
     * @return java.util.List<com.dream.shopping.facade.po.User>
     */
    List<User> selectByUser(User user);

    /**
     * 描述 通过id修改
     * @author sky
     * @date 2018/11/20 12:29
     * @param [uId]
     * @return java.a.Integer
     */
    Integer updateUser(User user);
}
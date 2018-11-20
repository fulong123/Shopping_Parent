package com.dream.shopping.shoppinguserservice.service;

import com.dream.shopping.facade.po.User;
import com.dream.shopping.shoppinguserservice.vo.UserVo;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 11:13
 */
public interface IUserService {

    /**
     * 描述 添加用户
     * @author sky
     * @date 2018/11/20 12:23
     * @param [userVo]
     * @return java.lang.Integer
     */
    Integer insertUser(UserVo userVo);

    /**
     * 描述 通过id删除用户
     * @author sky
     * @date 2018/11/20 12:24
     * @param [userVo]
     * @return java.lang.Integer
     */
    Integer deleteUserById(Integer uId);

    /**
     * 描述 通过某一属性删除全部
     * @author sky
     * @date 2018/11/20 12:27
     * @param [userVo]
     * @return java.lang.Integer
     */
    Integer deleteAll(UserVo userVo);

    /**
     * 描述 通过id查找user
     * @author sky
     * @date 2018/11/20 11:12
     * @param [uId]
     * @return com.dream.shopping.facade.po.User
     */
    User selectById(Integer uId);

    /**
     * 描述 查询所有
     * @author sky
     * @date 2018/11/20 11:55
     * @param []
     * @return java.util.List<com.dream.shopping.facade.po.User>
     */
    List<User> selectAll(UserVo userVo);

    /**
     * 描述 通过id修改
     * @author sky
     * @date 2018/11/20 12:29
     * @param [uId]
     * @return java.lang.Integer
     */
    Integer updateUser(Integer uId);
}

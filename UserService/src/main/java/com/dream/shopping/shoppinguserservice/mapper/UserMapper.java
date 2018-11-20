package com.dream.shopping.shoppinguserservice.mapper;

import com.dream.shopping.facade.po.User;
import com.dream.shopping.shoppinguserservice.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:user的mapper层
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 10:33
 */
@Mapper
@Repository
public interface UserMapper {

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
     * 描述 批量删除
     * @author sky
     * @date 2018/11/20 14:56
     * @param [userVos]
     * @return java.lang.Integer
     */
    Integer deleteByBatch(List<UserVo> userVos);

    /**
     * 描述 通过某一属性删除全部
     * @author sky
     * @date 2018/11/20 12:27
     * @param [userVo]
     * @return java.lang.Integer
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
     * 描述 查询所有
     * @author sky
     * @date 2018/11/20 11:55
     * @param []
     * @return java.util.List<com.dream.shopping.facade.po.User>
     */
    List<User> selectByUserVo(UserVo userVo);

    /**
     * 描述 通过id修改
     * @author sky
     * @date 2018/11/20 12:29
     * @param [uId]
     * @return java.lang.Integer
     */
    Integer updateUser(Integer uId);
}

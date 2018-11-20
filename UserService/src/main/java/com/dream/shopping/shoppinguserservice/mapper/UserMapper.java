package com.dream.shopping.shoppinguserservice.mapper;

import com.dream.shopping.facade.po.User;
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
    List<User> selectAll(User user);




}

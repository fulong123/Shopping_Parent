package com.dream.shopping.facade.IServiceFacade;

import com.dream.shopping.facade.po.News;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/26
 * Time: 14:55
 */
public interface INewsFacade {

    /**
     * 描述 添加新闻
     * @author sky
     * @date 2018/11/20 12:23
     * @param [news]
     * @return java.a.Integer
     */
    Integer insertNews(News news);

    /**
     * 描述 通过id删除新闻
     * @author sky
     * @date 2018/11/20 12:24
     * @param [newsId]
     * @return java.a.Integer
     */
    Integer deleteNewsById(Integer newsId);

    /**
     * 描述 批量删除
     * @author sky
     * @date 2018/11/20 14:56
     * @param [news]
     * @return java.a.Integer
     */
    Integer deleteByBatch(List<News> news);

    /**
     * 描述 通过某一属性删除全部
     * @author sky
     * @date 2018/11/20 12:27
     * @param []
     * @return java.a.Integer
     */
    Integer deleteAll();

    /**
     * 描述 通过id查找News
     * @author sky
     * @date 2018/11/20 11:12
     * @param [newsId]
     * @return User
     */
    News selectById(Integer newsId);

    /**
     * 描述 查询所有
     * @author sky
     * @date 2018/11/20 11:55
     * @param []
     * @return java.util.List<News>
     */
    List<News> selectByNews(News news);

    /**
     * 描述 通过id修改
     * @author sky
     * @date 2018/11/20 12:29
     * @param [uId]
     * @return java.a.Integer
     */
    Integer updateNews(News news);
}

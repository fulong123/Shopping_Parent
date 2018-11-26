package com.dream.shopping.newsserver.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.facade.IServiceFacade.INewsFacade;
import com.dream.shopping.facade.po.News;
import com.dream.shopping.newsserver.service.INewsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/26
 * Time: 14:56
 */
@Service(version = "1.0.0")
public class NewsFacadeImpl implements INewsFacade {

    @Resource
    private INewsService iNewsService;

    @Override
    public Integer insertNews(News news) {
        return iNewsService.insertNews(news);
    }

    @Override
    public Integer deleteNewsById(Integer newsId) {
        return iNewsService.deleteNewsById(newsId);
    }

    @Override
    public Integer deleteByBatch(List<News> news) {
        return iNewsService.deleteByBatch(news);
    }

    @Override
    public Integer deleteAll() {
        return iNewsService.deleteAll();
    }

    @Override
    public News selectById(Integer newsId) {
        return iNewsService.selectById(newsId);
    }

    @Override
    public List<News> selectByNews(News news) {
        return iNewsService.selectByNews(news);
    }

    @Override
    public Integer updateNews(News news) {
        return iNewsService.updateNews(news);
    }
}
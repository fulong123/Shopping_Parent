package com.dream.shopping.newsserver.service.impl;

import com.dream.shopping.facade.po.News;
import com.dream.shopping.newsserver.mapper.NewsMapper;
import com.dream.shopping.newsserver.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/21
 * Time: 13:02
 */
@Service
public class NewsService implements INewsService {

    private final NewsMapper newsMapper;

    @Autowired
    public NewsService (NewsMapper newsMapper){
        this.newsMapper = newsMapper;
    }

    @Override
    public Integer insertNews(News news) {
        return newsMapper.insertNews(news);
    }

    @Override
    public Integer deleteNewsById(Integer newsId) {
        return newsMapper.deleteNewsById(newsId);
    }

    @Override
    public Integer deleteByBatch(List<News> news) {
        return newsMapper.deleteByBatch(news);
    }

    @Override
    public Integer deleteAll() {
        return newsMapper.deleteAll();
    }

    @Override
    public News selectById(Integer newsId) {
        return newsMapper.selectById(newsId);
    }

    @Override
    public List<News> selectByNews(News news) {
        return newsMapper.selectByNews(news);
    }

    @Override
    public Integer updateNews(News news) {
        return newsMapper.updateNews(news);
    }
}
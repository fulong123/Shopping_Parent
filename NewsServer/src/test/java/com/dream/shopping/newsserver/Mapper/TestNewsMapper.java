package com.dream.shopping.newsserver.Mapper;

import com.dream.shopping.facade.po.News;
import com.dream.shopping.newsserver.mapper.NewsMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dbunit.DBTestCase;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:测试newMapper
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 15:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional(transactionManager = "transactionManager")
@Rollback()
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        MockitoTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
        value = "classpath:insertDBUnit/news.xml")
@DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
        value = "classpath:sourceDBUnit/news.xml")
public class TestNewsMapper extends DBTestCase {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private IDatabaseConnection connection;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private NewsMapper newsMapper;

    private String path;

    @Before
    public void init() throws SQLException, DatabaseUnitException, IOException {
        newsMapper = sqlSessionFactory.openSession().getMapper(NewsMapper.class);
        path = new File("").getCanonicalPath();
        connection = new DatabaseConnection(dataSource.getConnection());
        //connection = new DatabaseConnection(DBUtil.getConnection());
        //DatabaseOperation.CLEAN_INSERT.execute(connection,new FlatXmlDataSet(new InputSource(path + "/src/resources/insertDBUnit/news.xml")));
    }

    @Test
    public void testSelectById(){
        News byId = newsMapper.selectById(2);
        assertSame("成功",2,byId.getNewsId());
    }

    @Test
    public void testUpdateByPrimaryKeySelective(){
        News news = new News();
        news.setNewsId(2);
        news.setNewsType("111");
        Integer integer = newsMapper.updateNews(news);
        assertSame(null,1,integer);
    }

    @Test
    public void testInsertSelective(){
        News news = new News();
        news.setNewsId(1);
        news.setNewsType("111");
        Integer integer = newsMapper.insertNews(news);
        assertSame(null,1,integer);
    }

    @Test
    public void testDeleteNewsById(){
        Integer integer = newsMapper.deleteNewsById(2);
        assertSame(1,integer);
    }

    @Test
    public void testDeleteAll(){
        Integer integer = newsMapper.deleteAll();
        assertEquals(4,integer.intValue());
    }

    @Test
    public void testDeleteByBatch(){
        ArrayList<News> list = new ArrayList<>();
        News news = new News();
        news.setNewsId(2);
        News news1 = new News();
        news1.setNewsId(3);
        list.add(news);
        list.add(news1);
        Integer integer = newsMapper.deleteByBatch(list);
        assertSame(2,integer);
    }

    @Test
    public void testSelectByUser(){
        News news = new News();
        news.setNewsTitle("%脉%");
        news.setNewsType("%西瓜%");
        List<News> newsList = newsMapper.selectByNews(news);
        for (News news1:newsList) {
            System.out.println(news1);
        }
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return connection.createDataSet();
    }

//    @Test
//    public void backTable() throws DataSetException, IOException {
//        QueryDataSet queryDataSet = new QueryDataSet(connection);
//        queryDataSet.addTable("news", "select * from news");
//        FlatXmlDataSet.write(queryDataSet, new FileOutputStream(path + "/src/resources/sourceDBUnit/news.xml"));
//    }
}
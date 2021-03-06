package com.dream.shopping.productserver.GoodsTest;


import com.dream.shopping.facade.po.Goods;
import com.dream.shopping.productserver.mapper.GoodMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dbunit.DBTestCase;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Assert;
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

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/21
 * Time: 22:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
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
public class GoodTest extends DBTestCase {
    @Resource
    private IDatabaseConnection connection;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private DataSource dataSource;

    @Resource
    private GoodMapper goodMapper;

    private String path;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return connection.createDataSet();
    }

    @Before
    public void init() throws SQLException, DatabaseUnitException, IOException {
        goodMapper = sqlSessionFactory.openSession().getMapper(GoodMapper.class);
        path = new File("").getCanonicalPath();
        connection = new DatabaseConnection(dataSource.getConnection());
        backTable();
    }

    public void backTable() throws DataSetException, IOException {
        QueryDataSet queryDataSet = new QueryDataSet(connection);
        queryDataSet.addTable("goods", "select * from goods");
        FlatXmlDataSet.write(queryDataSet, new FileOutputStream(path + "/src/test/resources/sourceDBUnit/goods.xml"));
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/goods.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/goods.xml")
    public void testSelectAll() {
        Goods goods2 = new Goods();
        goods2.setGoodsTitle("%1%");
        List<Goods> goods = goodMapper.selectGoodsAll(goods2);
        for (Goods goods1 :
                goods) {
            System.out.println(goods1);
        }
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/goods.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/goods.xml")
    public void testSelectById() {
        Goods goods = goodMapper.selectGoodsById(3);
        assertSame("成功", 3, goods.getGoodsId());
        assertEquals("111", goods.getGoodsTitle());
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/goods.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/goods.xml")
    public void testInsert() {
        Goods goods = new Goods("1,2,3","优雅男装","http://47.107.33.131:8888/group1/M00/00/00/rBAkalv89JKAX4_6AAAgSo34IvA940.jpg","2018-11-27 15:29:45",111,123.0,0,1);

        int i = goodMapper.insertGoods(goods);
        Assert.assertEquals(1, i);
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/goods.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/goods.xml")
    public void testUpdate() {
        Goods goods = new Goods("5","222","11111","2018-12-5"
                ,13,1223.0,11,1);
        goods.setGoodsId(3);
        int i = goodMapper.updateGoods(goods);
        Assert.assertEquals(1, i);
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/goods.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/goods.xml")
    public void testDelete() {

        int i = goodMapper.deleteGoodsById(3);
        Assert.assertEquals(1, i);
    }
}

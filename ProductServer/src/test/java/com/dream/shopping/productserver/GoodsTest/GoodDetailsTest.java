package com.dream.shopping.productserver.GoodsTest;


import com.dream.shopping.facade.po.GoodsDetails;
import com.dream.shopping.productserver.mapper.GoodsDetailsMapper;
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
public class GoodDetailsTest extends DBTestCase {
    @Resource
    private IDatabaseConnection connection;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private DataSource dataSource;

    @Resource
    private GoodsDetailsMapper goodsDetailsMapper;

    private String path;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return connection.createDataSet();
    }

    @Before
    public void init() throws SQLException, DatabaseUnitException, IOException {
        goodsDetailsMapper = sqlSessionFactory.openSession().getMapper(GoodsDetailsMapper.class);
        path = new File("").getCanonicalPath();
        connection = new DatabaseConnection(dataSource.getConnection());
        backTable();
    }

    public void backTable() throws DataSetException, IOException {
        QueryDataSet queryDataSet = new QueryDataSet(connection);
        queryDataSet.addTable("goodsDetails", "select * from goodsDetails");
        FlatXmlDataSet.write(queryDataSet, new FileOutputStream(path + "/src/test/resources/sourceDBUnit/goodsDetails.xml"));
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/goodsDetails.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/goodsDetails.xml")
    public void testSelectAll() {
        GoodsDetails goodsDetails = new GoodsDetails();
        goodsDetails.setGoodsName("%1%");
        List<GoodsDetails> details = goodsDetailsMapper.selectAll(goodsDetails);
        for (GoodsDetails goods1 :
                details) {
            System.out.println(goods1);
        }
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/goodsDetails.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/goodsDetails.xml")
    public void testSelectById() {
        GoodsDetails details = goodsDetailsMapper.selectGoodsDetailsById(12);
        assertSame("成功", 12, details.getGoodsDetailsId());
        assertEquals("123", details.getGoodsName());
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/goodsDetails.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/goodsDetails.xml")
    public void testInsert() {
        GoodsDetails goodsDetails = new GoodsDetails(12, "222", "123", "2018-12-5"
                , 133.0, "1232", "231");
        int i = goodsDetailsMapper.insertGoodsDetails(goodsDetails);
        Assert.assertEquals(1, i);
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/goodsDetails.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/goodsDetails.xml")
    public void testUpdate() {
        GoodsDetails goodsDetails = new GoodsDetails(12, "222", "123", "2018-12-5"
                , 133.0, "1232", "231");
        goodsDetails.setGoodsDetailsId(12);
        int i = goodsDetailsMapper.updateGoodsDetails(goodsDetails);
        Assert.assertEquals(1, i);
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/goodsDetails.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/goodsDetails.xml")
    public void testDelete() {

        int i = goodsDetailsMapper.deleteGoodsDetailsById(12);
        Assert.assertEquals(1, i);
    }
}

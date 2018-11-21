package com.dream.shopping.brandserver.brandtest;

import com.dream.shopping.brandserver.mapper.BrandMapper;
import com.dream.shopping.facade.po.Brand;
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
 * Time: 14:23
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

public class BrandTest extends DBTestCase {

    @Resource
    private IDatabaseConnection connection;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private DataSource dataSource;

    @Resource
    private BrandMapper brandMapper;

    private String path;
    @Override
    protected IDataSet getDataSet() throws Exception {
        return connection.createDataSet();
    }

    @Before
    public void init() throws SQLException, DatabaseUnitException, IOException {
        brandMapper = sqlSessionFactory.openSession().getMapper(BrandMapper.class);
        path = new File("").getCanonicalPath();
        connection = new DatabaseConnection(dataSource.getConnection());
        backTable();
    }

    public void backTable() throws DataSetException, IOException {
        QueryDataSet queryDataSet = new QueryDataSet(connection);
        queryDataSet.addTable("brand", "select * from brand");
        FlatXmlDataSet.write(queryDataSet, new FileOutputStream(path + "/src/test/resources/sourceDBUnit/brand.xml"));
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/brand.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/brand.xml")
    public void testSelectAll(){
        Brand brand1 = new Brand("%卡%",null);
        List<Brand> brands = brandMapper.selectAll(brand1);
        for (Brand brand :
                brands) {
            System.out.println(brand);
        }
    }
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/brand.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/brand.xml")
    public void testSelectById() {
        Brand brand = brandMapper.selectBrandById(33);
        assertSame("成功",33,brand.getBrandId());
        assertEquals("卡特亚",brand.getBrandName());
    }
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/brand.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/brand.xml")
    public void testInsert() {
        Brand brand = new Brand("法拉利",null);
        int i = brandMapper.insertBrand(brand);
        Assert.assertEquals(1,i);
    }
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/brand.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/brand.xml")
    public void testUpdate() {
        Brand brand = new Brand("bao马","1123");
        brand.setBrandId(33);
        int i = brandMapper.updateBrand(brand);
        Assert.assertEquals(1,i);
    }
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/brand.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/brand.xml")
    public void testDelete() {

        int i = brandMapper.deleteBrandById(33);
        Assert.assertEquals(1,i);
    }
}






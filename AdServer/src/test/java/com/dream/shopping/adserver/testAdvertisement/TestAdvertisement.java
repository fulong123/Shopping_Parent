package com.dream.shopping.adserver.testAdvertisement;

import com.dream.shopping.adserver.mapper.AdvertisementMapper;
import com.dream.shopping.adserver.vo.AdvertisementVo;
import com.dream.shopping.adserver.vo.CustomerAdvertisement;
import com.dream.shopping.facade.po.Advertisement;
import com.dream.shopping.facade.po.User;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dbunit.DBTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


/**
 * 描述:广告Mapper层的测试
 * Created with IntelliJ IDEA.
 * User: cx
 * Date: 2018/11/20
 * Time: 16:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional(transactionManager = "transactionManager")
@Rollback
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        MockitoTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class TestAdvertisement extends DBTestCase {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private IDatabaseConnection connection;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AdvertisementMapper advertisementMapper;

    private String path;

    @Before
    public void init() throws Exception{
        advertisementMapper=sqlSessionFactory.openSession().getMapper(AdvertisementMapper.class);
        path=new File("").getCanonicalPath();
        connection=new DatabaseConnection(dataSource.getConnection());
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return null;
    }
    /**
     * 描述 测试通过ID查询广告
     * @author cx
     * @date 2018/11/20 21:06
     * @param []
     * @return void
     */
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/advertisement.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/advertisement.xml")
    public void testFindById(){
        Advertisement advertisement = advertisementMapper.selectById(22);
        System.out.println(advertisement.getAdvertisementId());
        assertSame("成功",22,advertisement.getAdvertisementId());
        assertEquals("21",advertisement.getAdvertisementType());
    }
    /**
     * 描述 测试添加广告
     * @author cx
     * @date 2018/11/20 21:07
     * @param []
     * @return void
     */
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/advertisement.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/advertisement.xml")
    public void testInsert(){
        Advertisement advertisement = new Advertisement("123", "123", 123);
        int i = advertisementMapper.insertAdvertisement(advertisement);
       assertEquals(1,i);
    }

    /**
     * 描述 测试删除广告
     * @author cx
     * @date 2018/11/20 21:07
     * @param []
     * @return void
     */
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/advertisement.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/advertisement.xml")
    public void testDelete(){
        int i = advertisementMapper.deleteById(22);
        assertEquals(1,i);
    }

    /**
     * 描述 测试万能查询
     * @author cx
     * @date 2018/11/21 11:05
     * @param []
     * @return void
     */
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/advertisement.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/advertisement.xml")
    public void testSelectAll(){
        Advertisement advertisement = new Advertisement();
        //advertisement.setAdvertisementId(22);
        advertisement.setAdvertisementType("21");
        List<Advertisement> advertisements = advertisementMapper.selectAll(advertisement);
        assertSame("成功",22,advertisements.get(0).getAdvertisementId());
    }

    /**
     * 描述 保存数据库数据
     * @author cx
     * @date 2018/11/20 21:08
     * @param []
     * @return void
     */
    @Test
    public void backTable() throws DataSetException, IOException {
        QueryDataSet queryDataSet = new QueryDataSet(connection);
        queryDataSet.addTable("advertisement", "select * from advertisement");
        FlatXmlDataSet.write(queryDataSet, new FileOutputStream(path + "/src/resources/sourceDBUnit/advertisement.xml"));
    }

}

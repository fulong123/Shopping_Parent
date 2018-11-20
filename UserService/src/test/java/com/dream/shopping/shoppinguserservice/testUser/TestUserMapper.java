package com.dream.shopping.shoppinguserservice.testUser;

import com.dream.shopping.facade.po.User;
import com.dream.shopping.shoppinguserservice.mapper.UserMapper;
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
import java.sql.SQLException;

/**
 * 描述:
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

public class TestUserMapper extends DBTestCase {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private IDatabaseConnection connection;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    private String path;

    @Before
    public void init() throws SQLException, DatabaseUnitException, IOException {
        userMapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        path = new File("").getCanonicalPath();
        connection = new DatabaseConnection(dataSource.getConnection());
        //connection = new DatabaseConnection(DBUtil.getConnection());
        //DatabaseOperation.CLEAN_INSERT.execute(connection,new FlatXmlDataSet(new InputSource(path + "/src/resources/insertDBUnit/user.xml")));
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/user.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/user.xml")
    public void testFindById(){
        User byId = userMapper.selectById(36);
        assertSame("成功",36,byId.getuId());
    }

//    @Test
//    public void testUpdateByPrimaryKeySelective(){
//        User user = new User(36,"嘻嘻","哈哈","123123","市长","135","1231",3);
//        Integer integer = userMapper.updateByPrimaryKeySelective(user);
//        assertSame(null,1,integer);
//    }
//
//    @Test
//    public void testInsertSelective(){
//        User user = new User(90,"嘻嘻","哈哈","123123","市长","135","1231",3);
//        Integer integer = userMapper.insertSelective(user);
//        assertSame(null,1,integer);
//    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return connection.createDataSet();
    }

    @Test
    public void backTable() throws DataSetException, IOException {
        QueryDataSet queryDataSet = new QueryDataSet(connection);
        queryDataSet.addTable("user", "select * from user");
        FlatXmlDataSet.write(queryDataSet, new FileOutputStream(path + "/src/resources/sourceDBUnit/user.xml"));
    }
}
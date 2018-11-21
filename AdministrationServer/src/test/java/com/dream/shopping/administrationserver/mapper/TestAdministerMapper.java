package com.dream.shopping.administrationserver.mapper;

import com.dream.shopping.facade.po.Administrator;
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
@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
        value = "classpath:insertDBUnit/admin.xml")
@DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
        value = "classpath:sourceDBUnit/admin.xml")
public class TestAdministerMapper extends DBTestCase {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private IDatabaseConnection connection;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdministerMapper administerMapper;

    private String path;

    @Before
    public void init() throws SQLException, DatabaseUnitException, IOException {
        administerMapper = sqlSessionFactory.openSession().getMapper(AdministerMapper.class);
        path = new File("").getCanonicalPath();
        connection = new DatabaseConnection(dataSource.getConnection());
        //connection = new DatabaseConnection(DBUtil.getConnection());
        //DatabaseOperation.CLEAN_INSERT.execute(connection,new FlatXmlDataSet(new InputSource(path + "/src/resources/insertDBUnit/admin.xml")));
    }

    @Test
    public void testSelectById(){
        Administrator byId = administerMapper.selectById(2);
        assertSame("成功",2,byId.getAdministratorId());
    }

    @Test
    public void testUpdateAdmin(){
        Administrator admin = new Administrator();
        admin.setAdministratorId(2);
        admin.setAdministratorName("嘻嘻嘻");
        Integer integer = administerMapper.updateAdmin(admin);
        assertSame(null,1,integer);
    }

    @Test
    public void testInsertAdmin(){
        Administrator admin = new Administrator();
        admin.setAdministratorId(1);
        admin.setAdministratorName("嘻嘻嘻");
        Integer integer = administerMapper.insertAdmin(admin);
        assertSame(null,1,integer);
    }

    @Test
    public void testDeleteAdminById(){
        Integer integer = administerMapper.deleteAdminById(3);
        assertSame(1,integer);
    }

    @Test
    public void testDeleteAll(){
        Integer integer = administerMapper.deleteAll();
        assertEquals(4,integer.intValue());
    }

    @Test
    public void testDeleteByBatch(){
        ArrayList<Administrator> list = new ArrayList<>();
        Administrator administrator = new Administrator();
        Administrator administrator1 = new Administrator();
        administrator.setAdministratorId(2);
        administrator1.setAdministratorId(3);
        list.add(administrator);
        list.add(administrator1);
        Integer integer = administerMapper.deleteByBatch(list);
        assertSame(2,integer);
    }

    @Test
    public void testSelectByAdmin(){
        Administrator admin = new Administrator();
        admin.setAdministratorName("水");
        List<Administrator> users = administerMapper.selectByAdmin(admin);
        System.out.println("1     " + users.size());
        for (Administrator admin1:users) {
            System.out.println(admin1);
        }
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return connection.createDataSet();
    }

//    @Test
//    public void backTable() throws DataSetException, IOException {
//        QueryDataSet queryDataSet = new QueryDataSet(connection);
//        queryDataSet.addTable("administrator", "select * from administrator");
//        FlatXmlDataSet.write(queryDataSet, new FileOutputStream(path + "/src/resources/sourceDBUnit/admin.xml"));
//    }
}
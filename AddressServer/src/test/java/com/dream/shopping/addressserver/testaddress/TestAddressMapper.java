package com.dream.shopping.addressserver.testaddress;

import com.dream.shopping.facade.po.Address;
import com.dream.shopping.addressserver.mapper.AddressMapper;
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
 * User: huiliao
 * Date: 2018/11/20
 * Time: 17:01
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

public class TestAddressMapper extends DBTestCase {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private IDatabaseConnection connection;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AddressMapper addressMapper;

    private String path;

    @Before
    public void init() throws SQLException, DatabaseUnitException, IOException {
        addressMapper = sqlSessionFactory.openSession().getMapper(AddressMapper.class);
        path = new File("").getCanonicalPath();
        connection = new DatabaseConnection(dataSource.getConnection());
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/address.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/address.xml")
    public void testFindById(){
        Address address = addressMapper.selectAddressById(22);
        assertSame("成功",22,address.getAddressId());
    }


    @Override
    protected IDataSet getDataSet() throws Exception {
        return connection.createDataSet();
    }

    @Test
    public void backTable() throws DataSetException, IOException {
        QueryDataSet queryDataSet = new QueryDataSet(connection);
        queryDataSet.addTable("address", "select * from address");
        FlatXmlDataSet.write(queryDataSet, new FileOutputStream(path + "/src/test/resources/sourceDBUnit/address.xml"));
    }
}

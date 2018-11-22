package com.dream.shopping.orderserver.testOrder;

import com.dream.shopping.facade.po.OrderDetails;
import com.dream.shopping.orderserver.mapper.Goods_OrderMapper;
import com.dream.shopping.orderserver.mapper.OrderDetailsMapper;
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

public class TestOrderMapper extends DBTestCase {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private IDatabaseConnection connection;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Goods_OrderMapper goods_orderMapper;
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    private String path;

    @Before
    public void init() throws SQLException, DatabaseUnitException, IOException {
        goods_orderMapper = sqlSessionFactory.openSession().getMapper(Goods_OrderMapper.class);
        path = new File("").getCanonicalPath();
        connection = new DatabaseConnection(dataSource.getConnection());
        //connection = new DatabaseConnection(DBUtil.getConnection());
        //DatabaseOperation.CLEAN_INSERT.execute(connection,new FlatXmlDataSet(new InputSource(path + "/src/resources/insertDBUnit/user.xml")));
    }

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:insertDBUnit/order_details.xml")
    @DatabaseTearDown(type = DatabaseOperation.CLEAN_INSERT,
            value = "classpath:sourceDBUnit/order_details.xml")
    public void testFindById(){
        List<OrderDetails> orderDetails = orderDetailsMapper.selectOrderDetailsByOrderId(1);
        assertSame("成功",1,orderDetails.size());
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
        queryDataSet.addTable("order_details", "select * from order_details");
        FlatXmlDataSet.write(queryDataSet, new FileOutputStream(path + "/src/resources/sourceDBUnit/order_details.xml"));
    }
}
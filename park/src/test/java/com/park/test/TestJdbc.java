package com.park.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试数据源
 * 
 * @author JunanW
 *
 */
@ContextConfiguration(locations = { "classpath:applicationContext-dao.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJdbc {
	@Autowired
	private DataSource dataSource;

	@Test
	public void testConnectJdbc() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println(dataSource);
		System.out.println(connection);
	}

}

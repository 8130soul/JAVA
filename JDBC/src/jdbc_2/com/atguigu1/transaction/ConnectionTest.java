package jdbc_2.com.atguigu1.transaction;

import java.sql.Connection;

import jdbc_2.com.atguigu1.util.JDBCUtils;
import org.junit.Test;


public class ConnectionTest {
	
	@Test
	public void testGetConnection() throws Exception{
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn);
	}
}

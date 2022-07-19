package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //jdbc数据库连接
    public static Connection getConnection() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    //关闭资源
    public static void closeResource(Connection connection, Statement ps){
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (connection!=null)
                 connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet rs){
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

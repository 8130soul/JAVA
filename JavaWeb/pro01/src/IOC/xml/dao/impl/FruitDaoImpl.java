package IOC.xml.dao.impl;

import JDBC.JDBCUtils;
import IOC.xml.dao.FruitDao;
import IOC.xml.pojo.Fruit;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    //查询库存列表
    @Override
    public <T> List<T> getFruitList(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData data = rs.getMetaData();
            int columnCount = data.getColumnCount();

            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columValue = rs.getObject(i + 1);
                    String label = data.getColumnLabel(i + 1);
                    Field field = Fruit.class.getDeclaredField(label);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    @Override
    public void addFruit(Connection conn,String sql,Fruit fruit) {
        updateFruit(conn,sql,fruit.getFcount(),fruit.getFid());
    }

    @Override
    public int updateFruit(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            // 1.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            // 2.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);// 小心参数声明错误！！
            }
            // 3.执行
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.资源的关闭
            JDBCUtils.closeResource(null, ps);
        }
        return 0;
    }

    @Override
    public Fruit getFruitByFname(String fname) {
        return null;
    }

    @Override
    public void delFruit(String fname) {

    }
}

package IOC.xml.dao;

import JDBC.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T> {
    private Class<T> clazz = null;

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) genericSuperclass;

        Type[] actualTypeArguments = type.getActualTypeArguments();
        clazz = (Class<T>) actualTypeArguments[0];
    }

    public int update(Connection conn, String sql, Object... args) {
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pst.setObject(i + 1, args[i]);
            }
            return pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, pst);
        }
        return 0;
    }

    public List<T> GetForList(Connection conn, String sql, Object... args) {
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pst.setObject(i + 1, args[i]);
            }

            resultSet = pst.executeQuery();
            ResultSetMetaData data = resultSet.getMetaData();
            int columnCount = data.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            if (resultSet.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);
                    String columnLabel = data.getColumnLabel(i + 1);

                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, columnValue);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, pst, resultSet);
        }
        return null;
    }

    public <E> E getValue(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                return (E) rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    public T getInstance(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object colValue = rs.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, colValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }
}

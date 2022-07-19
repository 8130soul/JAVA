package IOC.xml.dao;

import IOC.xml.pojo.Fruit;

import java.sql.Connection;
import java.util.List;

public interface FruitDao {
    //查询库存列表
    <T>List<T> getFruitList(Class<T> clazz,String sql,Object...args);

    //新增库存
    void addFruit(Connection conn,String sql,Fruit fruit);

    //修改库存
    int updateFruit(Connection conn,String sql, Object... args);

    //根据名称查询特定库存
    Fruit getFruitByFname(String fname);

    //删除特定库存记录
    void delFruit(String fname);
}

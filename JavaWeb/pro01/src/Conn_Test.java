import JDBC.JDBCUtils;
import IOC.xml.dao.impl.FruitDaoImpl;
import org.junit.Test;
import IOC.xml.pojo.Fruit;

import java.sql.Connection;
import java.util.List;

public class Conn_Test {
    private static FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Test
    public  void testQuery() {
        String sql = "select fid,fname,price,fcount,remark from t_fruit where fid = ?";
        List<Fruit> fruitList = fruitDao.getFruitList(Fruit.class,sql,1);
        fruitList.forEach(System.out::println);
    }

    @Test
    public void testInsert() throws Exception {
        String sql = "insert into t_fruit values(?,?,?,?,?)";
        Fruit fruit = new Fruit(0,"盘古22",222,6,"好评22");
        Connection connection = JDBCUtils.getConnection();
        fruitDao.updateFruit(connection,sql,fruit.getFid(),fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark());
    }

    @Test
    public void testUpdate() throws Exception {
        String sql = "update t_fruit set fcount = ? where fid = ?";
        Fruit fruit = new Fruit(9,656);
        Connection connection = JDBCUtils.getConnection();
        fruitDao.addFruit(connection,sql,fruit);
    }
}

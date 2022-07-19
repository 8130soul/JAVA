package JDBCTemplate.dao;

import JDBCTemplate.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    //注入jdbctemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql = "insert into user values(?,?,?,?,?)";
        jdbcTemplate.update(sql,0,user.getName(),user.getPassword(),user.getAddress(),user.getPhone());
    }

    @Override
    public void delete(User user) {
        String sql = "delete from user where id = ?";
        Object[] args = {user.getId()};
        jdbcTemplate.update(sql,args);
    }

    @Override
    public void deleteByName(User user) {
        String sql = "delete from user where name = ?";
        Object[] args = {user.getName()};
        jdbcTemplate.update(sql,args);
    }

    @Override
    public List queryById(User user) {
        String sql = "select * from user where id = ?";
        Object[] args = {user.getId()};
        ArrayList arrayList = (ArrayList) jdbcTemplate.queryForList(sql,args);
        return  arrayList;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?,password = ?,address = ?,phone = ? where id = ?";
        Object[] args = {user.getName(),user.getPassword(),user.getAddress(),user.getPhone(),user.getId()};
        jdbcTemplate.update(sql,args);
    }
}

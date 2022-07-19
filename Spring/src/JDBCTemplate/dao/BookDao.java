package JDBCTemplate.dao;

import JDBCTemplate.pojo.User;

import java.util.ArrayList;
import java.util.List;

public interface BookDao {
    void add(User user);

    void delete(User user);

    void deleteByName(User user);

    List queryById(User user);

    void update(User user);
}

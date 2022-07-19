package JDBCTemplate.service;

import JDBCTemplate.dao.BookDao;
import JDBCTemplate.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void addUser(User user){
        bookDao.add(user);
    }

    public void deleteUser(User user){
        bookDao.delete(user);
    }

    public void deleteByName(User user){
        bookDao.deleteByName(user);
    }

    public ArrayList queryById(User user){
        return (ArrayList) bookDao.queryById(user);
    }

    public void update(User user){
        bookDao.update(user);
    }
}

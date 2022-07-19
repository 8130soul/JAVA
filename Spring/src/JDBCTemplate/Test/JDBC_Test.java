package JDBCTemplate.Test;

import JDBCTemplate.pojo.User;
import JDBCTemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBC_Test {
    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Druid.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        User user = new User();
        user.setName("张三");
        user.setPassword("123456");
        user.setAddress("湖南长沙");
        user.setPhone("1122334455");
        bookService.addUser(user);
    }

    @Test
    public void testDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Druid.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        User user = new User();
        user.setId(8);
        bookService.deleteUser(user);
    }

    @Test
    public void testDeleteByName(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Druid.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        User user = new User();
        user.setName("张三");
        bookService.deleteByName(user);
    }

    @Test
    public void testQueryById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Druid.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        User user = new User();
        user.setId(1);
        System.out.println(bookService.queryById(user));
    }

    @Test
    public void testUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Druid.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        User user = new User();
        user.setId(2);
        user.setName("张三");
        user.setPassword("123456");
        user.setAddress("湖南长沙");
        user.setPhone("1122334455");
        bookService.update(user);
    }

    //批量操作
    //jdbcTemplate.batchUpdate();
}

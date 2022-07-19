package IOC.xml.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import IOC.xml.pojo.Book;
import IOC.xml.pojo.Student;

public class Test_list {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Context5.xml");
        Student student = context.getBean("student", Student.class);
        student.test();
    }

    @Test
    public void test_book(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Context6.xml");
        Book book = context.getBean("bookList", Book.class);
        Book book2 = context.getBean("bookList", Book.class);
//        book.IOC.xml.test();
        System.out.println(book);
        System.out.println(book2);
    }
}

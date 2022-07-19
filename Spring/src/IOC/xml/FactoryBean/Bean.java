package IOC.xml.FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import IOC.xml.pojo.Student;

public class Bean implements FactoryBean<Student> {
    @Override
    public Student getObject() throws Exception {
        Student student = new Student();
        student.setCourses(new String[]{"不想学", "还行"});
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring_Test {

    @Test
    public void TestAnimal() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Animal animal = applicationContext.getBean("Animal", Animal.class);
        animal.test();
    }

    @Test
    public void TestDog() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Dog dog = applicationContext.getBean("Dog", Dog.class);
        dog.test();
    }
}

package IOC.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//完全注解开发
@Configuration
@ComponentScan(basePackages = {"IOC.annotation"})
public class Config {

}

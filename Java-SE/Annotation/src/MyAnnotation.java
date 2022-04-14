import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Inherited
//jdk8中使用重复注解     编译时Retention和Target需一致，运行时Inherited需一致  即保证一致
@Repeatable(MyAnnotations.class)

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
   String values() default "hello";
}

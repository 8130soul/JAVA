package Collection.Set;

import org.junit.Test;

import java.util.*;

public class Set_Test {

    @Test
    public void test(){
        Set set = new HashSet();
        set.add(123);
        set.add("123");
        set.add(new String("Tom"));
        set.add(false);
        set.add(new User("Tom",20));
        set.add(new User("Tom",20));

        Iterator integer = set.iterator();
        while (integer.hasNext()){
            System.out.println(integer.next());
        }
    }

    /*LinkedHashSet的使用
    LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据。
    优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet*/
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add("123");
        set.add(new String("Tom"));
        set.add(false);
        set.add(new User("Tom",20));
        set.add(new User("Tom",20));

        Iterator integer = set.iterator();
        while (integer.hasNext()){
            System.out.println(integer.next());
        }
    }

}

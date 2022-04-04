package generic;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 *  * 1.jdk 5.0新增的特性
 *  *
 *  * 2.在集合中使用泛型：
 *  *  总结：
 *  *  ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *  *  ② 在实例化集合类时，可以指明具体的泛型类型
 *  *  ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
 *  *    比如：add(E e)  --->实例化以后：add(Integer e)
 *  *  ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *  *  ⑤ 如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *  *
 *  * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见Generic_Test2.java
 */
public class Generic_Test {
    //在集合中使用泛型之前的情况：
    @Test
    public void test() {
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//        list.add("Tom");

        for (Object score : list) {
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(78);
        arrayList.add(87);
        arrayList.add(99);
        arrayList.add(65);
        //编译时，就会进行类型检查，保证数据的安全
        /*arrayList.add("Tom");*/  //添加失败

        //方式一
        /*for (Integer integer:arrayList){
            int score = integer;
            System.out.println(score);
        }*/

        //方式二
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        /*HashMap<String,Integer> map = new HashMap<String, Integer>();*/
        //jdk7新特性：类型推断
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

        /*map.put(123,"abc");*/  //编译不通过

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            //方式一
            /*System.out.println(iterator.next());*/

            //方式二
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            int value = next.getValue();
            System.out.println(key+"-->"+value);
        }
    }
}

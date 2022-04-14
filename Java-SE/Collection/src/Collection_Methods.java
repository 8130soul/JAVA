import org.junit.Test;
import pojo.Pojo;

import java.util.*;

/**
 *     Collection接口中的方法的使用
 *     结论：
 *          向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 */
public class Collection_Methods {

    @Test
    public void test(){
        Collection collection = new ArrayList();

        //1.add(object o) 将元素o添加到集合中
        collection.add("123");
        collection.add(123);  //自动装箱
        collection.add(new Date().toString());

        //2.size():获取添加的元素个数
        System.out.println(collection.size());

        //3.addAll():将集合collection的元素全部添加到集合collection1中
        Collection collection1 = new ArrayList();
        collection.add("aa");
        collection.add("bb");
        collection1.addAll(collection);
        System.out.println(collection1.size());
        System.out.println(collection1);

        //4.clear():清空集合元素
        collection.clear();
        System.out.println(collection.toString());
        System.out.println(collection1.toString());

        //5.isEmpty():判断当前集合是否为空
        System.out.println(collection1.isEmpty());
    }

    @Test
    public void test1() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add("123");
        collection.add(new String("Tome"));
        collection.add(new Pojo("Jack",55));

        //6.contains(object o):判断当前集合中是否包含对象o
        boolean flag = collection.contains(123);
        System.out.println(flag);
        System.out.println(collection.contains(new String("Tome")));

        //重写equals方法前
        /*System.out.println(collection.contains(new pojo.Pojo("Jack",55)));//false */

        //重写equals方法后   具体还是看equals方法的实现  比较的是地址值还是具体内容
        System.out.println(collection.contains(new Pojo("Jack",55)));//false -->true

        /*pojo.Pojo pojo = new pojo.Pojo("Jack", 20);
        pojo.Pojo pojo2 = new pojo.Pojo("Jack", 20);
        System.out.println(System.identityHashCode(pojo)); //1645995473
        System.out.println(System.identityHashCode(pojo2));*/  //1463801669

        //7.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
        Collection coll1 = Arrays.asList(123,4567);
        System.out.println(collection.containsAll(coll1));
    }

    @Test
    public void test2() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(423);
        collection.add("123");
        collection.add(new String("Tome"));
        collection.add(new Pojo("Jack",55));

        //8.remove(Object obj):从当前集合中移除obj元素。
        collection.remove(1234); //false
        System.out.println(collection);

        collection.remove(new Pojo("Jack",55));
        System.out.println(collection);

        //9. removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
        Collection coll1 = Arrays.asList(123,456);
        collection.removeAll(coll1);
        System.out.println(collection);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Pojo("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //10.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //11.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(123);
        coll1.add(new Pojo("Jerry",20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Pojo("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //12.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //13.集合 --->数组：toArray()
        Object[] arr = coll.toArray();
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }

        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2

        //14.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }
}

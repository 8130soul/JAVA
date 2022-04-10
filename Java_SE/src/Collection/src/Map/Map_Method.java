package Map;

import org.junit.Test;

import java.util.*;

/**
 *  总结：常用方法：
 *   添加：put(Object key,Object value)
 *   删除：remove(Object key)
 *   修改：put(Object key,Object value)
 *   查询：get(Object key)
 *   长度：size()
 *   遍历：keySet() / values() / entrySet()
 */

public class Map_Method {
    /**
     *  添加、删除、修改操作：
     *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     *  void putAll(Map m):将m中的所有key-value对存放到当前map中
     *  Object remove(Object key)：移除指定key的key-value对，并返回value
     *  void clear()：清空当前map中的所有数据
     */
    @Test
    public void test() {
        Map map = new HashMap();
        //put()方法
        map.put(1,22);
        map.put(1,20);
        map.put(2,"Tom");
        map.put(3,false);
        System.out.println(map);

        //putAll()方法
        Map map1 = new HashMap();
        map1.putAll(map);
        map1.put("Jack",123);
        System.out.println(map1);

        //remove()方法
        Object remove = map1.remove(1);
        System.out.println(remove);
        System.out.println(map1);

        //clear()方法
        map1.clear();  ////与map = null操作不同
        System.out.println(map1.size());//0
        System.out.println(map1);  //{}
    }

    /**
     * 元素查询的操作：
     *  Object get(Object key)：获取指定key对应的value
     *  boolean containsKey(Object key)：是否包含指定的key
     *  boolean containsValue(Object value)：是否包含指定的value
     *  int size()：返回map中key-value对的个数
     *  boolean isEmpty()：判断当前map是否为空
     *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test2() {
        Map map = new HashMap();
        map.put(1,22);
        map.put(1,20);
        map.put(2,"Tom");
        map.put(3,false);

        //Object get(Object key)
        System.out.println(map.get(3));

        //boolean containsKey(Object key)
        System.out.println(map.containsKey(1));

        //boolean containsValue(Object value)
        System.out.println(map.containsValue(22));

        //int size()
        System.out.println(map.size());

        //boolean isEmpty()
        map.clear();    //只清除数据，不清除对象
        System.out.println(map.isEmpty()); //true

        //boolean equals(Object obj)
        Map map1 = new HashMap();
        map1.putAll(map);
        System.out.println(map1.equals(map));  //true
        map1.put("T",11);
        System.out.println(map1.equals(map)); //不一致  false
    }

    /**
     *元视图操作的方法：
     *  Set keySet()：返回所有key构成的Set集合
     *  Collection values()：返回所有value构成的Collection集合
     *  Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test3() {
        Map map = new HashMap();
        map.put(1,22);
        map.put(1,20);
        map.put(2,"Tom");
        map.put(3,false);

        //keySet()：返回所有key构成的Set集合
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        //Collection values()：返回所有value构成的Collection集合
        Collection values = map.values();
        for (Object o:values) {
            System.out.println(o);
        }

        System.out.println();

        //Set entrySet()：返回所有key-value对构成的Set集合
        //方式一
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey()+"-->"+entry.getValue());
        }

        System.out.println();

        //方式二
        Set set2 = map.keySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()){
            Object keySet = iterator2.next();
            Object value = map.get(keySet);
            System.out.println(keySet+"==="+value);
        }
    }
}

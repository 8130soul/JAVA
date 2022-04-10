package Map;

import Collection.Set.User;
import org.junit.Test;

import java.util.*;

/**
 *  向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
 *  因为要按照key进行排序：自然排序 、定制排序
 */
public class TreeMap_Test {
    //自然排序
    @Test
    public void test(){
        TreeMap map = new TreeMap();
        User u2 = new User("Ferry",32);
        User u1 = new User("Bom",23);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        //使用entrySet方法遍历
        //按照姓名从大到小排列,年龄从小到大排列
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }

    //定制排序
    @Test
    public void test2(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    return Integer.compare(((User) o1).getAge(),((User) o2).getAge());
                }else {
                    throw new RuntimeException("输入的数据类型不一致");
                }
            }
        };
        TreeMap map = new TreeMap(comparator);
        User u2 = new User("Ferry",32);
        User u1 = new User("Bom",23);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}

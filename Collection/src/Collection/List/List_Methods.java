package Collection.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 5.List接口中的常用方法
 *        void add(int index,Object ele):在index位置插入ele元素
 *        boolean addAll(int index,Collection eles):从index位置开始将eles中的所有元素添加进来
 *        Object get(int index):获取指定index位置的元素
 *        int indexOf(Object obj):返回obj在集合中首次出现的位置
 *        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 *        Object remove(int index):移除指定index位置的元素，并返回此元素
 *        Object set(int index,Object ele):设置指定index位置的元素为ele
 *        List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集合
 *        总结：常用方法
 *        增：add(Object obj)
 *        删：remove(int index)/remove(Object obj)
 *        改：set(int index,Object ele)
 *        查：get(int index)
 *        插：add(int index,Object ele)
 *        长度：size()
 *        遍历：① Iterator迭代器方式
 *             ② 增强for循环
 *             ③ 普通的循环
 */
public class List_Methods {
    @Test
    public void test() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add("123");
        arrayList.add(new String("Tom"));
        arrayList.add(false);
        System.out.println(arrayList);

        //1.void add(int index,Object ele):在index位置插入ele元素
        arrayList.add(1,"hello");
        System.out.println(arrayList);

        //2.boolean addAll(int index,Collection eles):从index位置开始将eles中的所有元素添加进来
        List list = Arrays.asList(1,2,3);
        arrayList.addAll(list);
        System.out.println(arrayList.size());//8
        System.out.println(arrayList);
        //3.Object get(int index):获取指定index位置的元素
        System.out.println(arrayList.get(0));

        //4.int indexOf(Object obj):返回obj在集合中首次出现的位置;如果不存在，返回-1
        System.out.println(arrayList.indexOf(123));

        //5.int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置;如果不存在，返回-1
        System.out.println(arrayList.lastIndexOf("123"));

        //6.Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = arrayList.remove(0);
        System.out.println(obj);
        System.out.println(arrayList);

        //7.Object set(int index, Object ele):设置指定index位置的元素为ele
        arrayList.set(1,"CC");
        System.out.println(arrayList);

        //8.List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开区间的子集合
        List subList = arrayList.subList(2, 4);
        System.out.println(subList);
        System.out.println(arrayList);
    }

    @Test
    public void test3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(new String("Tom"));
        arrayList.add(false);

        //方式一：Iterator迭代器方式
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("***************");

        //方式二：增强for循环
        for (Object s:arrayList) {
            System.out.println(s);
        }

        System.out.println("***************");

        //方式三：普通for循环
        for(int i = 0;i < arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}


















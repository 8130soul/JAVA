package Map;

import org.junit.Test;

import java.util.*;

/**
 *  Collections：操作Collection、Map的工具类
 *
 *  面试题：Collection 和 Collections的区别？
 *
 *
 * reverse(List)：反转 List 中元素的顺序
 * shuffle(List)：对 List 集合元素进行随机排序
 * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 * Object min(Collection)
 * Object min(Collection，Comparator)
 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * void copy(List dest,List src)：将src中的内容复制到dest中
 * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
 */
public class Collections_Test {
    @Test
    public void test(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(23);
        arrayList.add(23);
        arrayList.add(23);
        arrayList.add(3);
        arrayList.add(-123);

        System.out.println(arrayList);

        //reverse(List)：反转 List 中元素的顺序
        /*Collections.reverse(arrayList);
        System.out.println(arrayList);*/

        //shuffle(List)：对 List 集合元素进行随机排序
        /*Collections.shuffle(arrayList);
        System.out.println(arrayList);*/

        //sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        /*Collections.sort(arrayList);
        System.out.println(arrayList);*/

        //swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        /*Collections.swap(arrayList,0,2);
        System.out.println(arrayList);*/

        //int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        System.out.println(Collections.frequency(arrayList,23));

        //void copy(List dest,List src)：将src中的内容复制到dest中
        //报异常java.lang.IndexOutOfBoundsException: Source does not fit in dest
        /*List dest = new ArrayList();
        Collections.copy(dest,arrayList);*/

        //确定新集合的长度后再复制   Arrays.asList(new Object[arrayList.size()])
        List dest = Arrays.asList(new Object[arrayList.size()]);
        Collections.copy(dest,arrayList);
        System.out.println(dest);
    }

    /**
     *
     *  Collections 类中提供了多个 synchronizedXxx() 方法，
     *  该方法可使将指定集合包装成线程同步的集合，从而可以解决
     *  多线程并发访问集合时的线程安全问题
     */
    @Test
    public void test2(){
        //返回的list即为线程安全的List
        ArrayList arrayList = new ArrayList();
        List list = Collections.synchronizedList(arrayList);
    }
}

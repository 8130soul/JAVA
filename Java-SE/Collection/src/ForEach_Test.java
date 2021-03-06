import org.junit.Test;
import IOC.xml.pojo.Pojo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合、数组
 */
public class ForEach_Test {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Pojo("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合元素的类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器。
        for (Object s:coll) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() {
        int[] arr =new int[]{1,2,3,4,5};
        //for(数组元素的类型 局部变量 : 数组对象)
        for (int i:arr) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        String[] arr = new String[]{"MM","MM","MM"};

//        //方式一：普通for赋值
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        for(String s : arr){
            s = "GG";
        }

        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

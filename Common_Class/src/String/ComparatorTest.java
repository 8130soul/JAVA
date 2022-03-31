package String;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  Comparator接口的使用：定制排序
 *     1.背景：
 *     当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
 *     或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
 *     那么可以考虑使用 Comparator 的对象来排序
 *     2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
 *     如果方法返回正整数，则表示o1大于o2；
 *     如果返回0，表示相等；
 *     返回负整数，表示o1小于o2。
 */
public class ComparatorTest {
    @Test
    public void test(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                if (o1 instanceof String && o2 instanceof String) {
                    return o1.compareTo(o2);
//                }
//                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("huaweiMouse",224);
        arr[5] = new Goods("microsoftMouse",43);

        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}

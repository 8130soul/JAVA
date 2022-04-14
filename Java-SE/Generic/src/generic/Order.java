package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 * @param <T>
 */
public class Order <T>{
    private String OrderName;
    private int OrderAge;

    T OrderT;

    public Order() {
        //编译不通过
        /*T[] arr = new T[10];*/
        //编译通过
        T[] arr = (T[]) new Object[10];
    }

    public Order(String orderName, int orderAge, T orderT) {
        OrderName = orderName;
        OrderAge = orderAge;
        OrderT = orderT;
    }

    public T getOrderT() {
        return OrderT;
    }

    public void setOrderT(T orderT) {
        OrderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderName='" + OrderName + '\'' +
                ", OrderAge=" + OrderAge +
                ", OrderT=" + OrderT +
                '}';
    }
    //静态方法中不能使用类的泛型
    /*public static void show(T orderT){
        System.out.println(orderT);
    }*/

    //编译不通过
    /*public void show(){
        try {

        }catch (T t){

        }
    }*/

    /*泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    换句话说，泛型方法所属的类是不是泛型类都没有关系。
    泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。*/
    public static <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;
    }
}

package String;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * Calendar日历类(抽象类）的使用
 */
public class Calendar {
    @Test
    public void test() {
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        java.util.Calendar calendar = java.util.Calendar.getInstance();

        //2.常用方法
        //get()
        int days = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(java.util.Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        calendar.set(java.util.Calendar.DAY_OF_MONTH,22);
        days = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(java.util.Calendar.DAY_OF_MONTH,1);
        days = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}

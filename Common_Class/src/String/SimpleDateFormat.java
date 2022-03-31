package String;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
 *
 *     1.两个操作：
 *     1.1 格式化：日期 --->字符串
 *     1.2 解析：格式化的逆过程，字符串 ---> 日期
 *
 *     2.SimpleDateFormat的实例化
 */

public class SimpleDateFormat {

    @Test
    public void test() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat();

        //格式化：日期 --->字符串
        Date date = new Date();
        System.out.println(date);

        String format = simpleDateFormat.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "3/31/22, 6:55 PM";
        Date date1 = simpleDateFormat.parse(str);
        System.out.println(date1);

        //指定方式
        java.text.SimpleDateFormat simpleDateFormat1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = simpleDateFormat1.format(date);
        System.out.println(format1);
        //解析
        Date date2 = simpleDateFormat1.parse(format1);
        System.out.println(date2);

        //转换为sql.date
        java.sql.Date date3 = new java.sql.Date(date2.getTime());
        System.out.println(date3);
    }
}

package String;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * int length():返回字符串的长度 return value.length
 * char charAt(int index):返回某索引处的字符
 * boolean isEmpty():判断是否为空字符串
 * String toLowerCase():将字符转化成小写
 * String toUpperCase():将字符转化成写
 * String trim():返回字符串的副本,忽略前导空白和尾部空白
 * boolean equals(Object obj):比较字符串的内容是否相同
 * boolean equalsIgnoreCase(String anotherString):忽略大小写
 * String concat(String str):将指定字符串连接到此字符串的结尾,相当于‘+’
 * int compareTo(String anotherString):比较两个字符串的大小  等于：0  小于:负数  大于:正数
 * String substring(int beginIndex):返回一个新的字符串,它是此字符串的beginIndex开始截取
 * String substring(int beginIndex,int endIndex):返回一个新的字符串,beginIndex开始,endIndex结束
 *
 * boolean endWith(String suffix):测试此字符串是否以指定的后缀结尾
 * boolean startWith(String prefix):测试此字符串是否以指定的前缀开始
 * boolean startWith(String prefix,int toffset):测试此字符串从指定索引开始的子字符串是否以指定前缀开始
 */

public class StringMethods {
    @Test
    public void test1() {
        String str1 = "Dasdada";
        System.out.println(str1.length());
        System.out.println(str1.charAt(2));
        System.out.println(str1.isEmpty());
        System.out.println(str1.toLowerCase());
        System.out.println(str1.toUpperCase());

        String str2 = "   ab  sd  asd    ";
        String str3 = str2.trim();
        System.out.println("---"+str2+"---");
        System.out.println("---"+str3+"---");

    }

    @Test
    public void test2(){
        String str1 = "Helloworld";
        String str2 = "helloworld";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        String str3 = "abc";
        String str4 = str3.concat("def");
        System.out.println(str4);

        String str5 = "abc";
        String str6 = new String("abe");
        System.out.println(str5.compareTo(str6));

        System.out.println(str1.substring(2));
        System.out.println(str2.substring(2, 4));
    }

    /**
     * String 与 char[]之间的转换
     * String --> char[]
     * char[] --> String  调用String的构造器
     */
    @Test
    public void test3(){
        String str1 = "abc";
        char [] chars = str1.toCharArray();
        for (char chars1:chars) {
            System.out.println(chars);
        }

        char [] chars1 = new char[]{'1','2','3'};
        String str2 = new String(chars1);
        System.out.println(str2);
    }

    /**
     * String 与 byte[]之间的转换
     * String --> byte[]    调用String的getBytes()
     * byte[] --> String
     */
    @Test
    public void test4() {
        String str1 = "abc";
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));

        String str2 = new String(bytes);
        System.out.println(str2);
    }
}

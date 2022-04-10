package Buffered;

import org.junit.Test;

import java.io.*;

public class BufferedReader_Writer_Test {
    //使用BufferedReader和BufferedWriter实现文本文件的复制
    @Test
    public void test()  {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("84646.txt")));
            bw = new BufferedWriter(new FileWriter(new File("网游.txt")));

            char[] chars = new char[1024];
            int len;
            while ((len=br.read(chars))!=-1){
                //方式一
                /*bw.write(chars,0,len);*/

                //方式二：使用String
                String data;
                while ((data=br.readLine())!=null){
                    //方法一
                    /*bw.write(data + "\n");*///data中不包含换行符

                    //方法二
                    bw.write(data);
                    bw.newLine();//提供换行的操作
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

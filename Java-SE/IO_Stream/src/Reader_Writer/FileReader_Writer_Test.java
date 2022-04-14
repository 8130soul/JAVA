package Reader_Writer;

import org.junit.Test;

import java.io.*;

public class FileReader_Writer_Test {
    //测试文件的读入写出
    //声明:不能使用字符流来处理图片等字节数据
    @Test
    public void test() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File file = new File("hello.txt");
            File file2 = new File("hi.txt");

            //2.创建输入流和输出流的对象
            fr = new FileReader(file);
            /*FileWriter fw = new FileWriter(file);*/
            //不覆盖原文件  追加文本内容
            fw = new FileWriter(file2,true);

            //3.数据的读入和写出操作
            char[] chars = new char[5];

            int len;
            while ((len=fr.read(chars))!=-1){
                fw.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if (fr!=null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw!=null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

package Reader_Writer;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Test {

    /**
     * 说明点：
     * 1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
     * 2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
     * 3. 读入的文件一定要存在，否则就会报FileNotFoundException。
     */
    @Test
    public void test() {
        FileReader fileReader = null;
        try {
            //1.实例化File类的对象，指明要操作的对象
            File file = new File("hello.txt");
            //2.提供具体的流
            fileReader = new FileReader(file);

            //3.数据读入
            //read():返回读入的一个字符，如果达到文件末尾，返回-1.
            /*int data = fileReader.read();
            while (data!=-1){
                System.out.print((char)data);
                data=fileReader.read();
            }*/

            //优化
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            /*try {
                if (fileReader!=null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

            //或
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //对read()方法升级，使用read()方法的重载方法
    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.FileReader类的实例化
            fileReader = new FileReader(file);

            //3.数据的读入
            char[] chars = new char[4];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                //方式一
                //错误的写法    注意  chars数组的长度
                /*for (int i=0;i<chars.length;i++){
                    System.out.print(chars[i]);
                }*/
                //正确的写法
                /*for (int i=0;i<len;i++){
                    System.out.print(chars[i]);
                }*/

                //方式二
                //错误的写法
                /*String str = new String(chars);
                System.out.println(str);*/
                //正确的写法
                String string = new String(chars,0,len);
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                //4.关闭流
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

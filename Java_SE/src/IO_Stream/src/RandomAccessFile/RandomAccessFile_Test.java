package RandomAccessFile;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 *  * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 *  * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *  *
 *  * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 *  *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 *  *
 *  * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 */
public class RandomAccessFile_Test {
    @Test
    public void test()  {
        RandomAccessFile raf = null;
        RandomAccessFile raf2 = null;
        try {
            raf = new RandomAccessFile(new File("1.jpg"),"r");
            raf2 = new RandomAccessFile(new File("13.jpg"),"rw");

            byte[]bytes=new byte[20];
            int len;
            while ((len=raf.read(bytes))!=-1){
                raf2.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf!=null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf!=null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("xyz".getBytes());//

        raf1.close();
    }

    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);//将指针调到角标为3的位置
        byte[]bytes = new byte[20];
        StringBuilder stringBuilder = new StringBuilder((int) new File("hello.txt").length());
        int len;
        while ((len=raf1.read(bytes))!=-1){
            stringBuilder.append(new String(bytes,0,len));
        }
        System.out.println(stringBuilder);
        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("6666".getBytes());

        //将StringBuilder中的数据写入到文件中
        raf1.write(stringBuilder.toString().getBytes());

        raf1.close();

        //思考：将StringBuilder替换为ByteArrayOutputStream
    }
}

package Buffered;

import org.junit.Test;

import java.io.*;

/**
 *  处理流之一：缓冲流的使用
 *
 *   1.缓冲流：
 *   BufferedInputStream
 *   BufferedOutputStream
 *   BufferedReader
 *   BufferedWriter
 *
 *   2.作用：提供流的读取、写入的速度
 *     提高读写速度的原因：内部提供了一个缓冲区
 *
 *   3. 处理流，就是“套接”在已有的流的基础上。
 */
public class BufferedInput_OutputStream_Test {
    //实现非文本文件的复制
    @Test
    public void test()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("1.jpg");
            File destFile = new File("12.jpg");
            //2.造流
            //2.1 造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取、写入
            byte[] bytes = new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
                //刷新缓冲区
                /*bos.flush();*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if (bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭
            /*fos.close();
            fis.close();*/
        }
    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileWithBuffered(){
        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\ASUS\\Desktop\\筷子兄弟 - 父亲.mp3";
        String destPath = "C:\\Users\\ASUS\\Desktop\\筷子兄弟 - 父亲2.mp3";

        copyFileWithBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//90  -  35
    }
}

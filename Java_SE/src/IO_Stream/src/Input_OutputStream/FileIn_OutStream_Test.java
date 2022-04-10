package Input_OutputStream;

import org.junit.Test;

import java.io.*;

/**
 * 结论：
 *  * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 *  * 2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 */
public class FileIn_OutStream_Test {
    //使用字节流FileInputStream处理文本文件，可能出现乱码。
    @Test
    public void test() {
        FileInputStream fileInputStream = null;
        try {
            //1. 造文件
            File file = new File("hello.txt");
            //2.造流
            fileInputStream = new FileInputStream(file);
            //3.读数据
            byte[] bytes = new byte[5];
            int len;//记录每次读取的字节的个数
            while ((len=fileInputStream.read(bytes))!=-1){
                String str = new String(bytes,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null)
            {
                try {
                    //4.关闭资源
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用字节流FileInputStream处理非文本文件  如图片
    @Test
    public void test2(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File("1.jpg");
            File file2 = new File("11.jpg");

            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);

            byte[]bytes=new byte[5];
            int len;
            while ((len=fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream!=null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\ASUS\\Desktop\\筷子兄弟 - 父亲.mp3";
        String destPath = "C:\\Users\\ASUS\\Desktop\\筷子兄弟 - 父亲1.mp3";

//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";

        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//90
    }

}

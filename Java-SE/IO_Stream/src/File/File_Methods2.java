package File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;


public class File_Methods2 {
    /**
     * public boolean isDirectory()：判断是否是文件目录
     * public boolean isFile() ：判断是否是文件
     * public boolean exists() ：判断是否存在
     * public boolean canRead() ：判断是否可读
     * public boolean canWrite() ：判断是否可写
     * public boolean isHidden() ：判断是否隐藏
     */
    @Test
    public void test() {
        File file1 = new File("hello.txt");
//        file1 = new File("hello1.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("d:\\io");
//        file2 = new File("d:\\io1");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    /**
     * 创建硬盘中对应的文件或文件目录
     * public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
     * public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     * public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建
     * <p>
     * 删除磁盘中的文件或文件目录
     * public boolean delete()：删除文件或者文件夹
     * 删除注意事项：Java中的删除不走回收站。
     */
    @Test
    public void test2() throws IOException {
        File file1 = new File("hi.txt");
        if (!file1.exists()) {
            //文件的创建
            file1.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test3(){
        //文件目录的创建
        File file1 = new File("C:\\Users\\ASUS\\Desktop\\1\\3");

        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }

        File file2 = new File("C:\\Users\\ASUS\\Desktop\\1\\4\\5");

        boolean mkdir1 = file2.mkdirs();
        if(mkdir1){
            System.out.println("创建成功2");
        }

        //要想删除成功，io4文件目录下不能有子目录或文件
        File file3 = new File("C:\\Users\\ASUS\\Desktop\\1\\4");
        file3 = new File("C:\\Users\\ASUS\\Desktop\\1\\4");
        System.out.println(file3.delete());
    }
}

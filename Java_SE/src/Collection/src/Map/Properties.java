package Map;


import java.io.FileInputStream;
import java.io.IOException;

public class Properties {
    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args)  {
        FileInputStream fileInputStream = null;
        try {
            java.util.Properties properties = new java.util.Properties();
            fileInputStream = new FileInputStream("C:\\Users\\ASUS\\Desktop\\JAVA\\Collection\\jdbc.properties");
            properties.load(fileInputStream);//加载流对应的文件

            String name = properties.getProperty("name");
            String password = properties.getProperty("password");

            System.out.println("name = " + name + ", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

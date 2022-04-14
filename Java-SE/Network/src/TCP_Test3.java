import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Test3 {
    /**
     *  实现TCP的网络编程
     *  例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
     *  并关闭相应的连接
     */
    @Test
    public void client() throws IOException {
        //1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
        //2.
        OutputStream os = socket.getOutputStream();
        //3.
        FileInputStream fis = new FileInputStream(new File("1.jpg"));
        //4.
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        //关闭数据的输出
        socket.shutdownOutput();
        //5.接受来自服务器的信息
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes1 = new byte[24];
        int len1;
        while ((len1 = inputStream.read(bytes1)) != -1) {
            bos.write(bytes1, 0, len1);
        }
        System.out.println(bos.toString());
        //6.
        bos.close();
        inputStream.close();
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        //1.
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.
        Socket socket = serverSocket.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("3.jpg"));
        //5.
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        System.out.println("图片传输完成");
        //6.服务器端给予反馈
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("数据已收到".getBytes());
        //7.
        outputStream.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}

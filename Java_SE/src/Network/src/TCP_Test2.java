import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Test2 {
    /**
     * * 实现TCP的网络编程
     * * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
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
        //5.
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
        FileOutputStream fos = new FileOutputStream(new File("2.jpg"));
        //5.
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        //6.
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}

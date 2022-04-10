import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 */
public class TCP_Test {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        BufferedOutputStream bw = null;
        try {
            //1.创建socket对象，指明服务器的ip和端口号
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ip, 8899);
            //2.获取输出流，用于输出数据
            outputStream = socket.getOutputStream();
            bw = new BufferedOutputStream(outputStream);
            //3.写出数据
            bw.write(("这是客户端").getBytes());
            /*bw.flush();*/
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
            //4.关闭资源
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //服务器端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream bos = null;
        BufferedInputStream br = null;
        try {
            //1.创建服务器端的serverSocket，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2.调用accept方法，表示接收来自于客户端的socket
            socket = serverSocket.accept();
            //3.获取输入流
            inputStream = socket.getInputStream();
            br = new BufferedInputStream(inputStream);
            //不建议这样写，可能会有乱码
        /*byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer)) != -1){
            String str = new String(buffer,0,len);
            System.out.print(str);
        }*/
            //4.读取输入流中的数据
            bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = br.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            System.out.println(bos.toString());
            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //5.关闭资源
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

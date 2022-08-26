package NoteAppend_Sokect;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Lishenglong
 * @Date: 2022/5/15 14:33
 */
public class TCPTest1 {

    @Test
    public void client() {
        Socket s = null;
        OutputStream outputStream = null;
        try {
            //1.创建Socket对象 指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            s = new Socket(inet, 8899);
            //2.获取一个输出流
            outputStream = s.getOutputStream();
            //3.写数据
            outputStream.write("你好，哈哈哈".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server() {
        Socket s = null;
        ServerSocket ss = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;

        try {
            //创建服务器端的ServerSocket
            ss = new ServerSocket(8899);
            //2.调用accpet表示接受来自客户端的socket
            s = ss.accept();
            //3.获取输入流
            inputStream = s.getInputStream();

            //不建议使用，容易出现乱码
            /*byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                System.out.println(buffer.toString());
            }*/

            //4.利用输入流读取数据 放入到中间缓冲层当中
            //对Byte类型的数据的一个写入的类 相当于一个中间缓冲层 内部有一个数组缓冲区 数据可以存到里面 可以自动扩容
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println(s.getInetAddress().getHostAddress());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
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
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

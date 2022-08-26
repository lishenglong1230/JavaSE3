package NoteAppend_Sokect;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 臭手哥！！！！！！！！！！！！！！！！！！
 * @Date: 2022/5/15 15:00
 */
public class TCPTest3 {

    @Test
    public void client() {
        Socket s = null;
        OutputStream outputStream = null;
        BufferedInputStream fis = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            s = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
            outputStream = s.getOutputStream();
            //想要速度快 缓冲流可以包一下
            fis = new BufferedInputStream(new FileInputStream("1.png"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }

            //与文本不一样，需要给对方一个提示，已经传完关闭数据的输出 read是一个阻塞的方法
            s.shutdownOutput();

            //接受服务端给的反馈
            inputStream = s.getInputStream();
            baos= new ByteArrayOutputStream();
            byte[] buf = new byte[20];
            int len1;
            while ((len1=inputStream.read(buf))!=-1){
                baos.write(buf,0,len1);
            }



            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if ( baos!= null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream == null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
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
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8899);
        Socket socket = ss.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("3.png"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            bos.write(buffer,0,len);
        }

        //完事儿给客户端消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("照片已收到".getBytes());

        outputStream.close();
        bos.close();
        inputStream.close();
        socket.close();
        ss.close();
    }
}

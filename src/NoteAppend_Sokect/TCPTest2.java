package NoteAppend_Sokect;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Lishenglong
 * @Date: 2022/5/15 15:00
 */
public class TCPTest2 {

    @Test
    public void client() {
        Socket s = null;
        OutputStream outputStream = null;
        BufferedInputStream fis = null;
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            if (outputStream != null) {
                try {
                    outputStream.close();
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
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("2.png"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            bos.write(buffer,0,len);
        }

        bos.close();
        inputStream.close();
        socket.close();
        ss.close();
    }
}

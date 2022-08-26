package NoteAppend_Sokect;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: Lishenglong
 * @Date: 2022/5/15 16:53
 */
public class URLTest1 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/examples/beauty.jpg");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("beauty3.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("下载完成");
        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}

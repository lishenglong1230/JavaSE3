package NoteAppend_Sokect;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: Lishenglong
 * @Date: 2022/5/15 16:37
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/examples/1.jpg?username=admin&password=123");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());//文件路径
        System.out.println(url.getFile());//文件名
        System.out.println(url.getQuery());//查询名/参数
    }
}

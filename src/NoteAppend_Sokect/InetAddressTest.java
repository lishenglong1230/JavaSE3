package NoteAppend_Sokect;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Lishenglong
 * @Date: 2022/5/14 15:33
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet1 = InetAddress.getByName("192.168.10.4");
        System.out.println(inet1);
        InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
        System.out.println(inet2);

        InetAddress inet3 = InetAddress.getByName("127.0.0.1");
        System.out.println(inet3);
        InetAddress inet4 = InetAddress.getLocalHost();
        System.out.println(inet4);

        System.out.println(inet3.getHostName());
        System.out.println(inet3.getHostAddress());


    }
}

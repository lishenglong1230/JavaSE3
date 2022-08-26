package NoteAppend_Sokect;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @Author: Lishenglong
 * @Date: 2022/5/15 16:23
 */
public class UDPTest {

    @Test
    public void send() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str = "你好";
        byte[] bytes = str.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length, InetAddress.getLocalHost(),9090);
        socket.send(packet);

        socket.close();
    }

    @Test
    public void receive() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[100];

        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));



    }

}

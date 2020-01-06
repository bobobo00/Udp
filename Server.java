package UDP;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;

/**
 * @ClassName Server
 * @Description TODO
 * @Auther danni
 * @Date 2019/12/20 11:25]
 * @Version 1.0
 **/

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8886);
        boolean flag=true;
       // while(flag){
            byte[] datas=new byte[1024];
            DatagramPacket packet= new DatagramPacket(datas,0,datas.length);
            server.receive(packet);
            InetAddress clientAddress=packet.getAddress();
            System.out.printf("我从 %s:%d 收到了消息%n",clientAddress.getHostAddress(),packet.getPort());
            System.out.printf("收到 %d 个字节数%n",packet.getLength());
            System.out.println("消息为："+new String(datas));

            String message="已接收消息！";
            byte[] senddatas=message.getBytes();
            DatagramPacket sendPacket=new DatagramPacket(senddatas,0,senddatas.length,new InetSocketAddress(packet.getAddress(),packet.getPort()));
            server.send(sendPacket);
       // }
    }
}

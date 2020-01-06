package UDP;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;

/**
 * @ClassName Client
 * @Description TODO
 * @Auther danninew
 * @Date 2019/12/20 11:20]
 * @Version 1.0
 **/

public class Client {
    public static void main(String[] args) throws IOException {

        /*DatagramSocket client=new DatagramSocket();
        String message="hello,你好！";
        byte[] buffer=message.getBytes();
        byte[] serverIP=new byte[4];
        serverIP[0]=127;
        serverIP[1]=0;
        serverIP[2]=0;
        serverIP[3]=1;
        InetAddress serverAddress=InetAddress.getByAddress(serverIP);
        DatagramPacket packet=new DatagramPacket(buffer,0,buffer.length,serverAddress,8886);
        client.send(packet);
        client.close();*/

        DatagramSocket client=new DatagramSocket(6668);
        boolean flag=true;
        DataInputStream scanner=new DataInputStream(System.in);
       // while(flag){
            String message=scanner.readUTF();
            byte[] datas=message.getBytes();
            DatagramPacket sendpacket=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",8886));
            client.send(sendpacket);

            byte[] receivedatas=new byte[1024];
            DatagramPacket receivepacket=new DatagramPacket(receivedatas,0,datas.length);
            client.receive(receivepacket);
            System.out.println("从"+receivepacket.getAddress()+":"+receivepacket.getPort()+"接收消息："+new String(receivedatas));
        //}
        client.close();
    }
}

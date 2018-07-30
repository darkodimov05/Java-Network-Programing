package mk.ukim.finki.ds.lab4.zad1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient extends Thread {
	
	int portListen;
	int portSend;
	int portConnectWith;
	String ipConnectWith;
	
	DatagramPacket dp;
	DatagramSocket socketForSend;
	ChatListener cl;
	
	Scanner sc;
	
	public ChatClient(int portListen, String ipConnectWith,int portConnectWith) throws SocketException{
		this.portListen = portListen;
		this.portSend = portListen + 1;
		
		this.ipConnectWith = ipConnectWith;
		this.portConnectWith = portConnectWith;
		
		sc = new Scanner(System.in);
		
		cl = new ChatListener(portListen);
		cl.start();
		
		socketForSend = new DatagramSocket(portSend);
	}
	
	@Override
	public void run() {
		while(true){
			String line = sc.nextLine();
					
			try {
				dp = ChatClient.getPacket(line, ipConnectWith, portConnectWith);
				socketForSend.send(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static DatagramPacket getPacket(String message,String ip, int port) throws UnknownHostException{
		byte[] buffer = message.getBytes();
		InetAddress address =InetAddress.getByName(ip);
		
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length,address,port);
		
		return dp;
	}
}

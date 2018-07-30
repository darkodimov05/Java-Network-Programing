package mk.ukim.finki.ds.lab4.zad1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatListener extends Thread {

	public int portListen;
	DatagramSocket socketToRead;
	DatagramPacket dp;
	
	public ChatListener(int portListen) throws SocketException {
		this.portListen = portListen;
		socketToRead = new DatagramSocket(portListen);
	}
	@Override
	public void run() {
		while(true){
			byte [] buffer = new byte[1000];
			dp = new DatagramPacket(buffer, buffer.length);
			
			try {
				
				socketToRead.receive(dp);
				String message = new String (dp.getData());
				
				String from = dp.getSocketAddress().toString();
				
				System.out.println("FROM " + from +" \n \t--->" + message);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}

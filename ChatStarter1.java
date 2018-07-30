package mk.ukim.finki.ds.lab4.zad1;

import java.net.SocketException;

public class ChatStarter1 {
	public static void main(String[] args) throws SocketException {
		ChatClient cc1 = new ChatClient(4000, "localhost", 5000);
		cc1.start();
	}
}

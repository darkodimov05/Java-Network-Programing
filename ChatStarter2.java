package mk.ukim.finki.ds.lab4.zad1;

import java.net.SocketException;

public class ChatStarter2 {
	public static void main(String[] args) throws SocketException {
		ChatClient cc2 = new ChatClient(5000, "localhost", 4000);
		cc2.start();
	}
}

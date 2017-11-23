package control;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6666);
			serverSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("666");
	
	
	}

}

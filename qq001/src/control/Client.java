package control;

import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",6666);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}

}

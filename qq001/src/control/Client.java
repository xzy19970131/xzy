package control;

import java.io.IOException;
import java.net.Socket;

public class Client {
	private Socket socket;
	public void DengLu() {
		try {
			socket = new Socket("localhost",6666);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

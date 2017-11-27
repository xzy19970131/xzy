package control;

import java.io.IOException;
import java.net.Socket;

public class Client {
	private Socket socket;
	public void DengLu() {
		try {
			socket = new Socket(qqconfig.serverIP,qqconfig.serverPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

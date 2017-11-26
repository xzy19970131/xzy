package control;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import GUI.ServerFrame;

/**
 * @author lenovo
 *
 */
public class Server {
	private JTextArea serverFrame;
	static ServerSocket serverSocket;
	
	
	public Server(JTextArea textArea) {
		super();
		this.serverFrame = textArea;
	}
	public void startServe() {
//		while(true)
//		{
			try {
				serverFrame.append("服务器开始服务");
				Socket client = serverSocket.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
	
	}
	
	public boolean Open() {                         //打开服务器
		try {
			serverSocket = new ServerSocket(6666);
			serverFrame.append("服务器已经打开");
			serverFrame.getParent().paintAll(serverFrame.getParent().getGraphics());
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public void MuLu() {                           //更新在线列表
		serverFrame.append("666");  
	}
	
	
}

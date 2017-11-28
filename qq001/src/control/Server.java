package control;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import GUI.ServerFrame;
import control.qqconfig;
/**
 * @author lenovo
 *
 */
public class Server {
	private JTextArea serverFrame;
	static ServerSocket serverSocket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	
	public Server(JTextArea textArea) {
		super();
		this.serverFrame = textArea;
	}
	public void startServe() {
		
		new Thread() {
			public void run() {
				while(true)
			{
					try {
						serverFrame.append("服务器开始服务~\n");
						JOptionPane.showMessageDialog(serverFrame,"服务器已开始服务","温馨提示",JOptionPane.INFORMATION_MESSAGE);
						serverFrame.getParent().paintAll(serverFrame.getParent().getGraphics());
						Socket client = serverSocket.accept();		
						out = new ObjectOutputStream(client.getOutputStream());
						in = new ObjectInputStream(client.getInputStream());
						
						
						
					} catch (IOException e) {
						JOptionPane.showMessageDialog(serverFrame,"服务器开始失败","温馨提示",JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
			}
			
			}
		}.start();

	}
	
	public boolean Open() {                         //打开服务器
		try {
			serverSocket = new ServerSocket(qqconfig.serverPort);
			serverFrame.append("服务器已经打开"+"\n");
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
	
	
	//内部类
	//用于和服务器交流的
	class
	
	
	
	
	
}

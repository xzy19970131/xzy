package control;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import GUI.ServerFrame;
import control.qqconfig;
import qqmodel.Message;
import qqmodel.qqUser;

/**
 * @author lenovo
 *
 */
public class Server {
	private JTextArea serverFrame;
	static ServerSocket serverSocket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private TableModel  model;
	private Object[] tableTitle=new Object[]{"登陆IP","用户昵称"};
	private JTable table;
	public Server(JTextArea textArea) {
		super();
		this.serverFrame = textArea;
	}
	public void startServe() {
		serverFrame.append("服务器开始服务~\n");
		JOptionPane.showMessageDialog(serverFrame,"服务器已开始服务","温馨提示",JOptionPane.INFORMATION_MESSAGE);
		serverFrame.getParent().paintAll(serverFrame.getParent().getGraphics());
		new Thread() {
			public void run() {
				while(true)
				{
					try {
						Socket client = serverSocket.accept();	
						System.out.println("有用户接入\n");
						out = new ObjectOutputStream(client.getOutputStream());
						in = new ObjectInputStream(client.getInputStream());
						
						chatclass thischat = new chatclass(out, in);
						thischat.start();
					
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
	class chatclass extends Thread{
		ObjectOutputStream out;
		ObjectInputStream in;
		public chatclass(ObjectOutputStream out, ObjectInputStream in) {
			super();
			this.out = out;
			this.in = in;
		}
		public void run() {
			//不断读取客户端的传来的数据
			while(true) {
				try {
					while(true)//不停的读取客户端发送过来的消息
					{
						Message  m=(Message)in.readObject();//当前这个线程接收到这个客户端发送过来的一个Message对象
						System.out.println(m);
						if(m.getType().equals("login")) {
							LoginMessage(m);
						}else if(m.getType().equals("register")) {
							RegisterMessage(m);
						}else if(m.getType().equals("addFriend")) {
							
						}else if(m.getType().equals("search")) {
							
						}else if(m.getType().equals("update")) {
							
						}
						

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
				//登陆
		private void LoginMessage(Message  m) {
			//链接数据库判断用户登陆信息是否正确
			qqUser loginedUser=Operator.login(m.getFrom().getName(), m.getFrom().getPassword());
			
//			if(loginedUser!=null) {
//				allClient.put(loginedUser.getUsername(), out);//在登陆成功后将该登陆的号码和对应的通讯流存储到服务器的这个全局集合里
//				//如果登陆成功，需要更新服务器窗口上显式的用户列表信息
//			//如果登陆成功，需要更新服务器窗口上显式的用户列表信息
//			model=new DefaultTableModel(new Object[][] {{loginedUser.getName(),loginedUser.getNickname()}}, tableTitle);
//			table.setModel(model);
//			}
			//当服务器根据传过来的用户名和密码查询完数据库之后，无论登陆成功还失败都要给用户回一个消息(都要封装成MessageBox)
			Message loginResult=new Message();
			loginResult.setFrom(loginedUser);
			loginResult.setType("loginResult");
			try {
				out.writeObject(loginResult);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
		//注册
		private void RegisterMessage(Message m) {  
			
			qqUser  willResgisterUser=m.getFrom();
			Boolean result=Operator.register(willResgisterUser);
			Message  registerResultMessage=new Message();
			registerResultMessage.setContent(result.toString());
			registerResultMessage.setType("registerResult");
			try {
				out.writeObject(registerResultMessage);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}

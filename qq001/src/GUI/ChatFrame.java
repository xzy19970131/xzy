package GUI;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import qqmodel.Message;
import qqmodel.qqUser;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class ChatFrame extends JFrame {
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private qqUser my;
	private qqUser your;
	private JPanel contentPane;
	private JPanel contentPane_1;
	private Message time;
	private JTextArea textArea;
	private String  willSendMessage;
	
	public JTextArea getTextArea() {
		return textArea;
	}
	public ChatFrame( qqUser m,qqUser your ,ObjectInputStream in, ObjectOutputStream out)
			throws HeadlessException {
		this.in = in;
		this.out = out;
		this.my = m;
		this.your = your;
		this.contentPane = contentPane;
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 569, 412);
			contentPane_1 = new JPanel();
			contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane_1);
			contentPane_1.setLayout(null);
			
			JTextArea textArea_1 = new JTextArea();
			textArea_1.setBounds(10, 233, 379, 103);
			contentPane_1.add(textArea_1);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(406, 14, 137, 151);
			lblNewLabel.setIcon(new ImageIcon(ChatFrame.class.getResource("/image/touxiang03.png")));
			contentPane_1.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setBounds(406, 185, 137, 151);
			lblNewLabel_1.setIcon(new ImageIcon(ChatFrame.class.getResource("/image/touxiang02.png")));
			contentPane_1.add(lblNewLabel_1);
			
			JButton btnNewButton = new JButton("抖动");
			btnNewButton.setBounds(10, 346, 93, 23);
			btnNewButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						Message  m=new Message();
						
						m.setFrom(ChatFrame.this.my);
						m.setTo(ChatFrame.this.your);
						m.setType("shakeMessage");
						shakeWindow();
					}
				
			});
			contentPane_1.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("发送");
			btnNewButton_1.setBounds(156, 346, 93, 23);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//这里面是处理当用户点击发送按钮式要执行的业务代码
					//1.先获取编辑文本框里面的输入的要发送的文本
					willSendMessage=textArea_1.getText();
					
					
					//2.先将消息封装成MessageBox发送给服务器
					Message  b=new Message();
					b.setContent(willSendMessage);
					b.setFrom(ChatFrame.this.my);
					
					if(ChatFrame.this.your==null)//判断是群聊窗口
					{	String qunming = null;
						qqUser user=new qqUser();
						user.setName(qunming);
						b.setTo(user);
						b.setType("qunMessage");
					}else
					{
						b.setType("textMessage");
						b.setTo(ChatFrame.this.your);
					}
					
					//3.用从登录界面传过来的输出流写给服务器，让服务器帮我转发给我我的好友
					try {
							out.writeObject(b);
							out.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					//4.接受服务器给我回发的时间
//						try {
//							Message time=(Message)ChatFrame.this.in.readObject();
//							System.out.println("收到服务器会的时间");
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
						//5.将即将发送的消息设置到上面的这个聊天信息框里面
						String nowTime=new Date().toLocaleString();
						textArea.append(ChatFrame.this.my.getNickname() +"  :  "+nowTime+"\t\t\r\n"+willSendMessage+"\r\n\r\n");
					//6.将消息发送狂里面的内容清空
					textArea_1.setText("");
					
				}
			});
			contentPane_1.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("关闭");
			btnNewButton_2.setBounds(296, 346, 93, 23);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			contentPane_1.add(btnNewButton_2);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 14, 379, 206);
			contentPane_1.add(scrollPane);
			
			textArea = new JTextArea();
			scrollPane.setViewportView(textArea);
		
	}
	public void  shakeWindow() {
		new Thread() {
			public void run() {
				int pianyi=3;
				int waitTime=50;
				int lastX=ChatFrame.this.getX();
				int lasty=ChatFrame.this.getY();
				for(int n=0;n<3;n++)
				{
					ChatFrame.this.setLocation(lastX-pianyi, lasty);
					try {
						Thread.sleep(waitTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ChatFrame.this.setLocation(lastX, lasty-pianyi);
					try {
						Thread.sleep(waitTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ChatFrame.this.setLocation(lastX+pianyi, lasty);
					try {
						Thread.sleep(waitTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ChatFrame.this.setLocation(lastX, lasty+pianyi);
					try {
						Thread.sleep(waitTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				ChatFrame.this.setLocation(lastX, lasty);
			};
			
		}.start();
	}

}

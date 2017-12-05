package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import control.Server;
import control.qqconfig;
import qqmodel.Message;
import qqmodel.qqUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JPasswordField;

public class DengLuFrame extends JFrame {

	private JPanel contentPane;
	private Socket client;
	private JTextArea jTextArea;
	private ServerFrame serverFrame;
	private Server server;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	ObjectOutputStream out;
	ObjectInputStream in;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DengLuFrame frame = new DengLuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DengLuFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DengLuFrame.class.getResource("/image/QQ.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 417, 157);
		label.setIcon(new ImageIcon(DengLuFrame.class.getResource("/image/Shang.png")));
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBounds(0, 152, 417, 143);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(21, 21, 93, 86);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(DengLuFrame.class.getResource("/image/TouXiang.png")));

		JButton btnNewButton = new JButton("登录"); // 登录界面 点 登录 按钮
		btnNewButton.setBounds(124, 103, 197, 30);
		panel.add(btnNewButton);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (client == null) {
					try {
						client = new Socket(qqconfig.serverIP, qqconfig.serverPort);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				String Jzhanghao = comboBox.getSelectedItem().toString().trim();
				String Jmima = passwordField.getText().trim();
				try {
					out = new ObjectOutputStream(client.getOutputStream());
					in = new ObjectInputStream(client.getInputStream());
					qqUser willLoginUser = new qqUser(Jzhanghao, Jmima);
					Message message = new Message();
					message.setType("login");
					message.setFrom(willLoginUser);
					out.writeObject(message);
					out.flush();
					
					
					Message result=(Message)in.readObject();
					if(result.getFrom()==null) {
						JOptionPane.showMessageDialog(DengLuFrame.this, "登陆失败,请检查用户名和密码!","温馨提示",JOptionPane.ERROR_MESSAGE);
					}else
					{
						
						qqUser u=result.getFrom();//登陸程序到的用戶資料，存儲在服務器給我發過來的消息裡面的From屬性裡面的
						MainFrame  m=new MainFrame(u,in,out);
						m.setVisible(true);
						//com.sun.awt.AWTUtilities.setWindowOpacity(m, 0.9f);
						DengLuFrame.this.setVisible(false);
					}
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

		btnNewButton.setForeground(SystemColor.text);

		JCheckBox chckbxNewCheckBox = new JCheckBox("记住密码");
		chckbxNewCheckBox.setBounds(124, 80, 85, 17);
		panel.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("自动登录");
		chckbxNewCheckBox_1.setBounds(237, 80, 85, 17);
		panel.add(chckbxNewCheckBox_1);

		comboBox = new JComboBox();
		comboBox.setBounds(124, 21, 197, 30);
		panel.add(comboBox);
		comboBox.setToolTipText("");
		comboBox.setEditable(true);
		comboBox.setForeground(Color.BLACK);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(124, 50, 197, 30);
		panel.add(passwordField);

		JLabel lblNewLabel_2 = new JLabel("找回密码");
		lblNewLabel_2.setBounds(331, 57, 54, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("注册账号");
		lblNewLabel_1.setBounds(331, 31, 54, 15);
		panel.add(lblNewLabel_1);

		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					if (client == null) {
						client = new Socket(qqconfig.serverIP, qqconfig.serverPort);
						out = new ObjectOutputStream(client.getOutputStream());
						in = new ObjectInputStream(client.getInputStream());
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(DengLuFrame.this, "无法连接服务器，请检查网络!", "温馨提示",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				RegisterFrame registerFrame = new RegisterFrame(in,out);
				registerFrame.setVisible(true);
				DengLuFrame.this.setVisible(false);
			}
		});
	}
}

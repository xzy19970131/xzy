package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import control.Client;
import control.Server;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class DengLuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Client client;
	private JTextArea jTextArea;
	private ServerFrame serverFrame;
	private Server server;
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
		setBounds(100, 100, 427, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DengLuFrame.class.getResource("/image/Shang.png")));
		label.setBounds(0, 0, 411, 132);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("登录");                    //登录界面       点  登录 按钮 
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client= new Client();
				client.DengLu();
				serverFrame = new ServerFrame();
				jTextArea = serverFrame.getTextArea();
				server = new Server(jTextArea);
				server.MuLu();
				jTextArea.paintComponents(jTextArea.getGraphics());
				jTextArea.repaint();
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(124, 224, 197, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DengLuFrame.class.getResource("/image/TouXiang.png")));
		lblNewLabel.setBounds(21, 142, 93, 86);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(124, 142, 197, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 172, 197, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("记住密码");
		chckbxNewCheckBox.setBounds(124, 195, 85, 27);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("自动登录");
		chckbxNewCheckBox_1.setBounds(231, 195, 85, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("注册账号");
		lblNewLabel_1.setBounds(331, 148, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("找回密码");
		lblNewLabel_2.setBounds(331, 178, 54, 15);
		contentPane.add(lblNewLabel_2);
	}
}

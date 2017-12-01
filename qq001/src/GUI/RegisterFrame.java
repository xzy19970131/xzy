package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import qqmodel.Message;
import qqmodel.qqUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {
ObjectInputStream in;
ObjectOutputStream out;
private JPanel contentPane;

	
	public RegisterFrame(ObjectInputStream in, ObjectOutputStream out) {
		this.in= in;
		this.out = out;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("用户账号");
		label.setBounds(10, 27, 54, 15);
		contentPane.add(label);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(84, 21, 158, 21);
		contentPane.add(editorPane);
		
		JLabel label_1 = new JLabel("账号密码");
		label_1.setBounds(10, 64, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("确认密码");
		label_2.setBounds(10, 100, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("用户昵称");
		label_3.setBounds(10, 133, 54, 15);
		contentPane.add(label_3);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(84, 58, 158, 21);
		contentPane.add(editorPane_1);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(84, 94, 158, 21);
		contentPane.add(editorPane_2);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setBounds(84, 133, 158, 21);
		contentPane.add(editorPane_3);
		
		JRadioButton radioButton = new JRadioButton("男");
		radioButton.setBounds(84, 213, 44, 19);
		contentPane.add(radioButton);
		
		JLabel label_4 = new JLabel("用户性别");
		label_4.setBounds(10, 215, 54, 15);
		contentPane.add(label_4);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		radioButton_1.setBounds(155, 212, 54, 20);
		contentPane.add(radioButton_1);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton_1);       //      把  男女   加入  按钮群中，  变成不可同时选中
		buttonGroup.add(radioButton);
		
		
		JLabel label_5 = new JLabel("用户年龄");
		label_5.setBounds(10, 168, 54, 15);
		contentPane.add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(84, 164, 158, 23);
		for(int i = 0;i<101;i++) {  				//增加年龄Item
			comboBox.addItem(i);
		}
		contentPane.add(comboBox);
		
		JLabel label_6 = new JLabel("用户头像");
		label_6.setBounds(289, 27, 54, 15);
		contentPane.add(label_6);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(289, 53, 93, 73);
		contentPane.add(comboBox_1);
		
		JLabel label_7 = new JLabel("个性签名");
		label_7.setBounds(289, 156, 54, 15);
		contentPane.add(label_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(289, 181, 127, 65);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("确认注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("点击了提交按钮");
				//1.先提取界面上用户输入的数据
				String name=editorPane.getText().trim();  //账号
				String mima=editorPane_1.getText();
				String mima2=editorPane_2.getText();
				String nickname = editorPane_3.getText();
				int age=Integer.parseInt(comboBox.getSelectedItem().toString());
				String sex = radioButton.isSelected()?"男":"女";
				String imagePath="image/1.jpg";
				String signature=textArea.getText().toString();
				//2.表单验证
				if(mima.equals(mima2)) {
					//3.封装成MessageBox
				
					qqUser  u=new qqUser(name, sex, mima, age,  imagePath, nickname,signature);
					System.out.println(u);
					Message  registerMessage=new Message();
					registerMessage.setFrom(u);
					registerMessage.setType("register");
					
					//4.使用序列化写给服务器，让服务器注册
					try {
						RegisterFrame.this.out.writeObject(registerMessage);
						RegisterFrame.this.out.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.out.println("send end");
					//5.根据服务器给我的回复的注册消息进一步跳转界面
					Message result=null;
					try {
						result = (Message)RegisterFrame.this.in.readObject();
					}  catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(RegisterFrame.this, "注册"+(result.getContent().equals("true")?"成功":"失败"),"温馨提示",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(RegisterFrame.this,"两次输入密码不一致！","提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(103, 256, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("返回登陆界面");
		button.setBounds(228, 256, 115, 21);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame.this.setVisible(false);
		
			}
		});
	}
}

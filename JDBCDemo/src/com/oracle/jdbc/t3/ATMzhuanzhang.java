package com.oracle.jdbc.t3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ATMzhuanzhang extends JFrame {

	private JPanel contentPane;

	public ATMzhuanzhang(final String zhuanchuAccount,String name, final float money, final JLabel label_1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入对方账号");
		lblNewLabel.setBounds(99, 48, 103, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请输入对方姓名");
		lblNewLabel_1.setBounds(99, 102, 103, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("请输入转账金额");
		lblNewLabel_2.setBounds(99, 159, 103, 31);
		contentPane.add(lblNewLabel_2);

		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(233, 215, 93, 23);
		contentPane.add(btnNewButton_1);
		
		final TextField textField = new TextField();
		textField.setBounds(208, 56, 135, 23);
		contentPane.add(textField);
		
		final TextField textField_1 = new TextField();
		textField_1.setBounds(208, 102, 135, 23);
		contentPane.add(textField_1);
		
		final TextField textField_2 = new TextField();
		textField_2.setBounds(208, 167, 135, 23);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yourInputAccount = textField.getText();
				String yourInputName =textField_1.getText();
				int yourInputNum= Integer.valueOf(textField_2.getText());
				
				Connection con;
				try {
					int yuemoney=0;
					con = DriverManager.getConnection("jdbc:oracle:thin:@172.19.22.126:1521:XE", "bankadmin", "bankadmin");
					Statement  sta=con.createStatement();
//					ResultSet  rs=sta.executeQuery("select * from accounts where accId="+yourInputAccount+"  and  accpass='"+yourInputPassword+"' ");
//					ResultSet  rs=sta.executeQuery(SELECT* FROM ACCOUNTS WHERE accid = yourInputAccount and accrealname = yourInputName and money>= yourInputNum);
					ResultSet yuers = sta.executeQuery("SELECT accmoney FROM accounts WHERE accid ="+zhuanchuAccount);
						if(yuers.next())yuemoney=yuers.getInt(1);
					ResultSet  rs=sta.executeQuery("SELECT* FROM ACCOUNTS WHERE accid = "+"'"+yourInputAccount+"'"+ "and accrealname ="+"'" +yourInputName+"'"+ "and"+"'"+ yourInputNum+"'"+"<="+"'"+yuemoney+"'");
					if(rs.next()) {	
					int  update01=sta.executeUpdate("update accounts  set accmoney=accmoney- " +yourInputNum +"WHERE accid ="+zhuanchuAccount);
					int  update02=sta.executeUpdate("update accounts  set accmoney=accmoney+ " +"'"+yourInputNum +"'"+"WHERE accid ="+"'"+ yourInputAccount+"'" );
					JOptionPane.showMessageDialog(null, "转账成功", "欢迎使用", JOptionPane.YES_OPTION);
					ResultSet  resyue=sta.executeQuery("select accmoney from accounts where accId="+zhuanchuAccount); 
						if(resyue.next()) {int yue = resyue.getInt(1);
						label_1.setText("您的账户余额:"+yue+"元RMB");
						}
					}
						else JOptionPane.showMessageDialog(null, "账户或资金异常", "温馨提示", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			

			}
		});

		btnNewButton.setBounds(120, 215, 93, 23);
		contentPane.add(btnNewButton);
	}

//	public ATMzhuanzhang(String name, float money) {
//		
//	}
	

}

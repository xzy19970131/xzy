package xzy0830;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendMailer02 {
	Frame f = new Frame("测试");
	TextField tf = new TextField(40);
	Button send = new Button("发送");
	public void i()
	{
		send.addActionListener(new MailerListener());
		f.add(tf);
		f.add(send, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
		class MailerListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("程序向"+tf.getText()+"发送邮件");
		}

	}
	
	public static void main(String[] args) {
		new SendMailer02().i();
	}

}

package xzy0830;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendMailer02 {
	Frame f = new Frame("����");
	TextField tf = new TextField(40);
	Button send = new Button("����");
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
			System.out.println("������"+tf.getText()+"�����ʼ�");
		}

	}
	
	public static void main(String[] args) {
		new SendMailer02().i();
	}

}

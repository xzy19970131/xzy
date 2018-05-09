package xzy0829;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionListener;

public class SendMailer {
	Frame f = new Frame("≤‚ ‘");
	TextField tf = new TextField(40);
	Button send = new Button("∑¢ÀÕ");
	public void i()
	{
		send.addActionListener(new MailerListener(tf));
		f.add(tf);
		f.add(send, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SendMailer().i();
	}

}

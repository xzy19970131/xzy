package xzy0829;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class MailerListener implements ActionListener {
	TextField mailAddress;
	public MailerListener(){}
	public MailerListener(TextField mailAddress)
	{
		this.mailAddress = mailAddress;
	}
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("程序向"+mailAddress.getText()+"发送邮件");
	}

}


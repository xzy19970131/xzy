package xzy0827;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;

public class DialogTest01 {
	Frame f = new Frame("���Դ���");
	Dialog d1 = new Dialog(f,"ģʽ�Ի���",true);
	Dialog d2 = new Dialog(f,"��ģʽ�Ի���",true);
	Button b1 = new Button("��ģʽ�Ի���");
	Button b2 = new Button("�򿪷�ģʽ�Ի���");
	void i(){
		d1.setBounds(20, 30, 300, 400);
		d2.setBounds(20, 30, 300, 400);
		d1.setVisible(true);
		d2.setVisible(true);
		f.add(b1);
		f.add(b2,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new DialogTest01().i();
	}

}

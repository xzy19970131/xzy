package xzy0827;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiListener01 {
	Frame f = new Frame("����");
	TextArea ta = new TextArea(6,40);
	Button b1 = new Button("��ťһ");
	Button b2 = new Button("��ť��");	
	void i(){
		a1 f1 = new a1();
		a2 f2 = new a2();
		b1.addActionListener(f1);
		b1.addActionListener(f2);
		b2.addActionListener(f1);
		f.add(ta);
		Panel p = new Panel();
		p.add(b1);
		p.add(b2);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		
	}
	class a1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ta.append("��һ�����������������¼�Դ�ǣ�"+e.getActionCommand()+"\n");
			
		}
	}
	class a2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ta.append("������"+e.getActionCommand()+"\n");
			
		}
		
	}
	public static void main(String[] args) {
		new MultiListener01().i();
	}

}

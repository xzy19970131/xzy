package xzy0827;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventQs01 {
		Frame f = new Frame("�����¼�");
		Button b = new Button("ȷ��");
		TextField tf = new TextField(30);
		void i(){
			b.addActionListener(new OkListener());
			f.add(tf);
			f.add(b,BorderLayout.SOUTH);
			f.pack();
			f.setVisible(true);
			
		}
	
		class OkListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.out.println("����ok��ť");
				tf.setText("Hello World");
			}
			
		}
	public static void main(String[] args) {
		new EventQs01().i();
	}

}

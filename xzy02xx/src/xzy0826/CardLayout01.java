package xzy0826;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayout01 {
	Frame f = new Frame();
	String[] name = {"第一张","第二张","第三张","第四张","第五张"};
	Panel p1 = new Panel();
	void i()
	{
		CardLayout c = new CardLayout();
		p1.setLayout(c);
		for(int i=0;i<name.length;i++){
			p1.add(name[i], new Button(name[i]));
		}
		Panel p = new Panel();
		ActionListener ( ActionEvent e ){
			;
		}

		
	}
	
	public static void main(String[] args) {
		
		
	}

}

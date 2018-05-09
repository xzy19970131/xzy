package xzy0825;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class jisuanqi {
	public static void main(String[] args) {
		Frame f = new Frame("¼ÆËãÆ÷");
		Panel p1 = new Panel();
		Panel p = new Panel();
		p1.add(new TextField(30),BorderLayout.NORTH);   //TextFieldÔÚp1µÄnorth
		p.setLayout(new GridLayout(3,5,4,4));
		String[] s = {"0","1","2","3","4","5","6","7","8","9","+","-","*","/"," "};
		for(int i=0;i<15;i++){
			p.add(new Button(s[i]));
		}
		f.add(p1,BorderLayout.NORTH);
		f.add(p);
		f.pack();
		f.setVisible(true);
		
	}

}

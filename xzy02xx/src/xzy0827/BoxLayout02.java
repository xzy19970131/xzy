package xzy0827;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;

public class BoxLayout02 {
	Frame f = new Frame("²âÊÔ´°¿Ú");
	Box h = Box.createHorizontalBox();
	Box v = Box.createVerticalBox();
	void i(){
		h.add(new Button("1"));
		h.add(new Button("2"));
		v.add(new Button("1"));
		v.add(new Button("2"));
		f.add(h,BorderLayout.NORTH);
		f.add(v);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BoxLayout02().i();
	}

}

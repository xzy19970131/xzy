package xzy0827;

import java.awt.Button;
import java.awt.Frame;

import javax.swing.BoxLayout;

public class BoxLayout01 {
	Frame f = new Frame();
	void i(){
		f.setLayout(new BoxLayout(f,BoxLayout.Y_AXIS));
		f.add(new Button("1"));
		f.add(new Button("2"));
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new BoxLayout01().i();
	}

}

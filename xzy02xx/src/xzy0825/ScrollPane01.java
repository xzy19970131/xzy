package xzy0825;

import java.awt.Button;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.TextField;

public class ScrollPane01 {
	public static void main(String[] args) {
		Frame f = new Frame("²âÊÔ´°¿Ú");
		ScrollPane s = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		s.add(new TextField(20));
		s.add(new Button("µ¥»÷ÎÒ"));
		f.add(s);
		f.setBounds(30,30,250,120);
		f.setVisible(true);
	}

}

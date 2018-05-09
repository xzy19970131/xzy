package xzy0825;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Layout01 {
	public static void main(String[] args) {
		Frame f = new Frame("²âÊÔ´°¿Ú");
		f.setLayout(new FlowLayout(FlowLayout.CENTER,20,5));
		for(int i = 0;i<10;i++){
			f.add(new Button("°´Å¥"+i));
		}
		f.pack();
		f.setVisible(true);
	}

}

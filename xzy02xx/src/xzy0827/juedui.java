package xzy0827;

import java.awt.Button;
import java.awt.Frame;

public class juedui {
		Frame f = new Frame("²âÊÔ´°¿Ú");
		Button b1 =new Button("°´Å¥1");
		Button b2 =new Button("°´Å¥2");
		void i(){
			f.setLayout(null);
			b1.setBounds(20, 30, 90, 28);
			f.add(b1);
			b2.setBounds(50, 45, 120, 35);
			f.add(b2);
			f.setBounds(50, 50, 200, 100);
			f.setVisible(true);
			
			
		}
		
		
	public static void main(String[] args) {
		new juedui().i();
	}

}

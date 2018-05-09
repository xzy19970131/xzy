package xzy0825;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayout01 {

	public static void main(String[] args) {
		Frame f = new Frame("���Դ���");
		f.setLayout(new BorderLayout(30,5));
		f.add(new Button("nan"),BorderLayout.SOUTH);
		f.add(new Button("bei"),BorderLayout.NORTH);
		f.add(new Button("xi"),BorderLayout.WEST);
		f.add(new Button("dong"),BorderLayout.EAST);
		f.add(new Button("zhong"),BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
		
	}

}

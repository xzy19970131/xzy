package xzy0828;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowAdapterTest {
	Frame f = new Frame("测试");
	TextArea ta = new TextArea(6,40);
	void i(){
		f.addWindowListener(new Mylistener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	class Mylistener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.out.println("用户关闭窗口"+"\n");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new	WindowAdapterTest().i();
	}

}

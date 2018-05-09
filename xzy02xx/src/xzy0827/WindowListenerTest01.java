package xzy0827;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerTest01 {
		Frame f = new Frame("测试");
		TextArea ta = new TextArea(6,40);
		void i(){

			f.add(ta);
			f.addWindowListener(new Mylistener());
			f.pack();
			f.setVisible(true);
		}
		class Mylistener implements WindowListener{

			public void windowOpened(WindowEvent e) {
				ta.append("窗口初次被打开"+"\n");
				
			}
			public void windowClosing(WindowEvent e) {
				ta.append("用户关闭窗口！"+"\n");
				System.exit(0);
			}
			public void windowClosed(WindowEvent e) {
				ta.append("窗口被成功关闭"+"\n");	
			}

	
			public void windowIconified(WindowEvent e) {
				ta.append("窗口被最小化"+"\n");
				
			}

			public void windowDeiconified(WindowEvent e) {
				ta.append("窗口被恢复"+"\n");
			}

			public void windowActivated(WindowEvent e) {
				ta.append("窗口被激活"+"\n");
			}

			public void windowDeactivated(WindowEvent e) {
				ta.append("窗口失去焦点"+"\n");
			}
			
		}
		
	public static void main(String[] args) {
		new WindowListenerTest01().i();
	}

}

package xzy0827;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerTest01 {
		Frame f = new Frame("����");
		TextArea ta = new TextArea(6,40);
		void i(){

			f.add(ta);
			f.addWindowListener(new Mylistener());
			f.pack();
			f.setVisible(true);
		}
		class Mylistener implements WindowListener{

			public void windowOpened(WindowEvent e) {
				ta.append("���ڳ��α���"+"\n");
				
			}
			public void windowClosing(WindowEvent e) {
				ta.append("�û��رմ��ڣ�"+"\n");
				System.exit(0);
			}
			public void windowClosed(WindowEvent e) {
				ta.append("���ڱ��ɹ��ر�"+"\n");	
			}

	
			public void windowIconified(WindowEvent e) {
				ta.append("���ڱ���С��"+"\n");
				
			}

			public void windowDeiconified(WindowEvent e) {
				ta.append("���ڱ��ָ�"+"\n");
			}

			public void windowActivated(WindowEvent e) {
				ta.append("���ڱ�����"+"\n");
			}

			public void windowDeactivated(WindowEvent e) {
				ta.append("����ʧȥ����"+"\n");
			}
			
		}
		
	public static void main(String[] args) {
		new WindowListenerTest01().i();
	}

}

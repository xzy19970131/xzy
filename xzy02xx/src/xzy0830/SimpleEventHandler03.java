package xzy0830;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class SimpleEventHandler03 extends WindowAdapter{
		Frame f = new Frame("����");
		TextArea ta = new TextArea(6,40);
		void i()
		{
			f.addWindowListener(this);
			f.add(ta);
			f.pack();
			f.setVisible(true);
		}
		public void windowClosing(WindowEvent e) 
		{
			ta.append("�û��رմ��ڣ�"+"\n");
			System.exit(0);
		}
		public static void main(String[] args) {
			new SimpleEventHandler03().i();
		}
}

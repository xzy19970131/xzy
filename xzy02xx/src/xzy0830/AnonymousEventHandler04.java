package xzy0830;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class AnonymousEventHandler04 {
	Frame f = new Frame("≤‚ ‘");
	TextArea ta = new TextArea(6,40);
	void i()
	{
		f.add(ta);
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent r)
			{
				ta.append("πÿ±’");
				System.exit(0);
				
			}
		}
				);
	}
	public static void main(String[] args) {
		new AnonymousEventHandler04().i();
	}

}

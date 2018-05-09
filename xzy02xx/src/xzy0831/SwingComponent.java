package xzy0831;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingComponent {
	JPanel p = new JPanel();
	JFrame f = new JFrame("测试");
	//Icon okIcon = new ImageIcon("/xzy02/src/xzy0831/xzyxxx.png");
	URL url=SwingComponent.class.getResource("xzyxxx.png"); 
	ImageIcon icon = new ImageIcon(url);
	JButton ok = new JButton("确认",icon);
	
	void i()
	{
		ok.setOpaque(false);//设置控件是否透明，true为不透明，false为透明  
		ok.setContentAreaFilled(false);//设置图片填满按钮所在的区域  
		//ok.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离  
		ok.setFocusPainted(false);//设置这个按钮是不是获得焦点  
		ok.setBorderPainted(false);//设置是否绘制边框  
		ok.setBorder(null);//设置边框  
		  
		p.add(ok);
		p.setBackground(Color.yellow);
		f.setSize(500, 500);
		f.add(p);
	//	f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new SwingComponent().i();
	}

}

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
	JFrame f = new JFrame("����");
	//Icon okIcon = new ImageIcon("/xzy02/src/xzy0831/xzyxxx.png");
	URL url=SwingComponent.class.getResource("xzyxxx.png"); 
	ImageIcon icon = new ImageIcon(url);
	JButton ok = new JButton("ȷ��",icon);
	
	void i()
	{
		ok.setOpaque(false);//���ÿؼ��Ƿ�͸����trueΪ��͸����falseΪ͸��  
		ok.setContentAreaFilled(false);//����ͼƬ������ť���ڵ�����  
		//ok.setMargin(new Insets(0, 0, 0, 0));//���ð�ť�߿�ͱ�ǩ����֮��ľ���  
		ok.setFocusPainted(false);//���������ť�ǲ��ǻ�ý���  
		ok.setBorderPainted(false);//�����Ƿ���Ʊ߿�  
		ok.setBorder(null);//���ñ߿�  
		  
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

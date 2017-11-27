package jiatupian;

import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gui extends JFrame{
	private JLabel j;
	
	public gui() {
		setSize(400,300);
		setVisible(true);
		setLocationRelativeTo(null);      //居中
		setLayout(null);
		
	//	j = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage("tt/shang.png")));
		//j = new JLabel();
	//	j.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("tt/shang.png")));
	//	j.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("tt/timg.gif")));
		//j = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("tt/timg.gif")));
		j = new JLabel();
		j.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("tt/timg.gif")));
		j.setBounds(0, 0, 400, 200);
		this.add(j);
	}
	public static void main(String[] args) {
		gui g =new gui();
		g.pack();
		g.setSize(400,300);

	}

}

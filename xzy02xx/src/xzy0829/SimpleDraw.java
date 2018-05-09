package xzy0829;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
public class SimpleDraw {
	String RECT_SHAPE = "rect";
	String OVAL_SHAPE = "oval";
	Frame f = new Frame("简单画图");
	Button rect = new Button("绘制矩形");
	Button oval = new Button("绘制圆形");
	Mycanvas drawArea = new Mycanvas();
	String shape = "";
	
	class Mycanvas extends Canvas
	{
		public void paint(Graphics g)
		{
			Random rand = new Random();
			if(shape.equals(RECT_SHAPE))
			{
				g.setColor(new Color(220,100,80));
				g.drawRect(rand.nextInt(200), rand.nextInt(120), 40, 60);
			}
			if(shape.equals(OVAL_SHAPE))
			{
				g.setColor(new Color(80,100,120));
				g.fillOval(rand.nextInt(200), rand.nextInt(120), 50, 40);
			}
		}
	}
	class myListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			shape = RECT_SHAPE;
			drawArea.repaint();
		}
		
	}
	class myListener02 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			shape = OVAL_SHAPE;
			drawArea.repaint();
		}
		
	}
	class myListener03 extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
	
	
	void i()
	{
		Panel p = new Panel();
		rect.addActionListener(new myListener());
		oval.addActionListener(new myListener02());
		f.addWindowListener(new myListener03());
		p.add(rect);
		p.add(oval);
		drawArea.setPreferredSize(new Dimension(250,180));
		f.add(drawArea);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SimpleDraw().i();
	}

}

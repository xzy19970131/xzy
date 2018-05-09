package xzy0829;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;

public class pinBall {
	
	private final int TABLE_WIDTH = 300;
	private final int TABLE_HEIGHT = 400;
	private final int RACKET_WIDTH = 60;
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_Y = 340;
	private final int BALL_SIZE =16;
	Frame f = new Frame("弹弹球游戏");
	Random rand = new Random();
	int ySpeed = 10;
	double xyRate = rand.nextDouble()-0.5;
	int xSpeed = (int)(ySpeed*xyRate*2);
	int ballX=rand.nextInt(200)+20;
	int ballY=rand.nextInt(10)+20;
	
	int racketX = rand.nextInt(200);
	MyCanvas tableArea = new MyCanvas();
	Timer timer;
	boolean isLose = false;
	
	void i()
	{
		//Timer
		//tableArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
		f.add(tableArea);
		
		KeyAdapter keyProcessor = new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke)
			{
				if(ke.getKeyCode()==KeyEvent.VK_LEFT);
				{
					if(racketX>0){racketX-=10;}
				}
				if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
					if(racketX<TABLE_WIDTH-RACKET_WIDTH)racketX+=10;
			}
		};
		f.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		
		ActionListener taskPerformer = new ActionListener() {
			
	
			public void actionPerformed(ActionEvent e) {
				if(ballX<=0||ballX>=TABLE_WIDTH){xSpeed=-xSpeed;}
				//if(ballX>=RACKET_Y-BALL_SIZE&&(ballX<racketX||ballX>racketX+RACKET_WIDTH)){timer.}
			}
		};
		
		
		
		//timer = new Timer(100,taskPerformer);
		//timer.start();
		f.pack();
		f.setVisible(true);
	}
	
	
	
	
	class mylistener02 implements ActionListener 
	{
		void start(){
			
		}
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	class MyCanvas extends Canvas
	{
		public void paint(Graphics g)
		{
			if(isLose)
			{
				g.setColor(new Color(255,0,0));
				g.setFont(new Font("Times",Font.BOLD,30));
				g.drawString("游戏已结束", 50, 200);
			}
			else
			{
				g.setColor(new Color(240,240,80));
				g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
				g.setColor(new Color(80,80,200));
				g.fillRect(racketX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		 new pinBall().i();
	}

}

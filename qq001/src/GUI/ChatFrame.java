package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import qqmodel.qqUser;

public class ChatFrame extends JFrame {

	private ObjectInputStream  in;
	private ObjectOutputStream  out;
	private qqUser my,your;
	private Object contentPane;

	public ChatFrame( qqUser my,qqUser your ,ObjectInputStream in, ObjectOutputStream out)
			throws HeadlessException {
		super();
		this.in = in;
		this.out = out;
		this.my = my;
		this.your = your;
		this.contentPane = contentPane;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatFrame frame = new ChatFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		((JComponent) contentPane).setBorder(new EmptyBorder(5, 5, 5, 5));
		((Container) contentPane).setLayout(new BorderLayout(0, 0));
		setContentPane((Container) contentPane);
	}

}

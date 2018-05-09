package xzy0829;

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PopupMenuTest {
	
	 PopupMenu pop = new PopupMenu();
	
	 Frame f = new Frame("����");
	//MenuBar mb = new MenuBar();
	//Menu file = new Menu("�ļ�");
	//Menu edit = new Menu("�༭");
	//MenuItem  newItem = new MenuItem("�½�");
	//MenuItem  saveItem = new MenuItem("����");
	//MenuItem  exitItem = new MenuItem("�˳�",new MenuShortcut(KeyEvent.VK_X));
	 CheckboxMenuItem autoWrap  = new CheckboxMenuItem("�Զ�����");
	 MenuItem copyItem = new MenuItem("����");
	MenuItem pasteItem = new MenuItem("ճ��");
	 Menu format = new Menu("��ʽ");
	 MenuItem  commentItem = new MenuItem("ע��",new MenuShortcut(KeyEvent.VK_SLASH,true));
	 MenuItem cancelItem = new MenuItem("ȡ��ע��");
	 TextArea ta = new TextArea(4,30);
	
	void i()
	{	
		commentItem.addActionListener(new Listener02());
		pop.add(autoWrap);
		pop.addSeparator();
		pop.add(copyItem);
		pop.add(pasteItem);
		
		format.add(commentItem);
		format.add(cancelItem);
		pop.add(format);
		final Panel p = new Panel();
		p.setPreferredSize(new Dimension(300,160));
		p.add(pop);
		p.addMouseListener(new Listener03());
		f.add(p);
		f.add(ta,BorderLayout.NORTH);
		f.addWindowListener(new Listener());
		f.pack();
		f.setVisible(true);
	}

	class Listener03 extends MouseAdapter{
		public void mouseReleased(MouseEvent e)
		{
			if(e.isPopupTrigger())
			{
			
				pop.show(p, e.getX(),e.getY());
			}
		}
	}
	class Listener02 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			ta.append("����"+cmd+"�˵�"+"\n");
			if(cmd.equals("�˳�"))
			{
				System.exit(0);
			}
		}	
	}
	class Listener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);                         //�����ڲ������ͨ���÷��Ա�
		}
	}
	public static void main(String[] args) {
		new PopupMenuTest().i();
	}

}

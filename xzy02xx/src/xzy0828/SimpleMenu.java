package xzy0828;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleMenu {
	Frame f = new Frame("����");
	MenuBar mb = new MenuBar();
	Menu file = new Menu("�ļ�");
	Menu edit = new Menu("�༭");
	MenuItem  newItem = new MenuItem("�½�");
	MenuItem  saveItem = new MenuItem("����");
	MenuItem  exitItem = new MenuItem("�˳�",new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoWrap  = new CheckboxMenuItem("�Զ�����");
	MenuItem copyItem = new MenuItem("����");
	MenuItem pasteItem = new MenuItem("ճ��");
	Menu format = new Menu("��ʽ");
	MenuItem  commentItem = new MenuItem("ע��",new MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem cancelItem = new MenuItem("ȡ��ע��");
	TextArea ta = new TextArea(6,40);
	
	void i()
	{
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		edit.add(autoWrap);
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		
		
		format.add(commentItem);
		format.add(cancelItem);
		edit.add(new MenuItem("-"));
		edit.add(format);
		mb.add(file);
		mb.add(edit);
		f.setMenuBar(mb);
		
		file.addActionListener(new Listener02());
	    edit.addActionListener(new Listener02());
		
		f.addWindowListener(new Listener());   // 
		/*f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});*/
		f.add(ta);
		f.pack();
		f.setVisible(true);	
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
		new SimpleMenu().i();
	}

}

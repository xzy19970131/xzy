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
	Frame f = new Frame("测试");
	MenuBar mb = new MenuBar();
	Menu file = new Menu("文件");
	Menu edit = new Menu("编辑");
	MenuItem  newItem = new MenuItem("新建");
	MenuItem  saveItem = new MenuItem("保存");
	MenuItem  exitItem = new MenuItem("退出",new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoWrap  = new CheckboxMenuItem("自动换行");
	MenuItem copyItem = new MenuItem("复制");
	MenuItem pasteItem = new MenuItem("粘贴");
	Menu format = new Menu("格式");
	MenuItem  commentItem = new MenuItem("注释",new MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem cancelItem = new MenuItem("取消注释");
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
			ta.append("单击"+cmd+"菜单"+"\n");
			if(cmd.equals("退出"))
			{
				System.exit(0);
			}
		}	
	}
	class Listener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);                         //匿名内部类和普通类用法对比
		}
	}
	public static void main(String[] args) {
		new SimpleMenu().i();
	}

}

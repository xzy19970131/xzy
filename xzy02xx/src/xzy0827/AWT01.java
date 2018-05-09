package xzy0827;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class AWT01 {
	Frame f = new Frame("测试窗口");
	Button ok = new Button("确定");
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox male = new Checkbox("男",cbg,true);
	Checkbox female = new Checkbox("女",cbg,false);
	Checkbox married = new Checkbox("是否已婚",false);
	Choice colorChooser = new Choice();
	List colorList = new List(6,true);
	TextArea ta = new TextArea(5,20);
	TextField name = new TextField(50);
	void i(){
		colorChooser.add("red");
		colorChooser.add("green");
		colorChooser.add("blue");
		colorList.add("红");
		colorList.add("绿");
		colorList.add("蓝");
		Panel p = new Panel();
		p.add(name);
		p.add(ok);
		f.add(p,BorderLayout.SOUTH);
		Panel p2 = new Panel();
		p2.add(colorChooser);
		p2.add(male);
		p2.add(female);
		p2.add(married);
		Box l = Box.createVerticalBox();
		l.add(ta);
		l.add(p2,BorderLayout.SOUTH);
		Box top = Box.createHorizontalBox();
		top.add(l);
		top.add(colorList);
		//top.add(l,BorderLayout.WEST);
		f.add(top);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AWT01().i();
		
	}

}

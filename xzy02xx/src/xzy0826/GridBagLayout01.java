package xzy0826;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

public class GridBagLayout01 {
	Frame f = new Frame("²âÊÔ´°¿Ú");
	GridBagLayout gb = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	Button[] b = new Button[10];
	void i()
	{
		f.setLayout(gb);
		for(int i= 0;i<b.length;i++){
			b[i] = new Button("°´Å¥"+i);
		}
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		addc(b[0]);
		addc(b[1]);
		addc(b[2]);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		addc(b[3]);
		gbc.weightx = 0;
		addc(b[4]);
		gbc.gridwidth = 2; 
		addc(b[5]);
		gbc.gridwidth = 1;
		gbc.gridheight=2;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		addc(b[6]);
		gbc.gridheight=2;
		gbc.gridwidth=1;
		gbc.weighty=1;
		addc(b[7]);
		gbc.weighty=0;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbc.gridheight=1;
		addc(b[8]);
		
		addc(b[9]);
		
		f.pack();
		f.setVisible(true);	
	}
	
	void addc(Button b){
		gb.setConstraints(b, gbc);
		f.add(b);
	}
	public static void main(String[] args) {
		new GridBagLayout01().i();		
	}
}

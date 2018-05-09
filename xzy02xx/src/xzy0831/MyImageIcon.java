package xzy0831;

import java.awt.Container;  
import java.net.URL;  
  
import javax.swing.*;  
  
public class MyImageIcon extends JFrame{  
    public MyImageIcon() {  
        Container container = getContentPane();  
        JLabel jl = new JLabel("����һ��JFrame����",JLabel.CENTER);  
        URL url=MyImageIcon.class.getResource("imageButtoo.jpg");  
        Icon icon = new ImageIcon(url);  
        jl.setIcon(icon);  
        jl.setHorizontalAlignment(SwingConstants.CENTER);  
        jl.setOpaque(true);  
        container.add(jl);  
        setSize(250,100);  
        setVisible(true);  
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  
    }  
    public static void main(String args[]){  
        new MyImageIcon();  
    }  
}  
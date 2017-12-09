package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import qqmodel.Message;
import qqmodel.qqUser;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private JTree friendTree,groupTree;
	//为了能记录所有和我聊过天的好友信息(打开过两天界面的好友信息)，我们定义一个集合存储这些资料
	private Map<String,ChatFrame>  allFrames=new HashMap<>();
	protected qqUser qquser;
	protected ObjectOutputStream out;
	protected ObjectInputStream in;
	public MainFrame(qqUser m,ObjectInputStream in,ObjectOutputStream out) {
		this.qquser = m;
		this.in = in;
		this.out = out;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 262, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);			
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 246, 127);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/image/2.png")));
		lblNewLabel.setBounds(10, 25, 88, 88);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText(m.getNickname());
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(108, 25, 128, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(m.getSignature());
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setBounds(108, 58, 128, 55);
		panel.add(textArea);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 137, 246, 401);
		contentPane.add(tabbedPane);
		
		JPanel 好友 = new JPanel();
		tabbedPane.addTab("好友", null, 好友, null);
		好友.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 241, 372);
		好友.add(scrollPane);
		

		JPanel 群聊 = new JPanel();
		tabbedPane.addTab("群聊", null, 群聊, null);
		群聊.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 241, 372);
		群聊.add(scrollPane_1);
		
		JPanel 最近联系人 = new JPanel();
		tabbedPane.addTab("最近联系人", null, 最近联系人, null);
		最近联系人.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 241, 372);
		最近联系人.add(scrollPane_2);
		
		
//		JTree tree = new JTree();                 //用Windowsbuild  创建默认树
//		scrollPane.setColumnHeaderView(tree);
		
		
		DefaultMutableTreeNode  root=new DefaultMutableTreeNode("root");//定义一个jtree根节点，所有的好友分组和好友都在这个根节点上往上放
		/**
		 * 解析用户里面的所有好友和分组信息，并生成到jtree上对吧
		 */
		Map<String, HashSet<qqUser>>  allFriends=qquser.getFriends();
		 
		Set<String>  allGroupNames=allFriends.keySet();//获取所有的分组名
		
		for(String groupName:allGroupNames) {
			DefaultMutableTreeNode  group=new DefaultMutableTreeNode(groupName);//构造出每个组名的对应的TreeNode对象
			HashSet<qqUser>  friendsOfGroup=allFriends.get(groupName);
			for(qqUser u:friendsOfGroup) {
				DefaultMutableTreeNode  friend=new DefaultMutableTreeNode(u.getNickname()+"["+u.getName()+"]");
				
				group.add(friend);
			}
			
			root.add(group);
		}
		friendTree = new JTree(root);     //	friendTree是一个  Tree
		friendTree.setRootVisible(false);
		scrollPane.setColumnHeaderView(friendTree);
		
		
		
		
								//聊天
		friendTree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1&&e.getClickCount()==2) {
					TreePath  path=friendTree.getSelectionPath();
					DefaultMutableTreeNode lastNode=(DefaultMutableTreeNode)path.getLastPathComponent();
					if(lastNode.isLeaf()) {
						//上面是解析用户双击之后判断是不是双击的某一个用户名上的这个Node
						String username=lastNode.toString();
						String num=username.substring(username.lastIndexOf("[")+1,username.length()-1);
						//
						qqUser your=new qqUser();
						your.setName(num);
						for(String firendNum:allFrames.keySet())
						{
							if(firendNum.equals(num))
							{
								allFrames.get(firendNum).setVisible(true);
								return;
							}
						}
						ChatFrame   chat=new ChatFrame(MainFrame.this.qquser,your,MainFrame.this.in,MainFrame.this.out);
						chat.setVisible(true);
						allFrames.put(num, chat);
					}
				}
			}
		});
		
		
		
		//我们在主界面的构造器最后一行（构造器里面的代码是负责呈现界面的，也就数界面都显式完整了，我们可以让后台的那个线程悄悄开始工作了）

		MessageReciverThread  t=new MessageReciverThread();
		t.start();
	}
	
	
	//主界面这个类应该定义一个线程，该线程运行时创建一个线程实例，在主界面单独运行，用来时时刻刻接受"服务器"给我的消息
	
	class  MessageReciverThread  extends Thread{
		@Override
		public void run() {
			Message  recivedMessage=null;
			try {
				A:while((recivedMessage=(Message)in.readObject())!=null) {
					System.out.println("shoudaole");
						
						for(String firendNum:allFrames.keySet())
						{System.out.println("zaizhao");
							if(firendNum.equals(recivedMessage.getFrom().getName()))
							{
								if(recivedMessage.getType().equals("shakeMessage"))
								{System.out.println("zhengdong");
									allFrames.get(firendNum).setVisible(true);
									allFrames.get(firendNum).shakeWindow();
									
									
								}else
								{System.out.println("xianshi");
									allFrames.get(firendNum).getTextArea().append(recivedMessage.getFrom().getNickname()+"  :  "+recivedMessage.getTime()+"\t\t\r\n"+recivedMessage.getContent()+"\r\n\r\n");
									allFrames.get(firendNum).setVisible(true);
								}
								continue A;
							}
						}
						ChatFrame  c=new ChatFrame(qquser,recivedMessage.getFrom() , in, out);
						
						if(recivedMessage.getType().equals("shakeMessage"))
						{
							c.setVisible(true);
							c.shakeWindow();
						}else
						{System.out.println("22222222");
							c.getTextArea().append(recivedMessage.getFrom().getNickname()+"  :  "+recivedMessage.getTime()+"\t\t\r\n"+recivedMessage.getContent()+"\r\n\r\n");
							c.setVisible(true);
						}
						allFrames.put(recivedMessage.getFrom().getName(), c);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

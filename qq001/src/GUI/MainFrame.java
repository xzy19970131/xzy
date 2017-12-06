package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
//		for(String groupName:allGroupNames) {
//			DefaultMutableTreeNode  group=new DefaultMutableTreeNode(groupName);//构造出每个组名的对应的TreeNode对象
//			HashSet<qqUser>  friendsOfGroup=allFriends.get(groupName);
//			for(qqUser u:friendsOfGroup) {
//				DefaultMutableTreeNode  friend=new DefaultMutableTreeNode(u.getNickname()+"["+u.getName()+"]");
//				
//				group.add(friend);
//			}
//			
//			root.add(group);
//		}
 		
		
//		
//		friendTree = new JTree(root);
//		friendTree.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if(e.getButton()==1&&e.getClickCount()==2) {
//					TreePath  path=friendTree.getSelectionPath();
//					DefaultMutableTreeNode lastNode=(DefaultMutableTreeNode)path.getLastPathComponent();
//					if(lastNode.isLeaf()) {
//						//上面是解析用户双击之后判断是不是双击的某一个用户名上的这个Node
//						String qqusename=lastNode.toString();
//						String num=qqusename.substring(qqusename.lastIndexOf("[")+1,qqusename.length()-1);
//						//
//						qqUser your=new qqUser();
//								your.setName(num);
//						for(String firendNum:allFrames.keySet())
//						{
//							if(firendNum.equals(num))
//							{
//								allFrames.get(firendNum).setVisible(true);
//								return;
//							}
//						}
//						ChatFrame   chat=new ChatFrame(MainFrame.this.qquser,your,MainFrame.this.in,MainFrame.this.out);
//						chat.setVisible(true);
//				allFrames.put(num, chat);
//					}
//				}
//			}
//		});
//		friendTree.setRootVisible(false);
//
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setBounds(0, 143, 246, 395);
//		contentPane.add(tabbedPane);
//		
//		JPanel panel_1 = new JPanel();
//		tabbedPane.addTab("好友", null, panel_1, null);
//		panel_1.setLayout(null);
//		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(0, 0, 241, 366);
//		panel_1.add(scrollPane_1);
//		
//		JTree tree = new JTree();
//		tree.setRootVisible(false);
//		scrollPane_1.setColumnHeaderView(tree);
//		
//		JPanel panel_2 = new JPanel();
//		tabbedPane.addTab("群聊", null, panel_2, null);
//		panel_2.setLayout(null);
//		
//		JScrollPane scrollPane_2 = new JScrollPane();
//		scrollPane_2.setBounds(0, 0, 241, 366);
//		panel_2.add(scrollPane_2);
//		
//		JPanel panel_3 = new JPanel();
//		tabbedPane.addTab("最近联系人", null, panel_3, null);
//		panel_3.setLayout(null);
//		
//		JScrollPane scrollPane_3 = new JScrollPane();
//		scrollPane_3.setBounds(0, 0, 241, 366);
//		panel_3.add(scrollPane_3);
		
	}
}

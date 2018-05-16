import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class jiemian {
	String name,sex;
	int xuehao;
	int age;
    protected static void chushi(LinkedList LinkLine) {
    	LinkLine.add(new Student("张三",2015117114,"男",23));
		LinkLine.add(new Student("李四",2015117126,"男",24));
		LinkLine.add(new Student("王五",2015117115,"女",27));
		LinkLine.add(new Student("丽丽",2015117118,"男",29));
    } 	
	protected void command(LinkedList LinkLine) {
		while(true) {
			background(LinkLine);
			Scanner sc = new Scanner(System.in);
			int command = sc.nextInt();
			switch(command) {
			case 1:seeStu(LinkLine);
			break;
			case 2:addStu(LinkLine);
			break;
			case 3:reviseStu(LinkLine);
			break;
			case 4:deleteStu(LinkLine);
			break;
			case 5:quitSystem();
			break;
			default :
			System.out.println("选择的功能有误，请重新输入");
			}
		}
		
	}
	protected  void background(LinkedList LinkLine) {
		System.out.println("----------欢迎使用湖文学生管理系统----------");
		System.out.println("1.查看学生信息");
		System.out.println("2.添加学生信息");
		System.out.println("3.修改学生信息");
		System.out.println("4.删除学生信息");
		System.out.println("5.退出系统");
		System.out.print("请输入指令：");
	}
	protected static void seeStu(LinkedList LinkLine) {
		
		System.out.println(LinkLine);
		}
	
	protected void addStu(LinkedList LinkLine) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入要添加的学生姓名：");
		String name = new Scanner(System.in).nextLine();
		System.out.print("请输入要添加的学生学号：");
		int xuehao = sc.nextInt();
		System.out.print("请输入要添加的学生性别：");
		String sex = new Scanner(System.in).nextLine();
		System.out.print("请输入要添加的学生年龄：");
		int  age =sc.nextInt();
		Student s = new Student(name,xuehao,sex, age);
		LinkLine.add(s);
		System.out.println(name+"的信息已添加");
		System.out.println(LinkLine);
	}
	protected static int find(LinkedList LinkLine,String Name) {
		int position = 0;
		Iterator it = LinkLine.iterator();
		while(true)
		{
			if(it.hasNext()){
			Student stu =  (Student) it.next();
			if(!stu.name.equals(Name))position++;
			else break;}
			else{position=-1;break;}
		}
	//	int position = LinkLine.indexOf(Name);
		return position ;
	}
	
	protected static void reviseStu(LinkedList LinkLine) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入要修改信息的学生名字：");
		String Name = new Scanner(System.in).nextLine();
		int position = find(LinkLine,Name);
	//	int position = LinkLine.indexOf(Name);
		if(position == -1) {
			System.out.println("输入的学生不在列表中，请重新输入：");
		}else {
			Student stu = (Student) LinkLine.get(position);
			System.out.println("1.修改姓名");
			System.out.println("2.修改学号");
			System.out.println("3.修改性别");
			System.out.println("4.修改年龄");
			
			int s = sc.nextInt();
			switch(s)
			{
			case 1:{
						System.out.println("请输入更改后姓名：");
						stu.name=sc.next();
					}
			case 2:{
				System.out.println("请输入更改后学号：");
				stu.xuehao=sc.nextInt();
			}
			case 3:{
				System.out.println("请输入更改后性别：");
				stu.sex=sc.next();
			}
			case 4:{
				System.out.println("请输入更改后年龄：");
				stu.age=sc.nextInt();
			}
			
			}
			System.out.println("修改成功！");
			System.out.println(stu);
		
			}
			
		}
	protected static void deleteStu(LinkedList LinkLine) {
		System.out.println("请输入要删除的学生名字：");
		String Name = new Scanner(System.in).nextLine();
		int position = find(LinkLine,Name);
		if(position == -1) {
			System.out.println("输入的学生不在列表中，请重新输入：");
		}else {
			Student stu = (Student) LinkLine.get(position);
			   System.out.println(stu.name+"的信息已删除");
			    LinkLine.remove(position);
			 
		}
		
	}
	
	protected static void quitSystem() {
		System.out.println("----------您已退出湖文学生管理系统----------");
		System.out.println("再见！");
		System.exit(0);
	}

}

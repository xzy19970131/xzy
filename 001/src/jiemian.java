import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class jiemian {
	String name,sex;
	int xuehao;
	int age;
    protected static void chushi(LinkedList LinkLine) {
    	LinkLine.add(new Student("����",2015117114,"��",23));
		LinkLine.add(new Student("����",2015117126,"��",24));
		LinkLine.add(new Student("����",2015117115,"Ů",27));
		LinkLine.add(new Student("����",2015117118,"��",29));
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
			System.out.println("ѡ��Ĺ�����������������");
			}
		}
		
	}
	protected  void background(LinkedList LinkLine) {
		System.out.println("----------��ӭʹ�ú���ѧ������ϵͳ----------");
		System.out.println("1.�鿴ѧ����Ϣ");
		System.out.println("2.���ѧ����Ϣ");
		System.out.println("3.�޸�ѧ����Ϣ");
		System.out.println("4.ɾ��ѧ����Ϣ");
		System.out.println("5.�˳�ϵͳ");
		System.out.print("������ָ�");
	}
	protected static void seeStu(LinkedList LinkLine) {
		
		System.out.println(LinkLine);
		}
	
	protected void addStu(LinkedList LinkLine) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������Ҫ��ӵ�ѧ��������");
		String name = new Scanner(System.in).nextLine();
		System.out.print("������Ҫ��ӵ�ѧ��ѧ�ţ�");
		int xuehao = sc.nextInt();
		System.out.print("������Ҫ��ӵ�ѧ���Ա�");
		String sex = new Scanner(System.in).nextLine();
		System.out.print("������Ҫ��ӵ�ѧ�����䣺");
		int  age =sc.nextInt();
		Student s = new Student(name,xuehao,sex, age);
		LinkLine.add(s);
		System.out.println(name+"����Ϣ�����");
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
		System.out.print("������Ҫ�޸���Ϣ��ѧ�����֣�");
		String Name = new Scanner(System.in).nextLine();
		int position = find(LinkLine,Name);
	//	int position = LinkLine.indexOf(Name);
		if(position == -1) {
			System.out.println("�����ѧ�������б��У����������룺");
		}else {
			Student stu = (Student) LinkLine.get(position);
			System.out.println("1.�޸�����");
			System.out.println("2.�޸�ѧ��");
			System.out.println("3.�޸��Ա�");
			System.out.println("4.�޸�����");
			
			int s = sc.nextInt();
			switch(s)
			{
			case 1:{
						System.out.println("��������ĺ�������");
						stu.name=sc.next();
					}
			case 2:{
				System.out.println("��������ĺ�ѧ�ţ�");
				stu.xuehao=sc.nextInt();
			}
			case 3:{
				System.out.println("��������ĺ��Ա�");
				stu.sex=sc.next();
			}
			case 4:{
				System.out.println("��������ĺ����䣺");
				stu.age=sc.nextInt();
			}
			
			}
			System.out.println("�޸ĳɹ���");
			System.out.println(stu);
		
			}
			
		}
	protected static void deleteStu(LinkedList LinkLine) {
		System.out.println("������Ҫɾ����ѧ�����֣�");
		String Name = new Scanner(System.in).nextLine();
		int position = find(LinkLine,Name);
		if(position == -1) {
			System.out.println("�����ѧ�������б��У����������룺");
		}else {
			Student stu = (Student) LinkLine.get(position);
			   System.out.println(stu.name+"����Ϣ��ɾ��");
			    LinkLine.remove(position);
			 
		}
		
	}
	
	protected static void quitSystem() {
		System.out.println("----------�����˳�����ѧ������ϵͳ----------");
		System.out.println("�ټ���");
		System.exit(0);
	}

}

package peixunban;
import java.util.Scanner;
public class smms_Demo {
	public static Scanner sc=new Scanner(System.in);
	/**
	 * Scanner函数获取键盘输入的数据
	 */
	static  int  count=1;//定义变量控制用户登录次数
	//定义三个数组用于模拟数据库，存储商品名称，商品数量，商品价格，实现数据共享
	public  static String[] productName=new String[20];
	public  static    int[] productNo=new  int[20];
	public  static  float[] productPrice=new float[20];
	public static int newProductIndex=0;
	//定义一个整形变量，让他来确定新的商品该添加到数组的哪一位上
	static{
		productName[0]="小米手机3";
		productNo[0]=100;
		productPrice[0]=1988f;
		
		productName[1]="小米盒子";
		productNo[1]=125;
		productPrice[1]=498f;
		
		productName[2]="小米手环";
		productNo[2]=27;
		productPrice[2]=289f;
		
		productName[3]="小米充电宝";
		productNo[3]=58;
		productPrice[3]=60f;
		newProductIndex=4;
	}
	/**
	 * @param args
	 */
	public static void showWelcome(){
		//这是显示欢迎界面的函数
		System.out.println("\t\t\t\t欢迎使用家乐福超市管理系统");
		System.out.println("\t\t\t\t-------------------------");
		System.out.println("\t\t\t\t-----------V1.0----------");
		System.out.println("\t\t\t\t-------------------------");
		System.out.println("--------用户登录----------");
		processlogin();
	}
	public static void processlogin(){
		//这里是用户登陆函数
	
		System.out.println("请输入用户名：");
		String  username=new Scanner(System.in).nextLine();
		System.out.println("请输入密码：");
		String  password=new Scanner(System.in).nextLine();
	
		if(username.contentEquals("Admin")&&password.contentEquals("123456"))
		{
			System.out.println("登陆成功！");
			showMainMenu();
		}
		else{
			
			
			if(count >=3){
				System.out.println("对不起！亲，您已经没有机会了！");
				return;
			}else{
				count++;
				System.out.println("对不起，你输入的用户名或密码错误！请重新输入！");
				processlogin();
			}
			
		}
}
	public static void showMainMenu(){
		System.out.println("---主菜单---");
		System.out.println("1.用户管理");
		System.out.println("2.商品管理");
		System.out.println("3.结账管理");
		System.out.println("4.退出系统");
		System.out.println("请选择相应的菜单编号:");
		int menuNo = new Scanner(System.in).nextInt();
		switch (menuNo) {
		case 1:
			System.out.println("用户管理菜单");
			userMannagement();
			break;
		case 2:{
			System.out.println("商品管理菜单");
			showMenuOfProductManagement();
			break; 
		}
			
		case 3:{
			System.out.println("结账管理菜单");
			showMenuOfPayManagement();
			break;
		}
		case 4:{ 
			System.out.println("退出系统菜单");
			exitSystem();
			break;
			}
		default: {
			System.err.println("请重新输入正确的选项编号：");
			showMainMenu();
			}
      }
}
	public static void userMannagement(){
		System.out.println("1.创建用户");
		System.out.println("2.查看用户");
		System.out.println("3.修改用户");
		System.out.println("4.删除用户");
		System.out.println("5.返回主菜单");
		System.out.println("请选择菜单编号:");
		
		/**
		 * 2.读取用户输入的编号
		 */
		int yourChoiceNo1 =  new Scanner(System.in).nextInt();
		/**
		 * 3.判断输入的编号，执行相应的功能
		 */
		switch (yourChoiceNo1) {
		case 1: {
			addUser();
			break;
		}
		case 2: {
			showUser();
			break;
		}
		case 3: {
		updateUser();
			break;
		}
		case 4: {
			deleteUser();
			break;
		}
		case 5: {
			showMainMenu();
			break;
		}
		default: {
			System.err.println("请输入正确的选项编号：");
			userMannagement();
			break;
		}
}
	}
	
		public static void showMenuOfProductManagement(){
			// System.out.println("这是商品管理函数");
			/**
			 * 1.提示用户可操作的菜单选项
			 */
			System.out.println("1.添加商品");
			System.out.println("2.查看商品");
			System.out.println("3.修改商品");
			System.out.println("4.删除商品");
			System.out.println("5.返回主菜单");
			System.out.println("请选择菜单编号:");
			/**
			 * 2.读取用户输入的编号
			 */
			int yourChoiceNo2 = new Scanner(System.in).nextInt();
			/**
			 * 3.判断输入的编号，执行相应的功能
			 */
			switch (yourChoiceNo2) {
			case 1: {
				addProduct();
				break;
			}
			case 2: {
				showProduct();
				showMenuOfProductManagement();
				break;
			}
			case 3: {
				updateProduct();
				break;
			}
			case 4: {
				deleteProduct();
				break;
			}
			case 5: {
				showMainMenu();
				break;
			}
			default: {
				System.err.println("请输入正确的选项编号：");
				showMenuOfProductManagement();
				break;
			}
	}
}
		public static void showMenuOfPayManagement(){
			System.out.println("1.添加");
			System.out.println("2.修改");
			System.out.println("3.删除");
			System.out.println("4.返回主菜单");
			System.out.println("请选择菜单编号:");
			int  yourchoice3=0;
			try {
				yourchoice3= new Scanner(System.in).nextInt();//读取用户输入的编号
			} catch (Exception e) {
				System.out.println("请输入正确的编号:");
				yourchoice3= new Scanner(System.in).nextInt();
			}
			
			switch (yourchoice3) {
			case 1:{
				PayProduct();
				break;
				}
			case 2:{
				System.out.println("2.修改");
				break;
				}
			case 3:{
				System.out.println("3.删除");
				break;
				}
			default:{
				System.err.println("请输入正确的选项编号：");
				showMenuOfPayManagement();
				break;
				}
			}
			
		}
		
		public static void exitSystem(){
			System.err.println("是否要退出系统（是（Y）/ 否（N））？");
			String S = new Scanner(System.in).nextLine();
			if(S.contentEquals("Y"))showWelcome();
			else showMainMenu();}
			public static void addProduct(){//添加商品信息函数addProduct
				//提醒用户输入商品相关信息
					
					System.out.println("请输入商品名称：");
					String newProductName=new Scanner(System.in).nextLine();
					System.out.println("请输入商品数量：");
					int newProductNo= new Scanner(System.in).nextInt();                        
					System.out.println("请输入商品价格：");
				    Float newProductPrice=sc.nextFloat();
				    /**
				     * 将用户输入的商品信息添加到相应数组中
				     */
				    /**
					 * 无论如何用户都要执行添加新商品，所以上面的代码可以先做
					 * 获取用户要添加的心的商品的信息
					 * 获取完之后，为了保证信息一定能被存储，
					 * 则我们需要判断数组是否已满，
					 * 若满，则扩充
					 */
					if(newProductIndex>=productName.length)
					{
						String[] newProductNames=new String[productName.length+1];
						System.arraycopy(productName, 0, newProductNames, 0, productName.length);
						productName=newProductNames;
						int[] newProductCounts=new int[productNo.length+1];
						System.arraycopy(productNo, 0, newProductCounts, 0, productNo.length);
						productNo=newProductCounts;
						
						float[] newProductPrices=new float[productPrice.length+1];
						System.arraycopy(productPrice, 0, newProductPrices, 0, productPrice.length);
						productPrice=newProductPrices;
					}
					
				    productName[newProductIndex]=newProductName;
					productNo[newProductIndex]=newProductNo;
					productPrice[newProductIndex]=newProductPrice;
					newProductIndex++; //存储位置我们用一个额外的下标变量来控制
					System.out.println("已添加成功！\n");
					System.out.println("亲，您还想继续添加吗？继续请按Y；否则请按N，返回上一级菜单！");
					String yourChoice=new Scanner(System.in).nextLine();
					if(yourChoice.contentEquals("y")){
						addProduct();
					}else{
						showMenuOfProductManagement();
					}
				}
				public static void showProduct(){

					System.out.println("------------商品一览表-------------");          
					System.out.println("商品编号"+"\t\t\t商品名称 "+"\t\t\t商品数量 "+"\t\t\t商品价格 ");
			       for (int i = 0; i < newProductIndex; i++) {
			    	   System.out.println(i+1+"\t\t\t"+productName[i]+"\t\t\t"+productNo[i]+"\t\t\t"+productPrice[i]);	
				}
			
				}
				
				public static void updateProduct(){
					/**
					 * 1.显示所有商品信息，供操作人员查看
					 */
					showProduct();
					
					/**
					 *2. 定义一个变量，获取要修改商品的编号
					 */
					System.out.print("请输入要修改的商品编号:");
					int  updateproductNo=  new Scanner(System.in).nextInt();
					
					
					/**
					 *3. 提示用户输入要修改的编号对应商品信息，并保存
					 */
					System.out.println("请输入修改后的商品名称");
					String  newProductName= new Scanner(System.in).nextLine();
					System.out.println("请输入修改后的商品数量");	
					int    newProductNo= new Scanner(System.in).nextInt();
					System.out.println("请输入修改后的商品价格");	
					float   newProductPrice=sc.nextFloat();
					productName[updateproductNo-1]=newProductName;
					productNo[updateproductNo-1]=newProductNo;
					productPrice[updateproductNo-1]=newProductPrice;
					System.out.println("已修改成功！");
					/**
					 * 4.修改成功后返回选择菜单
					 */
					showMenuOfProductManagement();
				}
				public static void deleteProduct(){
					/**
					 * 1.显示所有商品信息
					 */
					 showProduct();
					/**
					 * 2.获取要删除的商品编号
					 */
					 System.out.println("请输入要删除的商品编号：");
					int deleteproductNo= new Scanner(System.in).nextInt();
					/**
					 * 3.提示用户输入要删除的商品编号
					 */
				
					    productName[deleteproductNo-1]="";
						productNo[deleteproductNo-1]=0;
						productPrice[deleteproductNo-1]=0;
					
						for(int i=deleteproductNo;i<newProductIndex;i++){
							
								productName[i-1]=productName[i];
								productNo[i-1]=productNo[i];
								productPrice[i-1]=productPrice[i];
								
							}
						      newProductIndex--;
				
							showProduct();
							
						
						System.out.println("已删除成功！");
						/**
						 * 4.删除成功后返回选择菜单
						 */
						showMenuOfProductManagement();
				}
				public static void PayProduct(){
					System.out.println("请输入结账商品的编号：");
					int yourChoiceNo31=  new Scanner(System.in).nextInt();
					System.out.println("结账商品如下：");
					System.out.println(yourChoiceNo31+"\t\t\t"+productName[yourChoiceNo31-1]+"\t\t\t"+productNo[yourChoiceNo31-1]+"\t\t\t"+productPrice[yourChoiceNo31-1]);
					
					
						System.out.println("结账金额为："+productPrice[yourChoiceNo31-1]);
					
						showMenuOfProductManagement();//结账成功后返回上级菜单
					}
					
				public static void addUser(){
					System.out.println("创建用户");
				}
				public static void showUser(){
					System.out.println("查看用户");
				}
				public static void updateUser(){
					System.out.println("修改用户");
				}
				public static void deleteUser(){
					System.out.println("删除用户");
				}
				
				
				
			public static void main(String[] args) {
				/**
				 * 程序的入口
				 */
				showWelcome();
				
			

			}
			}




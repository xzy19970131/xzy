package peixunban;

import java.util.Scanner;

public class SuperMarket {                   
	public  static String[] productName=new String[20];
	public  static    int[] productNumber=new  int[20];
	public  static  float[] productPrice=new float[20];
	
	public  static String[] payName=new String[20];
	public  static    int[] payNumber=new  int[20];
	public  static  float[] payPrice=new float[20];
	public  static  float[] payPriceSum = new float[20];
	static int payIndex = 0;
	static int newProductIndex = 0;
	static float SUM = 0;
	
	static int count = 1;// 定义变量控制用户登录次数
	static{
		productName[0]="中性笔";
		productNumber[0]=100;
		productPrice[0]=2f;
		
		productName[1]="卫龙";
		productNumber[1]=120;
		productPrice[1]=1f;
		
		productName[2]="果冻";
		productNumber[2]=50;
		productPrice[2]=5f;
		
		productName[3]="小浣熊";
		productNumber[3]=70;
		productPrice[3]=1f;
		newProductIndex=4;
	}
	
	
	static void Expend(String[] productName) {
		String[] newProductNames = new String[productName.length+5];
		System.arraycopy(productName, 0, newProductNames, 0, productName.length);
		productName = newProductNames;
	}
	static void Expend(int[] productNumber) {      	//数组扩展重载1
		int[] newProductCounts = new int[productNumber.length + 5];
		System.arraycopy(productNumber, 0, newProductCounts, 0, productNumber.length);
		productNumber = newProductCounts;

	}
	static void Expend(float[]  productPrice) {    	//数组扩展重载2
		float[] newProductPrices = new float[productPrice.length + 5];
		System.arraycopy(productPrice, 0, newProductPrices, 0, productPrice.length);
		productPrice = newProductPrices;
	}
	public static void showWelcome() {				//数组扩展重载3
		// 这是显示欢迎界面的函数
		System.out.println("**************欢迎使用爽歪歪超市管理系统**************");
		System.out.println("**                                               **");
		System.out.println("**                                               **");
		System.out.println("**                                               **");
		System.out.println("***************       用户登录                **************");
		dengLu();
	}

	private static void dengLu() {    				//登陆界面
		// 这里是用户登陆函数
		System.out.println("请输入用户名：");
		String USER_NAME = new Scanner(System.in).nextLine();
		System.out.println("请输入密码：");
		String PASSWORD = new Scanner(System.in).nextLine();
		if (USER_NAME.contentEquals("xzy") && PASSWORD.contentEquals("123456")) {
			System.out.println("登陆成功！");
			showMainMenu();
		} else {
			if (count >= 3) {
				System.out.println("您已输错三次，该账户已锁定！");
				return;
			} else {
				count++;
				System.out.println("输入的用户名或密码错误！请重新输入！");
				dengLu();
			}

		}

	}

	private static void showMainMenu() {    		//主菜单
		System.out.println("*****************主菜单*****************");
		System.out.println("**1.商品管理                                                     **");
		System.out.println("**2.结账管理                                                     **");
		System.out.println("**3.退出系统                                                     **");
		System.out.println("**请选择相应的菜单编号:                 **");
		int menuNo = new Scanner(System.in).nextInt();
		switch (menuNo) {
		case 1:
			System.out.println("商品管理菜单");
			showMenuOfProductManagement();
			break;
		case 2: {
			System.out.println("结账管理菜单");
			showMenuOfPayManagement();
			break;
		}

		case 3: {
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

	public static void showMenuOfPayManagement() {    //结账菜单  
		System.out.println("*****************账户管理菜单*****************");
		System.out.println("**1.添加结账信息                                                        **");
		System.out.println("**2.查看结账信息                                                        **");		
		System.out.println("**3.返回主菜单                                                           **");
		System.out.println("请选择菜单编号:");
		int yourchoice3 = 0;
		try {
			yourchoice3 = new Scanner(System.in).nextInt();// 读取用户输入的编号
		} catch (Exception e) {
			System.out.println("请输入正确的编号:");
			yourchoice3 = new Scanner(System.in).nextInt();
		}

		switch (yourchoice3) {
		case 1: {
			addPay();
			break;
		}
		case 2: {
			showPay();
			break;
		}
		case 3: {
			showMainMenu();
			break;
		}
		default: {
			System.err.println("请输入正确的选项编号：");
			showMenuOfPayManagement();
			break;
		}
		}

	}

	private static void showPay() {
		System.out.println("**********************************爽歪歪超市账单*******************************");
		System.out.println("   "+"编号"+"\t\t\t"+"商品名 "+"\t\t\t"+"销售量"+"\t\t\t"+"单价");	
		for (int i = 0; i < payIndex; i++) {
			System.out.println("   "+(i+1)+"\t\t\t"+payName[i]+"\t\t\t"+payNumber[i]+"\t\t\t"+payPrice[i]);	
			
		}	
		System.out.println("总计消费："+SUM+"元~");
		System.out.println("返回上一级菜单（N/n）");
		String choice4 = new Scanner(System.in).nextLine();
		if(choice4.equalsIgnoreCase("n"))showMenuOfPayManagement();
		
	}
	private static void addPay() {
		showProduct();
		System.out.println("请输入所需结账商品编号：");
		int i = new Scanner(System.in).nextInt();
		System.out.println("您将购买以下商品：");
		System.out.println("   "+(i)+"\t\t\t"+productName[i-1]+"\t\t\t"+productNumber[i-1]+"\t\t\t"+productPrice[i-1]);	
		System.out.println("请输入购买数量：");
		int n = new Scanner(System.in).nextInt();
		System.out.println("您购买数量为："+n);
		System.out.println("确认购买请按（Y/y），取消请按（N/n）");
		String choice = new Scanner(System.in).nextLine();
		if(choice.equalsIgnoreCase("y")) {
			System.out.println("购买成功~");
		
			payName[payIndex]=productName[i-1];
			payNumber[payIndex]=n;
			payPrice[payIndex]=productPrice[i-1];
			payPriceSum [payIndex]=n*productPrice[i-1];
			SUM=SUM+productPrice[i-1]*n;
			payIndex++;
			System.out.println("继续购买（Y/y）              退出购买（N/n）");
			String choice2 = new Scanner(System.in).nextLine();
			if(choice2.equalsIgnoreCase("y")) {addPay();}
			else {
				showMenuOfPayManagement();
			}
		}
		else {
			System.out.println("购买失败~");
			System.out.println("继续购买（Y/y）              退出购买（N/n）");
			String choice3 = new Scanner(System.in).nextLine();
			if(choice.equalsIgnoreCase("y")) {
				System.out.println("购买成功~");
				System.out.println("继续购买（Y/y）              退出购买（N/n）");
				String choice2 = new Scanner(System.in).nextLine();
				if(choice2.equalsIgnoreCase("y")) {addPay();}
				else {
					showMenuOfPayManagement();
				}
			}
		}
	}
	
	public static void showMenuOfProductManagement() {   //商品管理菜单
		// System.out.println("这是商品管理函数");
		/**
		 * 1.提示用户可操作的菜单选项
		 */
		System.out.println("1.添加商品");
		System.out.println("2.查看商品");
		System.out.println("3.修改商品");
		System.out.println("4.删除商品");
		System.out.println("5.查找商品");
		System.out.println("6.返回主菜单");
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
			findProduct();
			break;
		}
		case 6: {
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

	/*private static void findProduct() {
	System.out.println("请输入商品名字，不确定的可用   * 代替 ");
	String findname = new Scanner(System.in).nextLine();
		char find[] = new char[findname.length()];
		int j=0;
		for (int i = 0; i < find.length; i++) {
			if(findname.charAt(i)!='*')
			{find[j]=findname.charAt(i);j++;}
		}
		for (int i = 0; i < productName.length; i++) {
			for (int k = 0; k < productName[i].length(); k++) {
				for()
			}
		}
		productName
	}*/
	public static void deleteProduct(){        			//删除商品   
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
		productNumber[deleteproductNo-1]=0;
		productPrice[deleteproductNo-1]=0;
		for(int i=deleteproductNo;i<newProductIndex;i++){
				productName[i-1]=productName[i];
				productNumber[i-1]=productNumber[i];
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
	public static void updateProduct(){   				//修改商品信息
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
		float   newProductPrice=new Scanner(System.in).nextFloat();
		productName[updateproductNo-1]=newProductName;
		productNumber[updateproductNo-1]=newProductNo;
		productPrice[updateproductNo-1]=newProductPrice;
		System.out.println("已修改成功！");
		/**
		 * 4.修改成功后返回选择菜单
		 */
		showMenuOfProductManagement();
	}
	public static void addProduct() {// 添加商品信息函数addProduct
		// 提醒用户输入商品相关信息
		System.out.println("请输入商品名称：");
		String newProductName = new Scanner(System.in).nextLine();
		System.out.println("请输入商品数量：");
		int newProductNumber = new Scanner(System.in).nextInt();
		System.out.println("请输入商品价格：");
		Float newProductPrice = new Scanner(System.in).nextFloat();
		/**
		 * 将用户输入的商品信息添加到相应数组中
		 */
		/**
		 * 无论如何用户都要执行添加新商品，所以上面的代码可以先做 获取用户要添加的心的商品的信息 获取完之后，为了保证信息一定能被存储，
		 * 则我们需要判断数组是否已满， 若满，则扩充
		 */
		if (newProductIndex >= productName.length) {
			Expend(productName);
			Expend(productNumber);
			Expend(productPrice);
		}

	
		System.out.println("确认添加请按Y/y；放弃添加请按N/n");
		String yourChoice = new Scanner(System.in).nextLine();
		if (yourChoice.equalsIgnoreCase("yes")) {
			productName[newProductIndex] = newProductName;
			productNumber[newProductIndex] = newProductNumber;
			productPrice[newProductIndex] = newProductPrice;
			newProductIndex++; // 存储位置我们用一个额外的下标变量来控制
			System.out.println("商品添加成功~");
			showProduct();
			showMenuOfProductManagement();
		} else {
			System.err.println("商品添加失败!");
			showMenuOfProductManagement();
		}
	}
	public static void showProduct(){

		System.out.println("*******************************爽歪歪超市商品价格*******************************");          
		System.out.println("商品编号"+"\t\t\t商品名称 "+"\t\t\t商品数量 "+"\t\t\t商品价格 ");
       for (int i = 0; i < newProductIndex; i++) {
    	   System.out.println("   "+(i+1)+"\t\t\t"+productName[i]+"\t\t\t"+productNumber[i]+"\t\t\t"+productPrice[i]);	
	}
       System.out.println("******************************************************************************");  

	}

	public static void exitSystem() {
		System.err.println("是否要退出系统（是（Y/y）/ 否（N/n））？");
		String S = new Scanner(System.in).nextLine();
		if (S.equalsIgnoreCase("y"))
			showWelcome();
		else
			showMainMenu();
	}

	public static void main(String[] args) {
		showWelcome();
	}

}

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
	
	static int count = 1;// ������������û���¼����
	static{
		productName[0]="���Ա�";
		productNumber[0]=100;
		productPrice[0]=2f;
		
		productName[1]="����";
		productNumber[1]=120;
		productPrice[1]=1f;
		
		productName[2]="����";
		productNumber[2]=50;
		productPrice[2]=5f;
		
		productName[3]="С���";
		productNumber[3]=70;
		productPrice[3]=1f;
		newProductIndex=4;
	}
	
	
	static void Expend(String[] productName) {
		String[] newProductNames = new String[productName.length+5];
		System.arraycopy(productName, 0, newProductNames, 0, productName.length);
		productName = newProductNames;
	}
	static void Expend(int[] productNumber) {      	//������չ����1
		int[] newProductCounts = new int[productNumber.length + 5];
		System.arraycopy(productNumber, 0, newProductCounts, 0, productNumber.length);
		productNumber = newProductCounts;

	}
	static void Expend(float[]  productPrice) {    	//������չ����2
		float[] newProductPrices = new float[productPrice.length + 5];
		System.arraycopy(productPrice, 0, newProductPrices, 0, productPrice.length);
		productPrice = newProductPrices;
	}
	public static void showWelcome() {				//������չ����3
		// ������ʾ��ӭ����ĺ���
		System.out.println("**************��ӭʹ��ˬ���ᳬ�й���ϵͳ**************");
		System.out.println("**                                               **");
		System.out.println("**                                               **");
		System.out.println("**                                               **");
		System.out.println("***************       �û���¼                **************");
		dengLu();
	}

	private static void dengLu() {    				//��½����
		// �������û���½����
		System.out.println("�������û�����");
		String USER_NAME = new Scanner(System.in).nextLine();
		System.out.println("���������룺");
		String PASSWORD = new Scanner(System.in).nextLine();
		if (USER_NAME.contentEquals("xzy") && PASSWORD.contentEquals("123456")) {
			System.out.println("��½�ɹ���");
			showMainMenu();
		} else {
			if (count >= 3) {
				System.out.println("����������Σ����˻���������");
				return;
			} else {
				count++;
				System.out.println("������û���������������������룡");
				dengLu();
			}

		}

	}

	private static void showMainMenu() {    		//���˵�
		System.out.println("*****************���˵�*****************");
		System.out.println("**1.��Ʒ����                                                     **");
		System.out.println("**2.���˹���                                                     **");
		System.out.println("**3.�˳�ϵͳ                                                     **");
		System.out.println("**��ѡ����Ӧ�Ĳ˵����:                 **");
		int menuNo = new Scanner(System.in).nextInt();
		switch (menuNo) {
		case 1:
			System.out.println("��Ʒ����˵�");
			showMenuOfProductManagement();
			break;
		case 2: {
			System.out.println("���˹���˵�");
			showMenuOfPayManagement();
			break;
		}

		case 3: {
			System.out.println("�˳�ϵͳ�˵�");
			exitSystem();
			break;
		}
		default: {
			System.err.println("������������ȷ��ѡ���ţ�");
			showMainMenu();
		}
		}

	}

	public static void showMenuOfPayManagement() {    //���˲˵�  
		System.out.println("*****************�˻�����˵�*****************");
		System.out.println("**1.��ӽ�����Ϣ                                                        **");
		System.out.println("**2.�鿴������Ϣ                                                        **");		
		System.out.println("**3.�������˵�                                                           **");
		System.out.println("��ѡ��˵����:");
		int yourchoice3 = 0;
		try {
			yourchoice3 = new Scanner(System.in).nextInt();// ��ȡ�û�����ı��
		} catch (Exception e) {
			System.out.println("��������ȷ�ı��:");
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
			System.err.println("��������ȷ��ѡ���ţ�");
			showMenuOfPayManagement();
			break;
		}
		}

	}

	private static void showPay() {
		System.out.println("**********************************ˬ���ᳬ���˵�*******************************");
		System.out.println("   "+"���"+"\t\t\t"+"��Ʒ�� "+"\t\t\t"+"������"+"\t\t\t"+"����");	
		for (int i = 0; i < payIndex; i++) {
			System.out.println("   "+(i+1)+"\t\t\t"+payName[i]+"\t\t\t"+payNumber[i]+"\t\t\t"+payPrice[i]);	
			
		}	
		System.out.println("�ܼ����ѣ�"+SUM+"Ԫ~");
		System.out.println("������һ���˵���N/n��");
		String choice4 = new Scanner(System.in).nextLine();
		if(choice4.equalsIgnoreCase("n"))showMenuOfPayManagement();
		
	}
	private static void addPay() {
		showProduct();
		System.out.println("���������������Ʒ��ţ�");
		int i = new Scanner(System.in).nextInt();
		System.out.println("��������������Ʒ��");
		System.out.println("   "+(i)+"\t\t\t"+productName[i-1]+"\t\t\t"+productNumber[i-1]+"\t\t\t"+productPrice[i-1]);	
		System.out.println("�����빺��������");
		int n = new Scanner(System.in).nextInt();
		System.out.println("����������Ϊ��"+n);
		System.out.println("ȷ�Ϲ����밴��Y/y����ȡ���밴��N/n��");
		String choice = new Scanner(System.in).nextLine();
		if(choice.equalsIgnoreCase("y")) {
			System.out.println("����ɹ�~");
		
			payName[payIndex]=productName[i-1];
			payNumber[payIndex]=n;
			payPrice[payIndex]=productPrice[i-1];
			payPriceSum [payIndex]=n*productPrice[i-1];
			SUM=SUM+productPrice[i-1]*n;
			payIndex++;
			System.out.println("��������Y/y��              �˳�����N/n��");
			String choice2 = new Scanner(System.in).nextLine();
			if(choice2.equalsIgnoreCase("y")) {addPay();}
			else {
				showMenuOfPayManagement();
			}
		}
		else {
			System.out.println("����ʧ��~");
			System.out.println("��������Y/y��              �˳�����N/n��");
			String choice3 = new Scanner(System.in).nextLine();
			if(choice.equalsIgnoreCase("y")) {
				System.out.println("����ɹ�~");
				System.out.println("��������Y/y��              �˳�����N/n��");
				String choice2 = new Scanner(System.in).nextLine();
				if(choice2.equalsIgnoreCase("y")) {addPay();}
				else {
					showMenuOfPayManagement();
				}
			}
		}
	}
	
	public static void showMenuOfProductManagement() {   //��Ʒ����˵�
		// System.out.println("������Ʒ������");
		/**
		 * 1.��ʾ�û��ɲ����Ĳ˵�ѡ��
		 */
		System.out.println("1.�����Ʒ");
		System.out.println("2.�鿴��Ʒ");
		System.out.println("3.�޸���Ʒ");
		System.out.println("4.ɾ����Ʒ");
		System.out.println("5.������Ʒ");
		System.out.println("6.�������˵�");
		System.out.println("��ѡ��˵����:");
		/**
		 * 2.��ȡ�û�����ı��
		 */
		int yourChoiceNo2 = new Scanner(System.in).nextInt();
		/**
		 * 3.�ж�����ı�ţ�ִ����Ӧ�Ĺ���
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
			System.err.println("��������ȷ��ѡ���ţ�");
			showMenuOfProductManagement();
			break;
		}
		}
	}

	/*private static void findProduct() {
	System.out.println("��������Ʒ���֣���ȷ���Ŀ���   * ���� ");
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
	public static void deleteProduct(){        			//ɾ����Ʒ   
		/**
		 * 1.��ʾ������Ʒ��Ϣ
		 */
		 showProduct();
		/**
		 * 2.��ȡҪɾ������Ʒ���
		 */
		 System.out.println("������Ҫɾ������Ʒ��ţ�");
		int deleteproductNo= new Scanner(System.in).nextInt();
		/**
		 * 3.��ʾ�û�����Ҫɾ������Ʒ���
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
		System.out.println("��ɾ���ɹ���");
		/**
		 * 4.ɾ���ɹ��󷵻�ѡ��˵�
		 */
		showMenuOfProductManagement();
	}
	public static void updateProduct(){   				//�޸���Ʒ��Ϣ
		/**
		 * 1.��ʾ������Ʒ��Ϣ����������Ա�鿴
		 */
		showProduct();
		
		/**
		 *2. ����һ����������ȡҪ�޸���Ʒ�ı��
		 */
		System.out.print("������Ҫ�޸ĵ���Ʒ���:");
		int  updateproductNo=  new Scanner(System.in).nextInt();
		
		
		/**
		 *3. ��ʾ�û�����Ҫ�޸ĵı�Ŷ�Ӧ��Ʒ��Ϣ��������
		 */
		System.out.println("�������޸ĺ����Ʒ����");
		String  newProductName= new Scanner(System.in).nextLine();
		System.out.println("�������޸ĺ����Ʒ����");	
		int    newProductNo= new Scanner(System.in).nextInt();
		System.out.println("�������޸ĺ����Ʒ�۸�");	
		float   newProductPrice=new Scanner(System.in).nextFloat();
		productName[updateproductNo-1]=newProductName;
		productNumber[updateproductNo-1]=newProductNo;
		productPrice[updateproductNo-1]=newProductPrice;
		System.out.println("���޸ĳɹ���");
		/**
		 * 4.�޸ĳɹ��󷵻�ѡ��˵�
		 */
		showMenuOfProductManagement();
	}
	public static void addProduct() {// �����Ʒ��Ϣ����addProduct
		// �����û�������Ʒ�����Ϣ
		System.out.println("��������Ʒ���ƣ�");
		String newProductName = new Scanner(System.in).nextLine();
		System.out.println("��������Ʒ������");
		int newProductNumber = new Scanner(System.in).nextInt();
		System.out.println("��������Ʒ�۸�");
		Float newProductPrice = new Scanner(System.in).nextFloat();
		/**
		 * ���û��������Ʒ��Ϣ��ӵ���Ӧ������
		 */
		/**
		 * ��������û���Ҫִ���������Ʒ����������Ĵ���������� ��ȡ�û�Ҫ��ӵ��ĵ���Ʒ����Ϣ ��ȡ��֮��Ϊ�˱�֤��Ϣһ���ܱ��洢��
		 * ��������Ҫ�ж������Ƿ������� ������������
		 */
		if (newProductIndex >= productName.length) {
			Expend(productName);
			Expend(productNumber);
			Expend(productPrice);
		}

	
		System.out.println("ȷ������밴Y/y����������밴N/n");
		String yourChoice = new Scanner(System.in).nextLine();
		if (yourChoice.equalsIgnoreCase("yes")) {
			productName[newProductIndex] = newProductName;
			productNumber[newProductIndex] = newProductNumber;
			productPrice[newProductIndex] = newProductPrice;
			newProductIndex++; // �洢λ��������һ��������±����������
			System.out.println("��Ʒ��ӳɹ�~");
			showProduct();
			showMenuOfProductManagement();
		} else {
			System.err.println("��Ʒ���ʧ��!");
			showMenuOfProductManagement();
		}
	}
	public static void showProduct(){

		System.out.println("*******************************ˬ���ᳬ����Ʒ�۸�*******************************");          
		System.out.println("��Ʒ���"+"\t\t\t��Ʒ���� "+"\t\t\t��Ʒ���� "+"\t\t\t��Ʒ�۸� ");
       for (int i = 0; i < newProductIndex; i++) {
    	   System.out.println("   "+(i+1)+"\t\t\t"+productName[i]+"\t\t\t"+productNumber[i]+"\t\t\t"+productPrice[i]);	
	}
       System.out.println("******************************************************************************");  

	}

	public static void exitSystem() {
		System.err.println("�Ƿ�Ҫ�˳�ϵͳ���ǣ�Y/y��/ ��N/n������");
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

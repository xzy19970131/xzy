package peixunban;
import java.util.Scanner;
public class smms_Demo {
	public static Scanner sc=new Scanner(System.in);
	/**
	 * Scanner������ȡ�������������
	 */
	static  int  count=1;//������������û���¼����
	//����������������ģ�����ݿ⣬�洢��Ʒ���ƣ���Ʒ��������Ʒ�۸�ʵ�����ݹ���
	public  static String[] productName=new String[20];
	public  static    int[] productNo=new  int[20];
	public  static  float[] productPrice=new float[20];
	public static int newProductIndex=0;
	//����һ�����α�����������ȷ���µ���Ʒ����ӵ��������һλ��
	static{
		productName[0]="С���ֻ�3";
		productNo[0]=100;
		productPrice[0]=1988f;
		
		productName[1]="С�׺���";
		productNo[1]=125;
		productPrice[1]=498f;
		
		productName[2]="С���ֻ�";
		productNo[2]=27;
		productPrice[2]=289f;
		
		productName[3]="С�׳�籦";
		productNo[3]=58;
		productPrice[3]=60f;
		newProductIndex=4;
	}
	/**
	 * @param args
	 */
	public static void showWelcome(){
		//������ʾ��ӭ����ĺ���
		System.out.println("\t\t\t\t��ӭʹ�ü��ָ����й���ϵͳ");
		System.out.println("\t\t\t\t-------------------------");
		System.out.println("\t\t\t\t-----------V1.0----------");
		System.out.println("\t\t\t\t-------------------------");
		System.out.println("--------�û���¼----------");
		processlogin();
	}
	public static void processlogin(){
		//�������û���½����
	
		System.out.println("�������û�����");
		String  username=new Scanner(System.in).nextLine();
		System.out.println("���������룺");
		String  password=new Scanner(System.in).nextLine();
	
		if(username.contentEquals("Admin")&&password.contentEquals("123456"))
		{
			System.out.println("��½�ɹ���");
			showMainMenu();
		}
		else{
			
			
			if(count >=3){
				System.out.println("�Բ����ף����Ѿ�û�л����ˣ�");
				return;
			}else{
				count++;
				System.out.println("�Բ�����������û���������������������룡");
				processlogin();
			}
			
		}
}
	public static void showMainMenu(){
		System.out.println("---���˵�---");
		System.out.println("1.�û�����");
		System.out.println("2.��Ʒ����");
		System.out.println("3.���˹���");
		System.out.println("4.�˳�ϵͳ");
		System.out.println("��ѡ����Ӧ�Ĳ˵����:");
		int menuNo = new Scanner(System.in).nextInt();
		switch (menuNo) {
		case 1:
			System.out.println("�û�����˵�");
			userMannagement();
			break;
		case 2:{
			System.out.println("��Ʒ����˵�");
			showMenuOfProductManagement();
			break; 
		}
			
		case 3:{
			System.out.println("���˹���˵�");
			showMenuOfPayManagement();
			break;
		}
		case 4:{ 
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
	public static void userMannagement(){
		System.out.println("1.�����û�");
		System.out.println("2.�鿴�û�");
		System.out.println("3.�޸��û�");
		System.out.println("4.ɾ���û�");
		System.out.println("5.�������˵�");
		System.out.println("��ѡ��˵����:");
		
		/**
		 * 2.��ȡ�û�����ı��
		 */
		int yourChoiceNo1 =  new Scanner(System.in).nextInt();
		/**
		 * 3.�ж�����ı�ţ�ִ����Ӧ�Ĺ���
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
			System.err.println("��������ȷ��ѡ���ţ�");
			userMannagement();
			break;
		}
}
	}
	
		public static void showMenuOfProductManagement(){
			// System.out.println("������Ʒ������");
			/**
			 * 1.��ʾ�û��ɲ����Ĳ˵�ѡ��
			 */
			System.out.println("1.�����Ʒ");
			System.out.println("2.�鿴��Ʒ");
			System.out.println("3.�޸���Ʒ");
			System.out.println("4.ɾ����Ʒ");
			System.out.println("5.�������˵�");
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
		public static void showMenuOfPayManagement(){
			System.out.println("1.���");
			System.out.println("2.�޸�");
			System.out.println("3.ɾ��");
			System.out.println("4.�������˵�");
			System.out.println("��ѡ��˵����:");
			int  yourchoice3=0;
			try {
				yourchoice3= new Scanner(System.in).nextInt();//��ȡ�û�����ı��
			} catch (Exception e) {
				System.out.println("��������ȷ�ı��:");
				yourchoice3= new Scanner(System.in).nextInt();
			}
			
			switch (yourchoice3) {
			case 1:{
				PayProduct();
				break;
				}
			case 2:{
				System.out.println("2.�޸�");
				break;
				}
			case 3:{
				System.out.println("3.ɾ��");
				break;
				}
			default:{
				System.err.println("��������ȷ��ѡ���ţ�");
				showMenuOfPayManagement();
				break;
				}
			}
			
		}
		
		public static void exitSystem(){
			System.err.println("�Ƿ�Ҫ�˳�ϵͳ���ǣ�Y��/ ��N������");
			String S = new Scanner(System.in).nextLine();
			if(S.contentEquals("Y"))showWelcome();
			else showMainMenu();}
			public static void addProduct(){//�����Ʒ��Ϣ����addProduct
				//�����û�������Ʒ�����Ϣ
					
					System.out.println("��������Ʒ���ƣ�");
					String newProductName=new Scanner(System.in).nextLine();
					System.out.println("��������Ʒ������");
					int newProductNo= new Scanner(System.in).nextInt();                        
					System.out.println("��������Ʒ�۸�");
				    Float newProductPrice=sc.nextFloat();
				    /**
				     * ���û��������Ʒ��Ϣ��ӵ���Ӧ������
				     */
				    /**
					 * ��������û���Ҫִ���������Ʒ����������Ĵ����������
					 * ��ȡ�û�Ҫ��ӵ��ĵ���Ʒ����Ϣ
					 * ��ȡ��֮��Ϊ�˱�֤��Ϣһ���ܱ��洢��
					 * ��������Ҫ�ж������Ƿ�������
					 * ������������
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
					newProductIndex++; //�洢λ��������һ��������±����������
					System.out.println("����ӳɹ���\n");
					System.out.println("�ף��������������𣿼����밴Y�������밴N��������һ���˵���");
					String yourChoice=new Scanner(System.in).nextLine();
					if(yourChoice.contentEquals("y")){
						addProduct();
					}else{
						showMenuOfProductManagement();
					}
				}
				public static void showProduct(){

					System.out.println("------------��Ʒһ����-------------");          
					System.out.println("��Ʒ���"+"\t\t\t��Ʒ���� "+"\t\t\t��Ʒ���� "+"\t\t\t��Ʒ�۸� ");
			       for (int i = 0; i < newProductIndex; i++) {
			    	   System.out.println(i+1+"\t\t\t"+productName[i]+"\t\t\t"+productNo[i]+"\t\t\t"+productPrice[i]);	
				}
			
				}
				
				public static void updateProduct(){
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
					float   newProductPrice=sc.nextFloat();
					productName[updateproductNo-1]=newProductName;
					productNo[updateproductNo-1]=newProductNo;
					productPrice[updateproductNo-1]=newProductPrice;
					System.out.println("���޸ĳɹ���");
					/**
					 * 4.�޸ĳɹ��󷵻�ѡ��˵�
					 */
					showMenuOfProductManagement();
				}
				public static void deleteProduct(){
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
						productNo[deleteproductNo-1]=0;
						productPrice[deleteproductNo-1]=0;
					
						for(int i=deleteproductNo;i<newProductIndex;i++){
							
								productName[i-1]=productName[i];
								productNo[i-1]=productNo[i];
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
				public static void PayProduct(){
					System.out.println("�����������Ʒ�ı�ţ�");
					int yourChoiceNo31=  new Scanner(System.in).nextInt();
					System.out.println("������Ʒ���£�");
					System.out.println(yourChoiceNo31+"\t\t\t"+productName[yourChoiceNo31-1]+"\t\t\t"+productNo[yourChoiceNo31-1]+"\t\t\t"+productPrice[yourChoiceNo31-1]);
					
					
						System.out.println("���˽��Ϊ��"+productPrice[yourChoiceNo31-1]);
					
						showMenuOfProductManagement();//���˳ɹ��󷵻��ϼ��˵�
					}
					
				public static void addUser(){
					System.out.println("�����û�");
				}
				public static void showUser(){
					System.out.println("�鿴�û�");
				}
				public static void updateUser(){
					System.out.println("�޸��û�");
				}
				public static void deleteUser(){
					System.out.println("ɾ���û�");
				}
				
				
				
			public static void main(String[] args) {
				/**
				 * ��������
				 */
				showWelcome();
				
			

			}
			}




package xzy;

public class Test {

	public static void main(String[] args) {
		int ascii;
		String id;
		String name;
		/*see see = new see();
		see.mkdir("f:\\4.png","f:\\22");*/
		read read= new read();
		read.readLine("f:\\22.txt");
		String num[]=read.getS();
		for(int i=0;i<num.length;i++)
		{
			/*for(int j=0;j<num[i].length();j++)
			{
				if(num[i].charAt(j)=='号') { 
			
					for(;j<num[i].length();j++) {
						//byte b = (byte)'a';  
						ascii=(byte)num[i].charAt(j);
						if(ascii>=48&&ascii<=57) {
						System.out.println(num[i].charAt(j));
						}
					}
					
				}
				if(num[i].charAt(j)=='称'){
					
				}
			}*/
			System.out.println(num[i].length());
			System.out.println(num[i]);
		}
	/*	write write = new write();
		write.werteexcel(num,"f:\\22.xls");*/
	

	}



}

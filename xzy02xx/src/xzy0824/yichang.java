package xzy0824;

public class yichang {
	public static void main(String[] args) {
		try{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a/b;
			
			System.out.println("结果是"+c);
		}
		
	/*	catch(IndexOutOfBoundsException i){
			System.out.println("shuzu");
			System.out.println(i.getMessage());
			
		}*/
		catch(ArithmeticException i){
			System.out.println("算术异常");
		}catch(Exception i){
			System.out.println("未知异常");
			i.printStackTrace();
			System.out.println("66");
		}
		
	}

}

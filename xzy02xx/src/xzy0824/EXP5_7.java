package xzy0824;
import java.io.*;
class MyException extends Exception 
{
	private int x;
	MyException(int a) 
	{
		x=a;
	}
	public String toString()
	{
		return "自定义异常类MyException";
	}
}
public class EXP5_7
{
	static void mathod(int a) throws MyException
	{
		System.out.println("\t 此处引用 mathod ("+a+")");
		if (a>10) throw new MyException(a); // 主动抛出MyException
		System.out.println("正常返回");
	}
	public static void main(String args[])
	{
		try
		{
			System.out.println("\n 进入监控区，执行可能发生异常的程序段");
			mathod(8);
			mathod(20);
			mathod(6);                         //		mathod(20);抛出异常，这句就跳过了
		}
		catch (MyException e)
		{
			System.out.println("\t 程序发生异常并在此处进行处理");
			System.out.println("\t 发生的异常为："+e.toString());
		}
		System.out.println("这里可执行其它代码");
	}
}
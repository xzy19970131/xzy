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
		return "�Զ����쳣��MyException";
	}
}
public class EXP5_7
{
	static void mathod(int a) throws MyException
	{
		System.out.println("\t �˴����� mathod ("+a+")");
		if (a>10) throw new MyException(a); // �����׳�MyException
		System.out.println("��������");
	}
	public static void main(String args[])
	{
		try
		{
			System.out.println("\n ����������ִ�п��ܷ����쳣�ĳ����");
			mathod(8);
			mathod(20);
			mathod(6);                         //		mathod(20);�׳��쳣������������
		}
		catch (MyException e)
		{
			System.out.println("\t �������쳣���ڴ˴����д���");
			System.out.println("\t �������쳣Ϊ��"+e.toString());
		}
		System.out.println("�����ִ����������");
	}
}
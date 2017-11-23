package peixunban;

import java.util.Scanner;

public class sushu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int n=2;
		boolean a = true;
		for(n = 2;n<num;n++)
		{
			a = false;
			if(num%n==0) {System.out.println("NO");return;}
		}
		if(a||n!=2)
		System.out.println("yes");
	}

}


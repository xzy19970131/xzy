package peixunban;

import java.util.Scanner;

public class lingxing {
static void hua(int n)
{
	int h = (n+1)/2;
	int i = 1;
	for(i=1;i<=h;i++)     //上边一半加最长的那行；
	{
		for (int j = 1; j <= h-i; j++) {
			System.out.print(" ");
		}
		for (int j = 1; j <=2*i-1; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	
	
	h=h-1;
	i=1;
	for(int hang = 1;hang<=h;hang++) {
		for (int t =1; t <=hang; t++) {
			System.out.print(" ");
		}
		for (int t =1; t <=n-2*hang; t++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int  n = sc.nextInt();
	hua(n);
	}

}

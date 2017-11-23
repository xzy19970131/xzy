package peixunban;

import java.util.Random;

public class random {

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) new Random().nextInt(100);   //Random()  Ëæ»úÊý
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

}

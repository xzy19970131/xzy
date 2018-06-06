package xzy;

public class StringTest {

	public static void main(String[] args) {
		String s ="123456789s";
		System.out.println(s.subSequence(0, s.length()-1));
		if(s.contains("s")) {
			System.out.println("包含");
		}

	}

}

package xzy0828;
interface p2{
	String getname();

	
}
public class niming02 {
	void say(p2 t){System.out.println(t.getname());	
	}
	
	public static void main(String[] args) {
		niming02 s = new niming02();
		s.say (new p2(){public  String getname(){
			return "xianka";}
		});
	}

}

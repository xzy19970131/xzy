package xzy0828;
interface p{
	String getname();
	double getprize();
	
}
public class niming implements p{
	public String getname() {
		return "xianka";
	}
	public double getprize() {
		return 600;
	}
	void say(){
		System.out.println("买了一个"+getname()+"花了"+getprize());
	}
	public static void main(String[] args) {
		niming n = new niming();
		n.say();
	}

}

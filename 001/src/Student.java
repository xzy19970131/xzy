

public class Student {
	String name,sex;
	int xuehao;
	int age;
	public Student() {
		super();
	}
	public String toString(){
    	return this.name+"    "+this.xuehao+"  "+this.sex+"  "+this.age+"\n";
    }
	boolean equals(String s){
		if(this.name==s)return true;
		else return false;
	}
	public Student(String name, int xuehao,String sex,int age) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.xuehao = xuehao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getsex() {
		return sex;
	}
	public void setsex(String sex) {
		this.sex = sex;
	}public int getxuehao() {
		return xuehao;
	}
	public void setxuehao(int xuehao) {
		this.xuehao = xuehao;
	}
}

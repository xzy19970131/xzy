package qqmodel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class qqUser implements Serializable{
	private String name;
	private String sex;
	private String password;
	private int  age;
	private String signature;
	private String imagePath;
	private String qqUser;
	private String nickname;
	private static Map<String,HashSet<qqUser>>  friends=new HashMap<>();//has-a
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getQqUser() {
		return qqUser;
	}

	public void setQqUser(String qqUser) {
		this.qqUser = qqUser;
	}

	public static Map<String, HashSet<qqUser>> getFriends() {
		return friends;
	}

	public void setFriends(Map<String, HashSet<qqUser>> friends) {
		this.friends = friends;
	}

	public qqUser() {
		super();
	}
	
	public qqUser(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	
	public qqUser(String name, String sex, String password, int age,  String imagePath,
			String nickname,String signature) {
		super();
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.age = age;
		this.signature = signature;
		this.imagePath = imagePath;
		this.nickname = nickname;
	}
	public String toString() {
		return "qqUser [name=" + name + ", sex=" + sex + ", password=" + password + ", age=" + age + ", signature="
				+ signature + ", imagePath=" + imagePath + ", qqUser=" + qqUser + ", nickname=" + nickname + "]";
	}
}

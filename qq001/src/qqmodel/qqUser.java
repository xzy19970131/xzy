package qqmodel;

import java.io.Serializable;
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
	private Map<String,HashSet<qqUser>> friends;
	
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}




	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}




	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}




	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}




	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}




	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}




	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}




	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}




	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}




	/**
	 * @return the qqUser
	 */
	public String getQqUser() {
		return qqUser;
	}




	/**
	 * @param qqUser the qqUser to set
	 */
	public void setQqUser(String qqUser) {
		this.qqUser = qqUser;
	}




	/**
	 * @return the friends
	 */
	public Map<String, HashSet<qqUser>> getFriends() {
		return friends;
	}




	/**
	 * @param friends the friends to set
	 */
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "qqUser [name=" + name + ", sex=" + sex + ", password=" + password + ", age=" + age + ", signature="
				+ signature + ", imagePath=" + imagePath + ", qqUser=" + qqUser + ", nickname=" + nickname + "]";
	}

	
	
	
	
}

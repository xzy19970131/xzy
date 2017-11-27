package qqmodel;

import java.util.HashSet;
import java.util.Map;

public class qqUser {
	private String name;
	private String sex;
	private String password;
	private String age;
	private String signature;
	private String imagePath;
	private String qqUser;
	private Map<String,HashSet<qqUser>> friends;
	
	
	
	
	/**
	 * @return the name
	 */
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
	public String getAge() {
		return age;
	}




	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
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




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "qqUser [name=" + name + ", sex=" + sex + ", password=" + password + ", age=" + age + ", signature="
				+ signature + ", imagePath=" + imagePath + ", qqUser=" + qqUser + ", friends=" + friends + "]";
	}
	
	
}

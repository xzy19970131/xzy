package com.oracle.TeaMall.action;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private int i;
	
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String aaaa() {
		System.out.println(i);
		System.out.println("aaaaaa");
		return "b";
	}
	public String bbbb() {
		
		System.out.println("oooo");
		System.out.println(i);	
		return "a";
	}
	public String cccc() {
		System.out.println("add2");
		System.out.println(i);
		System.out.println("999");
		return "a";
	}
	public String dddd() {
		System.out.println("del2");
		return "a";
	}

}

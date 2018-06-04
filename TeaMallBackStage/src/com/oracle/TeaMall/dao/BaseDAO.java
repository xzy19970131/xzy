package com.oracle.TeaMall.dao;

public interface BaseDAO {
	public String  dirverClass="com.mysql.jdbc.Driver";
	public String  url="jdbc:mysql://localhost:3306/chaye?useUnicode=true&characterEncoding=utf8";
	public String username="root";
	public String password="root";
	/*public String  dirverClass="oracle.jdbc.driver.OracleDriver";
	public String  url="jdbc:oracle:thin:@localhost:1521:XE";
	public String username="TEAADMIN";
	public String password="TEAADMIN";*/
	
	//添加
	public boolean add(Object o);
	
	public boolean  delete(Object id);
	
	public boolean update(Object  o);
	
	public Object  list();
}

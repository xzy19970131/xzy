package com.test;

import static org.junit.Assert.*;

import chaye.TeaDao;
import chaye.TeaDaoImp;

public class Test {

	@org.junit.Test
	public void test() {
		TeaDao teaDao=new TeaDaoImp();
		System.out.println(teaDao.listRecentTeasByCount(18).size());
	}

}

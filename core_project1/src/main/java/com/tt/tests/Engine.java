package com.tt.tests;

import java.util.HashMap;

import com.tt.Base.BaseTest;
import com.tt.util.DateUtil;
import com.tt.util.EnvProperties;
import com.tt.util.Reporter;
import com.tt.util.XlUtil;

public class Engine {
	public static void main(String[] args) {
		
		EnvProperties ep = new EnvProperties("C:\\\\selenium\\\\env2.Properties");
		
		String applicationURL =ep.getPropertyValue("app_url");
		
		Reporter r = new Reporter("C:\\selenium\\","DemoReporter"+DateUtil.getCurrentDate("ddMMMyyy-HH-mm-ss+")+".html");
		
		BaseTest bt=new ShoppingTest();
		bt.prepareTestData("C:\\\\selenium\\\\Book1.xlsx");
		bt.setTestData("user_name",ep.getPropertyValue("user_name"));
		bt.setTestData("user_password",ep.getPropertyValue("user_password"));
		
		bt.setReporter(r);
		bt.initializeTest(applicationURL, "Verify if my product is adding to cart");
		bt.executeTest();
		bt.closingTest();
		r.flush();
		
		
		
		
	}

}

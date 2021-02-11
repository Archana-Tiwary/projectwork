package com.tt.tests;

import java.util.HashMap;

import com.tt.Base.BaseTest;
import com.tt.ui.Browser;

import pom.LoginPage;

public class home extends BaseTest {

	
	
	String username , password;
	String errorMsg;
	LoginPage lg=null;
	
	public home() {
		browser = new Browser();      // Browser class is present in another project
		
	}

	public void initializeTest(String url) {
		
		browser.initBrowser();    // calling it from the Browser.java
		browser.launchBrowser(url);
		 lg = new LoginPage(browser);
	}

	public void executeTest() {
		
		lg.setUserName(this.username);
		lg.setPasword(this.password);
		lg.clickLogin();
		String loginErrorMsg = lg.getErrorMessage();
		
		  
		  if(loginErrorMsg.equals(this.errorMsg))
			  System.out.println("Test case passed, error message is thrown properly when wrong credential are given");
		  else
			  System.out.println("login was successful as the creditial are correct");
		
		
	}

	
	public void closingTest() {
		
		
	}

	public void setTestData(String... arg) {
		// TODO Auto-generated method stub
		this.username = arg[0];
		this.password = arg[1];
		this.errorMsg = arg[2];
	}
	public void closeBrowser() {
		browser.close();
	}

	@Override
	public void initializeTest(String url, String testName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepareTestData(String filePath) {
		// TODO Auto-generated method stub
		
	}

	

}

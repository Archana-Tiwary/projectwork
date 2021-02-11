package com.tt.tests;

import com.tt.Base.BaseTest;
import com.tt.ui.Browser;

public class AlertTest extends BaseTest {
 
	@Override
	public void initializeTest(String url, String testName) {
		browser = new Browser(); 
		browser.initBrowser();    
		browser.launchBrowser(url);
		
		 r.test(testName);
		 r.setDriver(browser.getDriver());
		
		
	}

	@Override
	public void executeTest() {
		String oktabXP = "//a[@href='#OKTab']";
		String btnOkTabXP="//button[contains(text(),'    click the button to display an  alert box:')]";
		
		String OkCancelTabXP = "//a[@href='#CancelTab']";
		String btnconfirmboxXP = "//button[contains(text(),'click the button to display a confirm box ')]";
		
		String texttabXP = "//a[@href='#Textbox']";
		String btnentryboxXP = "//button[contains(text(),'click the button to demonstrate the prompt box ')]";
		
		
		browser.getObjectByXP(oktabXP).click();
		browser.getObjectByXP(btnOkTabXP).click();
		String alertMsg = browser.getAlertMessage();
		System.out.println("Alert Message"+alertMsg);
		browser.acceptAlert();
		
		browser.getObjectByXP(OkCancelTabXP).click();
		browser.getObjectByXP(btnconfirmboxXP).click();
		alertMsg  = browser.getAlertMessage();
		
		System.out.println("Alert Message"+alertMsg);
		browser.cancelAlert();
		
		browser.getObjectByXP(btnconfirmboxXP).click();
		browser.acceptAlert();
		
		
		
		browser.getObjectByXP(texttabXP).click();
		browser.getObjectByXP(btnentryboxXP).click();
		browser.setTextInAlert("Alweya");
		browser.acceptAlert();
		
		
		
	}

	@Override
	public void setTestData(String... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepareTestData(String filePath) {
		// TODO Auto-generated method stub
		
	}
	

}

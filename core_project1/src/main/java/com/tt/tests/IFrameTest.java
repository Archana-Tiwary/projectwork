package com.tt.tests;

import com.tt.Base.BaseTest;
import com.tt.ui.Browser;

public class IFrameTest extends BaseTest{

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
	String xpath = "(//input)[1]";
	String IFrameID = "singleframe";
	String linkText = "Iframe with in an Iframe";
	
	browser.getObjectByLINKTEXT(linkText).click();
	//browser.switchToIFrame(IFrameID);
	String toplevelframeXP="//iframe[@src='MultipleFrames.html']";
	String insideFrameXP = "//iframe[@src='SingleFrame.html' and not(contains(@id,'singleframe'))]";
	browser.switchToIFrameByXP(toplevelframeXP);
	browser.switchToIFrameByXP(insideFrameXP);
	browser.getObjectByXP(xpath);
	browser.setText("Frame");
	browser.exitIFrame();
		
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

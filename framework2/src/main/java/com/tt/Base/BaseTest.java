package com.tt.Base;

import java.util.HashMap;

import com.tt.ui.Browser;
import com.tt.util.Reporter;

public abstract class BaseTest {
	
	public final String browserType = "CHROME";
	public Browser browser=null;
	protected HashMap<String,String> testData;
	protected Reporter r = null;
	
	public  abstract void initializeTest(String url, String testName);
	public  abstract void executeTest();
	public  abstract void setTestData(String...arg);
	public  abstract void closeBrowser();
	public  abstract void prepareTestData(String filePath);
	public void setTestData(String key, String value)
	{
		if(testData!=null)
			testData.put(key, value); 
	}
	public  void closingTest()
	{
		r.stop();
	}
	
	public  void setTestData(HashMap<String,String> data)
	{
		this.testData = data;
	}
	
	public String d(String key)
	{
		return testData.get(key).toString();
	}
	
	public void setReporter(Reporter r)
	{
		this.r=r;
	}


}

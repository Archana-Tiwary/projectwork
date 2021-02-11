package com.tt.tests;

import com.tt.Base.BaseTest;
import com.tt.util.DateUtil;
import com.tt.util.Reporter;

public class Testing {
	
	public static void main(String args[])
	{
		/*String appUrl = "http://demo.automationtesting.in/Frames.html";
		Reporter r = new Reporter("C:\\selenium\\","DemoReporter"+DateUtil.getCurrentDate("ddMMMyyy-HH-mm-ss+")+".html");
		
		BaseTest bt=new IFrameTest();
		bt.setReporter(r);
		
		bt.initializeTest(appUrl, "Verify if we are able to automate objects in iframe");
		bt.executeTest();
		bt.closingTest();
		r.flush();*/
		
		String appUrl = "http://demo.automationtesting.in/Alerts.html";
        Reporter r = new Reporter("C:\\selenium\\","DemoReporter"+DateUtil.getCurrentDate("ddMMMyyy-HH-mm-ss+")+".html");
		
		BaseTest bt=new AlertTest();
		bt.setReporter(r);
		
		bt.initializeTest(appUrl, "Verify if we are able to automate alert ");
		bt.executeTest();
		bt.closingTest();
		r.flush();
		
	
	}

}

package com.tt.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tt.ui.Browser;

public class Reporter {
	ExtentReports reports = null;
	ExtentTest test = null;
	String Path="";
	String reportName="";
	String testName="";
	WebDriver driver = null;
	
	public Reporter(String path, String reportName)
	{
		this.Path=path;
		this.reportName=reportName;
		reports = new ExtentReports(path+reportName);
		
	}
	
	public void setDriver(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void test(String testName)
	{
		this.testName = testName;
		test = reports.startTest(testName);
		
	}
	
	public void info(String msg)
	{
		test.log(LogStatus.INFO, msg);
	}
	public void pass(String msg)
	{
		test.log(LogStatus.PASS, msg);
		String screenShotPath = getScreenShot("Pass");
		test.log(LogStatus.PASS, test.addScreenCapture(screenShotPath));
	}
	public void fail(String msg)
	{
		test.log(LogStatus.FAIL, msg);
		String screenShotPath = getScreenShot("Fail");
		test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
	}
	
	public void stop()
	{
		reports.endTest(test);
		
	}
	
	public void flush()
	{
		reports.flush();
	}

	public String getScreenShot(String screenShotName)
	{
		String destination="";
		try {
			String dateName=DateUtil.getCurrentDate("ddMMMyyyy-HH-mm-ss");
			TakesScreenshot tss=(TakesScreenshot) driver;
			File source=tss.getScreenshotAs(OutputType.FILE);
			destination=this.Path+"/DemoScreenShots/"+screenShotName+" "+dateName +".png";
			File file=new File(destination);
			FileUtils.copyFile(source, file);
			/*
			 * String dateName = DateUtil.getCurrentDate("ddMMMyyyy-HH-mm-ss");
			 * TakesScreenshot ts = (TakesScreenshot)driver; File source =
			 * ts.getScreenshotAs(OutputType.FILE); destination = this.Path+"/Screenshots/"+
			 * screenShotName+ dateName+ ".png"; File file = new File(destination);
			 * FileUtil.copyFile(source, file);
			 */
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return destination;
	}

}

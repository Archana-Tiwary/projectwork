package com.tt.ui;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	String browserType = "chrome";
	WebDriver driver  = null;
	WebElement elem = null;
	
	
	
	public WebDriver initBrowser()
	{
		if(browserType.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void close()
	{
	
	}
	
	public WebElement getObject(String locatorType, String value)
	{
		try {
			if(locatorType.equalsIgnoreCase("ID"))
			{
				elem = driver.findElement(By.id(value));
			}
			else if (locatorType.equalsIgnoreCase("XP"))
			{
				elem = driver.findElement(By.xpath(value));
			}
			else if (locatorType.equalsIgnoreCase("CLASSNAME"))
			{
				elem = driver.findElement(By.className(value));
			}
			else if (locatorType.equalsIgnoreCase("LINKTEXT"))
			{
				elem = driver.findElement(By.linkText(value));
			}
		}
		catch(NoSuchElementException nsee)
		{
			System.err.println("Object is not found");
			elem = null;
		}
		return elem;
	}
	public WebElement getObjectByID(String id)
	{
		return getObject("ID", id);

	}
	
	public WebElement getObjectByXP(String xp)
	{
		return getObject("XP", xp);
		
	}
	public WebElement getObjectByLINKTEXT(String linkText)
	{
		return getObject("LINKTEXT", linkText);
		
	}
	public WebElement getObjectByCLASS(String className)
	{
		return getObject("CLASSNAME", className);

	}
	public int getObjectCountByXP(String xp)
	{
		int count=0;
		try {
		List<WebElement> elem = driver.findElements(By.xpath(xp));
		if(elem!=null && elem.size()>0)
			count=elem.size();
		}
		catch(Exception e){
			System.err.println("elements are not found"+xp);
		}
		return count;
		
	}
	
	public void setText(String data)
	{
		if(elem!=null)
		{
			elem.clear();
			elem.sendKeys(data);
		}
	}
	public void click()
	{
		if(elem!=null)
		{
			elem.click();
		}
	}
	public String getText()
	{
		String ret= "";
		if(elem!=null)
		{
			ret = elem.getText();
		}
		return ret;
	}
		
	public void launchBrowser(String url)
	{
		driver.get(url);   //getting url from SampleTest.java
	}
	
	public void waitForObjectIsVisible(String locator, String value)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		try 
		{
		if(locator.equalsIgnoreCase("ID"))
		   elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
		else if(locator.equalsIgnoreCase("XPATH"))
			 elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
		else if(locator.equalsIgnoreCase("LINKTEXT"))
			 elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
		else if(locator.equalsIgnoreCase("NAME"))
			 elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
		else if(locator.equalsIgnoreCase("CLASSNAME"))
			 elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
	}
		catch(Exception e)
		{
			System.out.println("object is not found with locator:"+locator+"and the locator value"+value);
		}
}
	public void selectOption(String value)
	{
		Select se = new Select(elem);
		se.selectByVisibleText(value);
	}
	public void printalloptions()
	{
		Select se = new Select(elem);
		List<WebElement> options = se.getOptions();
		System.out.println("printing all the options of dropdown box");
		for(int i = 0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		System.out.println("end of printing");
		}

	public WebDriver getDriver() {
	
		return driver;
	}
	
	public void switchToIFrame(String id)
	{
		WebElement iframe = driver.findElement(By.id(id));
		driver.switchTo().frame(iframe);
	}
	public void switchToIFrameByXP(String xp)
	{
		WebElement iframe = driver.findElement(By.xpath(xp));
		driver.switchTo().frame(iframe);
		
	}
	public void exitIFrame()
	{
		driver.switchTo().defaultContent();
	}
	public void switchToAlert()
	{
		driver.switchTo().alert();
	}
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	public void cancelAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	public String getAlertMessage()
	{
		return driver.switchTo().alert().getText();
	}
	public void setTextInAlert(String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
}









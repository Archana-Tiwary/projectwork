package com.tt.tests;

import java.util.HashMap;

import com.tt.Base.BaseTest;
import com.tt.ui.Browser;
import com.tt.util.Reporter;
import com.tt.util.XlUtil;

import pom.Cart;
import pom.CustomerInfo;

import pom.LoginPage;
import pom.Overview;
import pom.PracticePage;
import pom.ProductPage;

public class ShoppingTest extends BaseTest {
	
	
	ProductPage pg = null;
	LoginPage lp=null;
	Cart ct = null;
	CustomerInfo ifo = null;
	Overview ov = null;
	String username,password,firstname,Lastname,zipcode;
	
	
	
	
	public ShoppingTest() 
	{
		
	}
	
	public ShoppingTest(HashMap<String,String> testData)
	{
		setTestData(testData);
	}
	

	public void initializeTest(String url, String testName) {
		browser = new Browser(); 
		browser.initBrowser();    // calling it from the Browser.java
		browser.launchBrowser(url);
		
		
		 pg = new ProductPage(browser);
		 lp = new LoginPage(browser);
		 ct = new Cart(browser);
		 ifo = new CustomerInfo(browser);
		 ov = new Overview(browser);
		 
		 
		 r.test(testName);
		 r.setDriver(browser.getDriver());
		 
		 
		
	}
	
	

	public void executeTest() {
		//login to ecommerce application
		lp.setUserName(d("user_name"));
		r.info("Entered username:" + d("user_name"));
		lp.setPasword(d("user_password"));
		r.info("Entered password:" + d("user_password"));
		lp.clickLogin();
		r.info("Clicked login btn");
		
		pg.dropdownbox("Name (Z to A)");
		r.info("selected the order by dropdown as:" + "Name (Z to A)");
		//adding multiple items to cart
		String itemString = d("add_items");
		String[] items = itemString.split("##");
		int itemCountToAdd = items.length;
		for(int i =0;i<itemCountToAdd;i++)
		{
			pg.clickAddToCart(items[i]);
			r.info("added  item to cart:" + items[i]);
		}
		String num = pg.getNumberOfItemInCart();
		r.info("no. of items added to cart:" + num);
		ct.goToCart();
		r.info("clicked on shopping cart:");
		int item = ct.getNumberofitem();
		if(num.equals(""+item))
			r.pass("your cart page has correct no. of items");
			else
				r.fail("your cart page does not have correct no. of items");
		
		//remove items from cart
		String removeitemString = d("remove_items");
		String[] removeitems = removeitemString.split("##");
		int removeItemCount = removeitems.length;
		for(int i =0;i<removeItemCount;i++)
		{
			
			ct.removebtnfromcart(removeitems[i]);
			r.info("removed item:"+removeitems[i]+"from cart");
		}
		item = ct.getNumberofitem();
		r.info("no. of item present in cart now:"+item);
		ct.CheckOut();
		r.info("checkout");
		//customer information
		ifo.setFirstName(d("first_name"));
		r.info("Entered firstname:" + d("first_name"));
		ifo.setLastName(d("last_name"));
		r.info("Entered lastname:" + d("last_name"));
		ifo.setPinCode(d("postal_code"));
		r.info("Entered postalcode:" + d("postal_code"));
		ifo.clickContinue();
		r.info("clicked continue btn");
		
		//item overview
		ov.getItem();
		ov. getdiscription();
		ov.getprice();
		ov.getItemTotal();
		ov.gettax();
		ov.getTotal();
		ov.clickFinish();
		ov.getThankyou();
	
	}

	public void setTestData(String... arg) {
		this.username=arg[0];
		this.password=arg[1];
		this.firstname=arg[2];
		this.Lastname=arg[3];
		this.zipcode=arg[4];

	}

	

	public void closeBrowser() {
		browser.close();
		
	}

    public void setTestData(HashMap<String, String> testData) {
		
		this.testData=testData;
	}
public void prepareTestData(String filePath)
{
	XlUtil xl = new XlUtil(filePath);
	testData=new HashMap();
	
	//getting data from "Data" sheet
	testData.put("first_name", xl.getCellValue("FirstName", 1));
	testData.put("last_name", xl.getCellValue("LastName", 1));
	testData.put("postal_code", xl.getCellValue("PostalCode", 1));
			
			//load sheet "items"
			xl.loadsheet("Items");
			
			int numOfItemRows = xl.getTotalRow();
			String itemstoAdd = "";
			String itemstoRemove="";
			
			for(int i=1;i<=numOfItemRows;i++)
			{
				String action = xl.getCellValue("ActionPerformed",i);
				if(action.equalsIgnoreCase("AddToCart"))
				{
					itemstoAdd = itemstoAdd+ "##" + xl.getCellValue("Items",i);
				}
				else
				{
					itemstoRemove = itemstoRemove+ "##" + xl.getCellValue("Items",i);
				}
			}
			if(itemstoAdd.length()>0)
				itemstoAdd = itemstoAdd.substring(2);
			if(itemstoRemove.length()>0)
				itemstoRemove = itemstoRemove.substring(2);
			
			testData.put("add_items", itemstoAdd);
			testData.put("remove_items", itemstoRemove);
			
			xl.close();
			
}
	

}

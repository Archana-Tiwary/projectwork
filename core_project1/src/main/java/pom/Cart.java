package pom;

import java.util.Date;

import com.tt.Base.BasePage;
import com.tt.ui.Browser;


public class Cart extends BasePage
{
	
	String cartPage="//div[@id='shopping_cart_container']";
	String checkoutbtn="//a[@class='btn_action checkout_button']";
	//String checkoutbtn="CHECKOUTBTN1";
	String cartItemXP="//div[@class='cart_item']";
	String productTitle="Sauce Labs Backpack";
	String removebtnXP="//div[@class='inventory_item_name' and text()='{{PRODUCT_TITLE}}']/ancestor::a[1]/following-sibling::div[2]//button";
	
	public Cart(Browser browser) {
		super(browser);
	}
 
public void setProductTitle(String productTitle)
{
	this.productTitle=productTitle;
}

	
	public void goToCart() {
		browser.getObjectByXP(cartPage);
		browser.click();
	}
	
	
	public int getNumberofitem()
	{
		int item=0;
		item=browser.getObjectCountByXP(cartItemXP);
		System.out.println("Number of different item present in cart="+item);
		return item;
	}
	
	
	public void CheckOut()
	{
		Date d1 = new Date();
		long before = d1.getTime();
		browser.waitForObjectIsVisible("XPATH",checkoutbtn );
		Date d2 = new Date();
		long after = d2.getTime();
		System.out.println("time taken to wait:"+(after-before));
		browser.getObjectByXP(checkoutbtn);
		browser.click();
		Date d3 = new Date();
		long afterClick = d3.getTime();
		System.out.println("time taken to wait and click:"+(afterClick-before));
	}
	public String getRemoveProductFromCartXP(String productTitle)
	{
		setProductTitle( productTitle);
		String removebtn = removebtnXP.replace("{{PRODUCT_TITLE}}", productTitle);
		return removebtn;
	}
	
    public void removebtnfromcart(String productTitle)
    {
    	browser.getObjectByXP(getRemoveProductFromCartXP(productTitle));
		browser.click();
    }
}

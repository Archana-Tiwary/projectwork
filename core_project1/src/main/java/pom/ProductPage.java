package pom;

import com.tt.Base.BasePage;
import com.tt.ui.Browser;

public class ProductPage extends BasePage{

	String productTitle="sause labs bakpack";
	String productTitleXP="//div[text()='{{PRODUCT_TITLE}}']";
	String addToCartXP= "/ancestor::div[1]/following-sibling::div//button";
	String priceXP = "/ancestor::div[1]/following-sibling::div//div";
	String ShoppingCartBadgeXP="//span[@class='fa-layers-counter shopping_cart_badge']";
	String dropdownclassName = "product_sort_container";
	
	
	public ProductPage(Browser browser) {
		super(browser);
	}
	
	public void setProductTitle(String productTitle) {
		this.productTitle= productTitle;
		
	}
	public String getPriceXP(String productTitle)
	{
		setProductTitle(productTitle);
		String productTitleXPTemp= this.productTitleXP.replace("{{PRODUCT_TITLE}}", this.productTitle);
		String priceXPTemp =productTitleXPTemp + priceXP;
		return priceXPTemp;
	}
	
	public String getAddToCartXP(String productTitle)
	{
		setProductTitle(productTitle);
		String productTitleXPTemp= this.productTitleXP.replace("{{PRODUCT_TITLE}}", this.productTitle);
		String addToCartXPTemp = productTitleXPTemp + addToCartXP;
		return addToCartXPTemp;
	}
	public void dropdownbox(String odervalue)
	{
		browser.getObjectByCLASS(dropdownclassName);
		browser.printalloptions();    //print
		browser.getObjectByCLASS(dropdownclassName);
		browser.selectOption(odervalue);    //dropdown
	}
	
	public void clickAddToCart(String productTitle) {
		String addToCartXPTemp= getAddToCartXP(productTitle);
		String priceXPTemp=  getPriceXP(productTitle);
		
		browser.getObjectByXP(priceXPTemp);
		String price = browser.getText();
		System.out.println("Item price for \"" + productTitle + "\" is " + price);
		browser.getObjectByXP(addToCartXPTemp);
		browser.click();
	}
	public String getNumberOfItemInCart()
	{
		browser.getObjectByXP(ShoppingCartBadgeXP);
		String nc = browser.getText();
		System.out.println("Number of item in cart="+nc);
		return nc;
		
	}
	
	
}

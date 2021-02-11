package pom;

import com.tt.Base.BasePage;
import com.tt.ui.Browser;

public class Overview extends BasePage {
	
	String itemXP="//div[@class='inventory_item_name']";
	String discriptionXP="//div[@class='inventory_item_desc']";
	String priceXP="//div[@class='inventory_item_price']";
	String item_totalXP="//div[@class='summary_subtotal_label']";
	String taxXP="//div[@class='summary_tax_label']";
	String totalXP="//div[@class='summary_total_label']";
	String finishXP="//a[@class='btn_action cart_button']";
	String thankXP="//h2[@class='complete-header']";
	
	public Overview(Browser browser) {
		super(browser);
	}
	
	public void getItem()
	{
		browser.getObjectByXP(itemXP);
		String it= browser.getText();
		System.out.println("item name="+it);
	}
	public void getdiscription()
	{
		browser.getObjectByXP(discriptionXP);
		String dis= browser.getText();
		System.out.println("discription="+dis);
	}
	public void getprice()
	{
		browser.getObjectByXP(priceXP);
		String pr= browser.getText();
		System.out.println("price="+pr);
	}
	public void getItemTotal()
	{
		browser.getObjectByXP(item_totalXP);
		String itt= browser.getText();
		System.out.println(itt);
	}
	public void gettax()
	{
		browser.getObjectByXP(taxXP);
		String t= browser.getText();
		System.out.println(t);
	}
	public void getTotal()
	{
		browser.getObjectByXP( totalXP);
		String tot= browser.getText();
		System.out.println(tot);
	}
	public void clickFinish()
	{
		browser.getObjectByXP(finishXP);
		browser.click();
	}
	public void getThankyou()
	{
		browser.getObjectByXP(thankXP);
		String th= browser.getText();
		System.out.println(th);
	}
	

}

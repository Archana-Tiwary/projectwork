package pom;

import com.tt.Base.BasePage;
import com.tt.ui.Browser;

public class CustomerInfo extends BasePage {

	
	String fname="first-name";
	String lname="last-name";
	String zip="postal-code";
	String continuebtn="//input[@class=\"btn_primary cart_button\"]";
	
	
	public CustomerInfo (Browser browser) {
		super(browser);
	}
	public void setFirstName(String data) {
		browser.getObjectByID(fname);
		browser.setText(data);
	}
	public void setLastName(String data) {
		browser.getObjectByID(lname);
		browser.setText(data);
	}
	public void setPinCode(String data) {
		browser.getObjectByID(zip);
		browser.setText(data);
	}
	public void clickContinue() {
		browser.getObjectByXP(continuebtn);
		browser.click();

	}
}

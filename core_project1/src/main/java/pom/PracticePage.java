package pom;

import com.tt.Base.BasePage;
import com.tt.ui.Browser;

public class PracticePage extends BasePage {
	String RadioBtnXP = "//input[@value='radio1']";
	String CheckboxXP = "//input[@value='option2']";
	
	public PracticePage(Browser browser) {
		super(browser);
	}
	
	
	public void checkboxBtn()
	{
		browser.getObjectByXP(CheckboxXP);
		browser.click();
		
	}
	public void radioBtn() {
		browser.getObjectByXP(RadioBtnXP);
		browser.click();
		
	}
	

}

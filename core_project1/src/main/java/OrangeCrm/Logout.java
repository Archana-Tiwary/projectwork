package OrangeCrm;

import com.tt.Base.BasePage;
import com.tt.ui.Browser;

public class Logout extends BasePage{
	
	String logoutLINKTEXT="Logout";
	String userID="welcome";
	
	public Logout(Browser browser) {
		super(browser);
	}
	
	public void clickLogout()
	{
		browser.getObjectByID(userID).click();
		browser.getObjectByLINKTEXT(logoutLINKTEXT).click();
		System.out.println("Successfully completed");
	}
	
	

}

package OrangeCrm;

import com.tt.Base.BasePage;
import com.tt.ui.Browser;

public class SearchUser extends BasePage{
	
	String nameID="searchSystemUser_userName";
	String roleID="searchSystemUser_userType";
	String enameID="searchSystemUser_employeeName_empName";
	String sID="searchSystemUser_status";
	String searchID="searchBtn";
	
	public SearchUser(Browser browser) {
		super(browser);
	}
	public void setName(String data) {
		browser.getObjectByID(nameID);
		browser.setText(data);
	}
	public void getRole(String value)
	{
		browser.getObjectByID(roleID);
		browser.printalloptions();    //print
		browser.getObjectByID(roleID);
		browser.selectOption(value);    //dropdown
	}
	public void setEName(String data) {
		browser.getObjectByID(enameID);
		browser.setText(data);
	}
	public void getempStatus(String value)
	{
		browser.getObjectByID(sID);
		browser.printalloptions();    //print
		browser.getObjectByID(sID);
		browser.selectOption(value);    //dropdown
	}
	public void clickSearchBtn()
	{
		browser.getObjectByID(searchID);
		browser.click();
	}
	
	

}

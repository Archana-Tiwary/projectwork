package OrangeCrm;

import com.tt.Base.BasePage;
import com.tt.ui.Browser;

public class Admin extends BasePage{
	
	String adminMenuLINKTEXT = "Admin";
	String addBtnID = "btnAdd";
	String userRoleID="systemUser_userType";
	String statusID="systemUser_status";
	String empNameID="systemUser_employeeName_empName";
	String uNameID="systemUser_userName";
	String passwordID="systemUser_password";
	String confirmPasswordID="systemUser_confirmPassword";
	String savebtnID="btnSave";

	
	
	public Admin(Browser browser) {
		super(browser);
	}
	
	public void getAdminBtn()
	{
		
		browser.getObjectByLINKTEXT(adminMenuLINKTEXT);
		browser.click();
	}
	public void clickAddBtn()
	{
		browser.getObjectByID(addBtnID);
		browser.click();
	}
	public void getUserRole(String value)
	{
		browser.getObjectByID(userRoleID);
		browser.printalloptions();    //print
		browser.getObjectByID(userRoleID);
		browser.selectOption(value);    //dropdown
	}
	public void setEmpName(String data) {
		browser.getObjectByID(empNameID);
		browser.setText(data);
	}
	public void setuName(String data) {
		browser.getObjectByID(uNameID);
		browser.setText(data);
	}
	public void getStatus(String value)
	{
		browser.getObjectByID(statusID);
		browser.printalloptions();    //print
		browser.getObjectByID(statusID);
		browser.selectOption(value);    //dropdown
	}
	public void setPasswordName(String data) {
		browser.getObjectByID(passwordID);
		browser.setText(data);
	}
	public void setConfPassName(String data) {
		browser.getObjectByID(confirmPasswordID);
		browser.setText(data);
	}
	
	public void clickSaveBtn()
	{
		browser.getObjectByID(savebtnID);
		browser.click();
	}
	
	
	
	

}

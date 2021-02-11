package OrangeCrm;

import com.tt.Base.BasePage;
import com.tt.ui.Browser;

public class OrgLoginPage extends BasePage{
	
	
		String usernameTbID="txtUsername";
		String passwordPfID="txtPassword";
		String loginBtnID="btnLogin";
		String errorMsgID="spanMessage";
		
		public OrgLoginPage(Browser browser) {
			super(browser);
		}
		
		public void setUserName(String data) {
			browser.getObjectByID(usernameTbID);
			browser.setText(data);
		}
		
		public void setPasswoard(String data) {
			browser.getObjectByID(passwordPfID );
			browser.setText(data);
		}
		
	    public void clickOnLoginBtn() {
	    	browser.getObjectByID(loginBtnID);
	    	browser.click();
	    }
	    
	    public String errorMessage() {
	    	browser.getObjectByID(errorMsgID);
			String errorMsg=browser.getText();		
			return errorMsg;
	    }

	


}

package pom;

import com.tt.Base.BasePage;
import com.tt.ui.Browser;

public class LoginPage extends BasePage {
	String usernameTbID = "user-name";
	String passwordPfID = "password";
	String loginBtnID = "login-button";
	String errMsgXP = "//h3[@data-test='error']";

	public LoginPage(Browser browser) {
		super(browser);
	}

	public void setUserName(String data) {
		browser.getObjectByID(usernameTbID);
		browser.setText(data);

	}

	public void setPasword(String data) {
		browser.getObjectByID(passwordPfID);
		browser.setText(data);

	}

	public void clickLogin() {
		browser.getObjectByID(loginBtnID);
		browser.click();

	}

	public String getErrorMessage() {
		browser.getObjectByXP("//h3[@data-test='error']");
		String errorMsg = browser.getText();
		return errorMsg;

	}

}

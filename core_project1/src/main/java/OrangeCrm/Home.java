package OrangeCrm;

import java.util.HashMap;

import com.tt.Base.BaseTest;
import com.tt.ui.Browser;
import com.tt.util.XlUtil;


public class Home  extends BaseTest {
	
	OrgLoginPage lp=null;
	Admin ad = null;
	SearchUser su = null;
	Logout lo=null;
	
	public Home() {
		
	}

	@Override
	public void initializeTest(String url, String testName) {
		browser=new Browser();
		browser.initBrowser();
		browser.launchBrowser(url);
		
		lp=new OrgLoginPage(browser);
		ad = new Admin(browser);
		su=new SearchUser(browser);
		lo=new Logout(browser);
		
		
		testData=new HashMap();
		 r.test(testName);
		 r.setDriver(browser.getDriver());
		 

	}

	@Override
	public void executeTest() {

		lp.setUserName(d("user_name"));
		r.info("Entered username:" + d("user_name"));
		lp.setPasswoard(d("user_password"));
		r.info("Entered password:" + d("user_password"));
		lp.clickOnLoginBtn();
		r.info("Clicked login btn");
		
		ad.getAdminBtn();
		r.info("Get admin page");
		ad.clickAddBtn();
		r.info("Clicked add btn");
		//dropdownbox of user role
		ad.getUserRole("Admin");
		r.info("selected the order by dropdown as:" + "Admin");
		
		ad.setEmpName(d("emp_name"));
		r.info("Entered employeename:" + d("emp_name"));
		ad.setuName(d("name_user"));
		r.info("Entered username:" + d("name_user"));
		//dropdown box of status
		ad.getStatus("Enabled");
		r.info("selected the order by dropdown as:" + "Enabled");
		
		ad.setPasswordName(d("pass_name"));
		r.info("Entered password:" + d("pass_name"));
		ad.setConfPassName(d("conpass_name"));
		r.info("Entered confirm password:" + d("conpass_name"));
		ad.clickSaveBtn();
		
		su.setName(d("us_name"));
		r.info("Entered username:" + d("us_name"));
		su.getRole("Admin");
		r.info("selected the order by dropdown as:" + "Admin");
		su.setEName(d("e_name"));
		r.info("Entered employee name:" + d("e_name"));
		su.getempStatus("Enabled");
		r.info("selected the order by dropdown as:" + "Enabled");
		su.clickSearchBtn();
		r.info("Clicked search btn");
		
		lo.clickLogout();
		r.info("Clicked logout btn");
		
	}

	@Override
	public void setTestData(String... arg) {


	}

	@Override
	public void prepareTestData(String filePath) {
		XlUtil xl = new XlUtil(filePath);
		testData=new HashMap();
		
		//getting data from "Data" sheet
		testData.put("emp_name", xl.getCellValue("Employee Name", 1));
		testData.put("name_user", xl.getCellValue("User Name", 1));
		testData.put("pass_name", xl.getCellValue("Password", 1));
		testData.put("conpass_name", xl.getCellValue("Confirm Password", 1));
		
		testData.put("e_name", xl.getCellValue("Employee Name", 1));
		testData.put("us_name", xl.getCellValue("User Name", 1));
		

		xl.close();
		
	}

	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		
	}
}

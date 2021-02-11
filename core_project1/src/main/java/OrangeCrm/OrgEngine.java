package OrangeCrm;

import com.tt.Base.BaseTest;
import com.tt.util.DateUtil;
import com.tt.util.Env1Properties;
import com.tt.util.Reporter;

public class OrgEngine {
public static void main(String[] args) {
		
		Env1Properties ep = new Env1Properties("C:\\\\selenium\\\\env1.Properties");
		
		String applicationURL =ep.getPropertyValue("app_url");
		Reporter r = new Reporter("C:\\selenium\\","DemoReporter"+DateUtil.getCurrentDate("ddMMMyyy-HH-mm-ss+")+".html");
		
		BaseTest bt=new Home();
		bt.setReporter(r);
		bt.initializeTest(applicationURL, "Verify if my product is logged in");
		bt.prepareTestData("C:\\selenium\\orange.xlsx");
		bt.setTestData("user_name",ep.getPropertyValue("user_name"));
		bt.setTestData("user_password",ep.getPropertyValue("user_password"));
		
		bt.executeTest();
		r.flush();
		
		
		
		
	}


}

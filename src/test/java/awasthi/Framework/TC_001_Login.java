package awasthi.Framework;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import awasthi.PageObject.LoginPageObject;
 public class TC_001_Login extends Base {
	
	

@SuppressWarnings("deprecation")
@Test

public void VerifyLogin() {
	LoginPageObject login=new LoginPageObject(driver);
	 driver.get(url);
	 logger.info("url is open");
	// driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	login.userId(Buserid);
	 logger.info("enter user name");
	login.userPassword(Buserpassword);
	 logger.info("enter password");
	login.userSubmit();
	 logger.info("form is submitting");
	System.out.println(driver.getTitle());
	if(driver.getTitle().equals(Btitle)) {
		Assert.assertTrue(true);
		 logger.info("Testcase passed");
	}
	else {
		TakeScreenShot();
		 logger.info("Testcase failed");
		Assert.assertTrue(false);
		
	}
	
}


	
}

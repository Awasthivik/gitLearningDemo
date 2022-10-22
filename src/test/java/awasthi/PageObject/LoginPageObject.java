package awasthi.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	WebDriver driver;
	@FindBy(xpath="//input[@name='uid']")
	WebElement userId;
	@FindBy(xpath="//input[@name='password']")
	WebElement userPassword;
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement submit;
	@FindBy(css="input[name='btnReset']")
	WebElement reset;
	public LoginPageObject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void userId(String userid) {
		userId.sendKeys(userid);

	}
	public void userPassword(String password) {
		userPassword.sendKeys(password);
	}
	public void userSubmit() {
		submit.click();
	}
	public void userReset() {}
	
	
	

}

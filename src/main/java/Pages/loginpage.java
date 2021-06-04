package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class loginpage extends TestBase{

	//page Factory
	//FindBy
	
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy(id="divLogo")
	WebElement logo;
	
//Initialize the page objects
	public loginpage(){
		//To initilize findby we have to use the initments method.
		PageFactory.initElements(driver, this);
	}
	
	//Actions or methods
	
	public String validateloginpageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean verifyHRMLog(){
		return logo.isDisplayed();
		
	}
	
	
	public Homepage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new Homepage();
	}
	
	
	
	
}

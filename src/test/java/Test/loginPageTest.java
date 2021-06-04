package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Homepage;
import Pages.loginpage;

public class loginPageTest extends TestBase {

	loginpage loginpa;
	Homepage homepage;

	public loginPageTest() {
		super();

	}

	@BeforeMethod
	public void SetUp() {

		Initialization();
		loginpa = new loginpage();
	}

	@Test(priority = 1)
	public void loginpageTitle_Test() {
		String title = loginpa.validateloginpageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");

	}

	@Test(priority = 2)
	public void logoTest() {
		boolean flag = loginpa.verifyHRMLog();

		System.out.println(flag);
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void loginTest()  {

		// homepage=loginpa.login(prop.getProperty("username"),
		// (prop.getProperty("password")));
		homepage=loginpa.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}

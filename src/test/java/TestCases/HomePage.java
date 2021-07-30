package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObjects.LoginPage;
import pageObjects.landingPage;

public class HomePage extends BaseClass {
	//helpful for parallel execution
	public WebDriver driver;
	public Logger log=LogManager.getLogger(HomePage.class.getName());


	@BeforeTest
	public void initiateBrowser() throws IOException {

		driver = initializeBrowser();
		
	}

	@Test(dataProvider = "getData")
	public void BasePageNav(String username, String Password) throws IOException {
		//prop.getProperty(Password)
		driver.get(prop.getProperty("url"));


		landingPage lp = new landingPage(driver);
		//Assert.assertEquals(lp.title().getText(), "FEATURED COURSES");
		lp.login().click();
		LoginPage l = new LoginPage(driver);
		l.email().sendKeys(username);
		l.password().sendKeys(Password);
		l.loginButton().click();
		
		log.info("logged in");

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] obj = new Object[3][2];
		obj[0][0] = "abc@abc.com";
		obj[0][1] = "aablcd133";

		obj[1][0] = "xyz@abc.com";
		obj[1][1] = "aablcd133";

		obj[2][0] = "abc@xyz.com";
		obj[2][1] = "aablcd133";  

		return obj;

	}

	@AfterTest
	public void Teardown() {

		driver.close();
	}

}

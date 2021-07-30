package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObjects.landingPage;

public class ValidateNavigationBar extends BaseClass {
	public WebDriver driver;
	public Logger log=LogManager.getLogger(ValidateNavigationBar.class.getName());

	@BeforeTest
	public void initiateBrowser() throws IOException {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void ValidateNavigationBartitle() throws IOException {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));

		landingPage lp = new landingPage(driver);
		//Assert.assertTrue(lp.NavigationBar().isDisplayed());
		Assert.assertEquals(lp.title().getText(),"FEATURED COURSES123");
		log.info("Navigation bar successfull");

	}

	@AfterTest
	public void Teardown() {

		driver.close();
	}

}

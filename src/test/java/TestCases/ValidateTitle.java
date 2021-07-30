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

public class ValidateTitle extends BaseClass {
	public Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initiateBrowser() throws IOException {

		driver = initializeBrowser();
		log.info("initializing browser");
		driver.get(prop.getProperty("url"));
		log.debug("hitting URL");

	}

	// WebDriver driver;
	@Test
	public void ValidateTitle1() throws IOException {

		landingPage lp = new landingPage(driver);
		Assert.assertEquals(lp.title().getText(), "FEATURED COURSES");
		log.debug("assert result");

	}

	@AfterTest
	public void Teardown() {

		driver.close();
	}
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;

	public landingPage(WebDriver driver) {

		this.driver = driver;

	}

	By login = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//*[@id='content']/div/div/h2");
	By NavigationBar = By.cssSelector(".nav.navbar-nav.navbar-right");

	public WebElement login() {

		return driver.findElement(login);

	}

	public WebElement title() {

		return driver.findElement(title);

	}

	public WebElement NavigationBar() {

		return driver.findElement(NavigationBar);

	}

}

package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Properties prop ;

	public WebDriver initializeBrowser() throws IOException {

		FileInputStream fil = new FileInputStream(
				"E:\\Ex_Files_Selenium_EssT\\WorkSpace\\DemoFrameworkBuild\\src\\main\\java\\BaseClass\\browser.properties");
		 prop = new Properties();
		prop.load(fil);
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			
			
		} else {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return driver;
	}
	
	
	public void getScreenshotPath(String methodName,WebDriver driver) throws IOException {
		
		TakesScreenshot t=(TakesScreenshot)driver;
		File source=t.getScreenshotAs(OutputType.FILE);
	String destination=System.getProperty("user.dir")+"\\reports\\"+methodName+".png";
		
		FileUtils.copyFile(source, new File(destination));
		
		
	}

}

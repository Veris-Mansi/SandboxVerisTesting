package Basics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollingTest {

	WebDriver driver;
	@BeforeTest
	public  void initialize()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("driver.get(\"http://jqueryui.com\");\r\n" + 
				"  \r\n" + 
				" ");
		driver.manage().window().maximize();

	}
	@Test
	public void scrollTest() throws InterruptedException
	{
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("scroll(0,400");
	}
}

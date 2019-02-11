package veris_sandbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompleteAppTesting {

	static WebElement element;
	static WebDriver driver;
	@BeforeTest
	public static void initialize()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://sandbox.veris.in/vms/register/");
		driver.manage().window().maximize();

	}

}

package veris_initialize;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeDriver {

	public static void initialize()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		driver.get("https://sandbox.veris.in/vms/register/");
		driver.manage().window().maximize();

	}
}

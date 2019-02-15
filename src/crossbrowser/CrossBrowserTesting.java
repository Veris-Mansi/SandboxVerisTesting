package crossbrowser;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	WebDriver driver=null;
	@Test
	public void Test1() throws InterruptedException
	{
		System.out.println("Inside test1 | "+Thread.currentThread().getId());
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"u_0_j\"]")).sendKeys("MAnsi");
		Thread.sleep(5000);
		driver.close();
	}
	@Test
	public void Test2() throws InterruptedException
	{
		System.out.println("Inside test2|  "+Thread.currentThread().getId());
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("MAnsi");
		Thread.sleep(5000);
		driver.close();
	}
}

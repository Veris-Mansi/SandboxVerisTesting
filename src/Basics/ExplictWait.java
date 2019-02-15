package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplictWait {
	WebDriver driver;
	@BeforeTest
	public  void initialize()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.manage().window().maximize();

	}
	@Test
	public void ExplicitlyWaiting()
	{
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		WebElement element=driver.findElement(By.xpath("//p[text()='WebDriver']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element2 = wait.until(ExpectedConditions.visibilityOf(element));
		if(element2.isDisplayed())
		{
			System.out.println("Element diplayed");
		}
		else
		{
			System.out.println("No elemnet present");
		}
	}
}

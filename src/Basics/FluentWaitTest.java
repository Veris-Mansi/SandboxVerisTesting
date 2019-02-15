package Basics;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
public class FluentWaitTest {
	WebDriver driver;
	@BeforeTest
	public  void initialize()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.manage().window().maximize();

	}
	@org.testng.annotations.Test
	public void Test()
	{
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		//WebElement element=driver.findElement(By.xpath("//p[text()='WebDriver']"));
		//polling wuill check after every 1 second
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
		.withTimeout(30,TimeUnit.SECONDS)
		.pollingEvery(1,TimeUnit.SECONDS).
		ignoring(NoSuchElementException.class);
		//This function takes parameter as webdriver ad returns the web element
		WebElement element=wait.until(new Function<WebDriver ,WebElement >(){
			@Override
			public WebElement apply(WebDriver driver)
			{
				WebElement ele=driver.findElement(By.xpath("//p[@id='demo']"));
				String s= ele.getAttribute("innerHTML");
				if(s.equalsIgnoreCase("WebDriver"))
				{
				return ele;
				}
				else
				{
					System.out.println("Value "+s);
					return null;	//if it is returning null then it will keep looping
				}
			}
		});
		
		boolean status=element.isDisplayed();
		if(status)
		{
			System.out.println("Element dispalyed");
		}
		else
		{
			System.out.println("ELement not displayed");
		}
	}
}

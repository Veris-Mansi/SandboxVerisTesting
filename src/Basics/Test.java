package Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class Test {


	WebDriver driver;
	WebElement element;
	@BeforeTest
	public void initialize()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

	}
	@org.testng.annotations.Test
	public void SignUp() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[class^='inputtext'][name='firstname']")).sendKeys("MAnsi");
		driver.findElement(By.cssSelector("input#u_0_l")).sendKeys("sahu");
		driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("9993483676");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Veris@123");
		element=driver.findElement(By.cssSelector("select#day"));
		
		Select select=new Select(element);
		List<WebElement> month_list=select.getOptions();
		System.out.println("Elements are ");
		for(int i=0;i<month_list.size();i++)
		{
			element=month_list.get(i);
			String tx=element.getText();
			System.out.println(tx);
			if(tx.equals("19")) {
				element.click();
			}
		}
		Thread.sleep(1000);
		select.selectByVisibleText("15");
		element = driver.findElement(By.xpath("//*[@id=\"month\"]"));
		Select s=new Select(element);
		s.selectByIndex(2);
		element=driver.findElement(By.xpath("//*[@id='year']"));
		Select s2=new Select(element);
		s2.selectByValue("1996");
	}
}

package Basics;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MmtTesting {
	WebDriver driver;
	@BeforeTest
	public  void initialize()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

	}
	@Test
	public void Test1() throws InterruptedException
	{
		//driver.findElement(By.xpath("//input[@class='input_fromto checkSpecialCharacters ui-autocomplete-input' and @id='hp-widget__sfrom']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='input_fromto checkSpecialCharacters ui-autocomplete-input' and @id='hp-widget__sfrom']"))).click();
		List<WebElement> myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-1']/li[@class='ui-menu-item']/div/p/span[@class='autoCompleteItem__label']")));
		for (WebElement element:myList)
		{
		    if(element.getText().contains("Mumbai"))
		        element.click();
		    
		}
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='input_fromto checkSpecialCharacters ui-autocomplete-input' and @id='hp-widget__sTo']"))).click();
		List<WebElement> myList1 = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-2']/li[@class='ui-menu-item']/div/p/span[@class='autoCompleteItem__label']")));
		for (WebElement element:myList1)
		{
		   System.out.println(element.getText());		    
		}
			}
}
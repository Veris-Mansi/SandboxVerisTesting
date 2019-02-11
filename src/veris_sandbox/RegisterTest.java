package veris_sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest {

	static WebDriver driver;
	static WebElement element;
	@BeforeTest
	public static void initialize()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://sandbox.veris.in/vms/register/");
		driver.manage().window().maximize();

	}
	@Test(priority=1,description="Empty Email")
	public static void EmptyEmail() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
		element= driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input"));
		String msg = element.getAttribute("validationMessage");
		Assert.assertEquals("Please fill out this field.", msg);
		Thread.sleep(1000);
		driver.navigate().refresh();
	}
	@Test(priority=2,description="Incorrect Email",dependsOnMethods="EmptyEmail")
	public static void IncorrectEmail() throws InterruptedException
	{
		element=driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input"));
		element.sendKeys("john");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/div/div[2]/button")).click();
		Thread.sleep(1000);
		String actual_msg2=element.getAttribute("validationMessage");
		String expected="Please include an '@' in the email address. 'john' is missing an '@'.";
		Assert.assertEquals(actual_msg2,expected);
	    //System.out.println("msg2 "+msg2);
	    Thread.sleep(1000);
		driver.navigate().refresh();
	  
	}
	@Test(priority=3,description="Email with 2 @ symbols",dependsOnMethods="IncorrectEmail")
	public static void Syntaticallyincorrect() throws InterruptedException
	{
		element=driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input"));
		element.sendKeys("john@g@");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/div/div[2]/button")).click();
		Thread.sleep(1000);
		String actual_msg2=element.getAttribute("validationMessage");
		String expected="A part following '@' should not contain the symbol '@'.";
		//Assert.assertEquals(actual_msg2,expected);
	    System.out.println("msg2 "+actual_msg2);
	    Thread.sleep(1000);
		driver.navigate().refresh();
	  
	}
	@Test(priority=4,dependsOnMethods="Syntaticallyincorrect",description="Not accepting the terms")
	public static void Termsnotaccepted() throws InterruptedException
	{
		WebElement element= driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input"));
		element.sendKeys("m@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/div/div[2]/button")).click();
		Thread.sleep(2000);
		String msg=driver.findElement(By.xpath("//*[@id=\"checkbox-signup\"]")).getAttribute("validationMessage");
		Assert.assertEquals(msg, "Please check this box if you want to proceed.");
		Thread.sleep(1000);
		driver.navigate().refresh();
	}
	@Test(priority=5,dependsOnMethods="Termsnotaccepted",description="Clicking Already have account")
	public static void Alreadyhaveaccount() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/div/div[1]/a")).click();
		Thread.sleep(8000);
		driver.navigate().refresh();
		String title=driver.getTitle();
		System.out.println("title "+title);
		Assert.assertEquals(title, "Veris View | Login");
		Thread.sleep(1000);
		driver.navigate().back();
		
	}
	@Test(priority=6,description="Correct registration",dependsOnMethods="Alreadyhaveaccount")
	public static void SuccessfullyRegistered(WebDriver driven,WebElement element,String email) throws InterruptedException
	{
		element= driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input"));
		element.clear();
		element.sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"checkbox-signup\"]")).click();
		Thread.sleep(2000);
		element =driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/div/div[2]/button"));
		element.click();
		Thread.sleep(10000);
		driver.navigate().refresh();
		String title=driver.getTitle();
		System.out.println("title "+title);
		Assert.assertEquals(title, "Veris View | Login");
		
	}
}

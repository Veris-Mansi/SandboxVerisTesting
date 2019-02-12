package veris_sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import veris_initialize.Resource;

public class LoginTest {

	WebDriver driver;
	WebElement element;
	@BeforeTest
	public void initialize()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://sandbox.veris.in/vms/login/");
		driver.manage().window().maximize();

	}
	@Test(description="EmptyEmail")
	public void emptyEmail() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input")).sendKeys("");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"submit-button\"]/button")).click();
		Thread.sleep(1000);
		String msg=driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input")).getAttribute("validationMessage");
		Assert.assertEquals(msg, "Please fill out this field.");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	@Test(description="EmptyPassword",dependsOnMethods="emptyEmail")
	public void emptyPassword() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input")).sendKeys("mansi.sahu@veris.in");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/input")).sendKeys("");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"submit-button\"]/button")).click();
		Thread.sleep(1000);
		String msg=driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/input")).getAttribute("validationMessage");
		Assert.assertEquals(msg, "Please fill out this field.");
		driver.navigate().refresh();
		Thread.sleep(1000);
		
	}
	@Test(priority=3,description="invalid credentials login",dependsOnMethods="emptyPassword")
	public void invalidCredentials() throws InterruptedException
	{
		element=driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input"));
		element.sendKeys("mansi.sahu@veris.in");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/input")).sendKeys("Vs@12345");
		Thread.sleep(1000);
		element=driver.findElement(By.xpath("//*[@id=\"submit-button\"]/button"));
		element.click();
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/h2")).getText();
		Assert.assertEquals(text, "Log In");
		Thread.sleep(1000);
		driver.navigate().refresh();
	}
	@Test(priority=4,description="forgot password",dependsOnMethods="invalidCredentials")
	public void forgotPassword() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[3]/div/div[2]/div/div[2]/a")).click();
		Thread.sleep(5000);
		String msg = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/h2")).getText();
		Assert.assertEquals(msg, "Forgot Password ?");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[1]/div/input")).sendKeys("mansi.sahu@veris.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[2]/div/div/button/span")).click();
		Thread.sleep(5000);
		String actual_title=driver.getTitle();
		Assert.assertEquals(actual_title, "Veris View | Login");
	}

	@Test(priority=5,description="valid credentials login",dependsOnMethods="forgotPassword")
	public void CorrectLogin() throws InterruptedException
	{
		Resource.ValidLogin(driver, element, "zinijecahi@getcoolmail.info", "Veris@12345");
		String actual_title=driver.getTitle();
		String expected_title="Veris View | Setup Organization";
		Assert.assertEquals(actual_title, expected_title);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
}

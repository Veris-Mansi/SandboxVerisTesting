package veris_sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import veris_initialize.Resource;

public class Logout {
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
	@Test
	public void Login() throws InterruptedException
	{
		Resource.ValidLogin(driver, element, "mansi.sahu@veris.in", "Veris@12345");
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Veris View | Activity Reports");
	}
	@Test(dependsOnMethods="Login",description="Logout Button Testing")
	public void Logout() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"navbarUserProfilePic\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[2]/div/div/ul[1]/li/ul/li[3]/a")).click();
		Thread.sleep(3000);
		String title=driver.getTitle();
		System.out.println("title "+title);
		Assert.assertEquals(title, "Veris View | Login");
	}
}

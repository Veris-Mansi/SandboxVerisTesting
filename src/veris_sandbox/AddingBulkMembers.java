package veris_sandbox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import veris_initialize.Resource;

public class AddingBulkMembers {

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
	@Test(priority=1)
	public void Login() throws InterruptedException
	{
		Resource.ValidLogin(driver, element, "mansi.sahu@veris.in", "Veris@12345");
		Thread.sleep(10000);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Veris View | Activity Reports");
		Thread.sleep(1000);
	}
	@Test(priority=2,dependsOnMethods="Login",description="Opening Member Book page")
	public void OpeningMemberBook() throws InterruptedException
	{
        Actions builder = new Actions(driver);
        WebElement mouseElement=driver.findElement(By.xpath(".//*[@id='sidebar-menu']/ul/li[6]/a/i"));
        //move the cursor move to mouse element
        
        builder.moveToElement(mouseElement).build().perform();
        ////move the cursor to the member keyword  and click on it then perform the build aand perform task.
        mouseElement=driver.findElement(By.xpath(".//*[@id='sidebar-menu']/ul/li[6]/ul/li[1]/a/span"));
        builder.moveToElement(mouseElement).click().build().perform();		
        Thread.sleep(5000);
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Veris | MemberBook");
	}
	@Test(priority=3,dependsOnMethods="OpeningMemberBook")
	public void addBulkMembers() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"bulk_tab\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"bulkUploadFile\"]")).sendKeys("D:\\memberUpload.csv");;
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div[3]/div[2]/div")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
	}
}

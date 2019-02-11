package veris_sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrganizationTesting {
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
	public void ValidLogin() throws InterruptedException
	{
		element=driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input"));
		element.clear();
		element.sendKeys("mansi.sahu@veris.in");
		element=driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/input"));
		element.clear();
		element.sendKeys("Veris@12345");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"submit-button\"]/button")).click();
		Thread.sleep(8000);
		driver.navigate().refresh();
		String actual_title=driver.getTitle();
		String expected_title="Veris View | Setup Organization";
		Assert.assertEquals(actual_title, expected_title);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	@Test(dependsOnMethods="ValidLogin")
	public void LogOutButton() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/a")).click();
		Thread.sleep(5000);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Veris View | Login");
		Thread.sleep(1000);
		ValidLogin();
		Thread.sleep(1000);

	}
	@Test(description="empty organization",dependsOnMethods= "LogOutButton")
	public void emptyOrganization() throws InterruptedException
	{
		driver.findElement(By.name("name")).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"newOrgForm\"]/div[5]/button[1]")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//*[@id=\"name-error\"]")).getText();
		Assert.assertEquals(text, "Please enter your Organisation Name");
		Thread.sleep(500);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	@Test(description="empty description",dependsOnMethods= "emptyOrganization")
	public void emptyDescription() throws InterruptedException
	{
		driver.findElement(By.name("name")).sendKeys("Veris");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"newOrgForm\"]/div[5]/button[1]")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//*[@id=\"description-error\"]")).getText();
		Assert.assertEquals(text, "This field is required.");
		Thread.sleep(500);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	@Test(description="empty Image",dependsOnMethods= "emptyDescription")
	public void emptyImage() throws InterruptedException
	{
		driver.findElement(By.name("name")).sendKeys("Veris");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("hello");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"newOrgForm\"]/div[5]/button[1]")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//*[@id=\"org_logo-error\"]")).getText();
		Assert.assertEquals(text, "Select Image");
		Thread.sleep(500);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods="emptyImage")
	public void correctCredentials() throws InterruptedException
	{
		driver.findElement(By.name("name")).sendKeys("Veris_Digicred");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("Creates Visitor management System");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"org_logo\"]")).sendKeys("D:\\organization.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Sector 48, Gurugram");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"newOrgForm\"]/div[4]/div/div[1]/input[2]")).sendKeys("Gurgaon");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"newOrgForm\"]/div[4]/div/div[1]/input[3]")).sendKeys("122001");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"newOrgForm\"]/div[4]/div/div[1]/input[4]")).sendKeys("Haryana");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"newOrgForm\"]/div[4]/div/div[1]/input[5]")).sendKeys("India");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"newOrgForm\"]/div[5]/button[1]")).click();
		System.out.println("Button clicked");
		Thread.sleep(2000);
	}
}

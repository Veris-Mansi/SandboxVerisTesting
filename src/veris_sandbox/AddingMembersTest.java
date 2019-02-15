package veris_sandbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import veris_initialize.Resource;

public class AddingMembersTest {
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
	@Test(priority=3,dependsOnMethods="OpeningMemberBook",description="Adding single member")
		public void AddMember() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"single_tab\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"f_name\"]")).sendKeys("Sandeep");
		driver.findElement(By.xpath("//*[@id=\"l_name\"]")).sendKeys("Babbar");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("sandeep.babbar@veris.in");
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("+919927410623");
		Thread.sleep(1000);
		WebElement el =driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div[2]/div/form/div[5]/div/div/div[1]/div[1]"));
		WebElement el2=driver.findElement(By.xpath("//*[@id=\"designation\"]"));
		Thread.sleep(1000);
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",el2);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(el)).click();
		
		WebElement el4= new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/div[@class='css-10nd86i']/div[@class='css-153kavv']/div[@class='css-11unzgr")));
		System.out.println("Element fund");
		JavascriptExecutor jsq= (JavascriptExecutor)driver;
		jsq.executeScript("document.getElementById(\"react-select-2-option-0\").click()",el4);
//		List<WebElement> list =new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='form-group']/div[@class='css-10nd86i']/div[@class='css-153kavv']/div[@class='css-11unzgr'")));
//		System.out.println("size "+list.size());
//		
//		for(int i=0;i<list.size();i++)
//		{
//			WebElement el1=list.get(i);
//			System.out.println(el1.getAttribute("innerHTML"));
//		}
		
		//new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div[2]/div/form/div[5]/div/div/div[1]/div[1]/div[1]/div[0]/div[0]"))).click();
		//.WebElement el3 =driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div[2]/div/form/div[5]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]"));
		//el3.click();
		
		//JavascriptExecutor jsq= (JavascriptExecutor)driver;
		
		
         //jsq.executeScript("()=>console.log('hey)", element);
		
		//WebDriverWait wait= new WebDriverWait(driver, 20);
//		List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("div[@class='form-group']/div[@class='css-10nd86i']/div[@class='css-153kavv']")));
//		System.out.println("Elements are ");
//		////div[@class='form-group']/div[@class='css-10nd86i']/div[@class='css-153kavv']
//		for(int i=0;i<list.size();i++)
//		{
//			System.out.println(list.get(i).getText());
//		}
	}

	}


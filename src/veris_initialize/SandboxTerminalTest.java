package veris_initialize;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SandboxTerminalTest {

	public static void main(String args[]) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://sandbox-terminal.veris.in/");
		driver.manage().window().maximize();


	try
		{
		WebElement element ;
		
		element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/input"));
		element.sendKeys("TYPE7");
		System.out.println("Able to type the user id");
		element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[3]/input"));
		element.sendKeys("1");
		System.out.println("Able to type the password");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[5]/div/div")).click();
		driver.findElement((By.cssSelector(".rn-1i6wzkk"))).click();
		Thread.sleep(10000);
		System.out.println("Able to click the login button");
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]")).click();
		element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]"));
		element.click();
		System.out.println("Able to click the check in button");
		//driver.findElement(By.linkText("Check-In")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/input"))).sendKeys("9993483676");
	    Thread.sleep(1000);
	    System.out.println("Able to type the mobile no (VAlid)");
	    element = driver.findElement(By.cssSelector("#root > div > div.rn-1awozwy.rn-1efd50x.rn-14skgim.rn-rull8r.rn-mm0ijv.rn-13yce4e.rn-fnigne.rn-ndvcnb.rn-gxnn5r.rn-deolkf.rn-6koalj.rn-16y2uox.rn-1wbh5a2.rn-1ro0kt6.rn-eqz5dr.rn-ifefl9.rn-bcqeeo.rn-wk8lta.rn-9aemit.rn-1mdbw0j.rn-gy4na3.rn-bnwqim.rn-1lgpqti > div > div.rn-1oszu61.rn-14lw9ot.rn-1efd50x.rn-14skgim.rn-rull8r.rn-mm0ijv.rn-13yce4e.rn-fnigne.rn-ndvcnb.rn-gxnn5r.rn-deolkf.rn-6koalj.rn-1qe8dj5.rn-1mlwlqe.rn-18u37iz.rn-61z16t.rn-p1pxzi.rn-11wrixw.rn-1x0uki6.rn-ifefl9.rn-bcqeeo.rn-wk8lta.rn-9aemit.rn-1mdbw0j.rn-gy4na3.rn-bnwqim.rn-1lgpqti > div:nth-child(2)"));
	    element.click();
	    System.out.println("able to click next button");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]")).click();
	    Thread.sleep(5000);
	    System.out.println("Able to click the visitor button");
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[3]/div[2]")).click();
	    System.out.println("Able to click the use image button");
	    
	     Thread.sleep(3000);
	       
	     driver.findElement(By.cssSelector("#root > div > div > div > div > div > div.rn-1oszu61.rn-1efd50x.rn-14skgim.rn-rull8r.rn-mm0ijv.rn-13yce4e.rn-fnigne.rn-ndvcnb.rn-gxnn5r.rn-deolkf.rn-6koalj.rn-16y2uox.rn-1wbh5a2.rn-1ro0kt6.rn-eqz5dr.rn-61z16t.rn-11wrixw.rn-ifefl9.rn-bcqeeo.rn-wk8lta.rn-1mdbw0j.rn-bnwqim.rn-1lgpqti > div > div > div.rn-1awozwy.rn-1kihuf0.rn-rull8r.rn-ndvcnb.rn-mm0ijv.rn-gxnn5r.rn-14skgim.rn-fnigne.rn-1efd50x.rn-13yce4e.rn-deolkf.rn-1loqt21.rn-6koalj.rn-1mlwlqe.rn-eqz5dr.rn-1qe8dj5.rn-1777fci.rn-p1pxzi.rn-11wrixw.rn-61z16t.rn-1mnahxq.rn-ifefl9.rn-bcqeeo.rn-1mdbw0j.rn-gy4na3.rn-9aemit.rn-wk8lta.rn-bnwqim.rn-1otgn73.rn-1i6wzkk.rn-lrvibr.rn-1lgpqti")).click();
	     System.out.println("Able to click the next button");
		 
	     Thread.sleep(2000);
	   // driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/div/div/div[2]")).sendKeys("sha");
	    element =  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/div/div/div[1]/input"));
	    element.sendKeys("sha");
	    System.out.println("Able to write the name");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/div/div/div[1]/div[2]/div/div/div/div/div[1]/div/div/div[1]")).click();
	  //*[@id="root"]/div/div/div/div/div/div[2]/div/div/div[1]/div[2]/div/div/div/div/div[1]/div/div/div[1]
	    
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/div/div/div[2]")).click();
		Thread.sleep(2000);
			List<WebElement> objradio= driver.findElements(By.className("rw-list-option"));
			Thread.sleep(1000);
			System.out.println("Elements are");
			for(WebElement obj:objradio)
			{
				//obj.
				String text=obj.getText();
			
				System.out.println(text);
				if(text.equals("Meeting"))
				{
					boolean b =obj.isSelected();
					if(b == true)
					{
						System.out.println("Already clicked");
					}
					else
					{
						obj.click();
					}
					break;
				}
				else if(text.equals("Invited"))
				{
					boolean b =obj.isSelected();
					if(b == true)
					{
						System.out.println("Already clicked");
					}
					else
					{
						obj.click();
					}
					break;
				}else if(text.equals("Vendor"))
				{
					boolean b =obj.isSelected();
					if(b == true)
					{
						System.out.println("Already clicked");
					}
					else
					{
						obj.click();
					}
					break;
				}
				else if(text.equals("Other"))
				{
					boolean b =obj.isSelected();
					if(b == true)
					{
						System.out.println("Already clicked");
					}
					else
					{
						obj.click();
					}
					break;
				}
				
				
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/div/div[2]/div/div/div[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[4]/div")).click();
			Thread.sleep(10000);
			System.out.println("Login succesful with valid fields");
			//Starting checkout procedure
			//driver.navigate().refresh();
			System.out.println("Starting the checout procedure");
			element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]"));
			element.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/input")).sendKeys("9993483676");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[4]/div")).click();
			Thread.sleep(4000);
			System.out.println("Checkout successful");
			
			System.out.println("Starting the logout procedure");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div/img")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/input")).sendKeys("1");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div")).click();
			Thread.sleep(3000);
	}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("error "+e);
		}
//		
	}
}

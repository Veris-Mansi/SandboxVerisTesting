package veris_initialize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Resource {
	
	public static void ValidLogin(WebDriver driver,WebElement element,String email,String password) throws InterruptedException
	{
		element=driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input"));
		element.clear();
		element.sendKeys(email);
		element=driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/input"));
		element.clear();
		element.sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"submit-button\"]/button")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
	}
}

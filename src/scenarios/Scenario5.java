package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scenario5 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}
	@Test
	public static void M5() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com");
		Actions a=new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//Implicit Wait
		
		WebElement menu = driver.findElement(By.xpath("//li[@class='menuparent repb']/a[contains(.,'Rings')]"));
		a.moveToElement(menu).perform();
		driver.findElement(By.xpath("//ul[@class='two-col']/li/a[@title='Diamond Rings']")).click();
	}

}

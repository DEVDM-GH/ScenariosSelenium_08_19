package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scenario7 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}

	@Test
	public void kada() throws InterruptedException {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.bluestone.com/");
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[contains(.,'All Jewellery')]"))).perform();
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.xpath("//span[contains(.,'Kadas')]"));
		a.moveToElement(ele).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//img[@alt='The Amit Kada For Him']")).click();
		
		driver.findElement(By.id("buy-now")).click();
		
		String str="Shopping Bag | BlueStone.com";
		
		System.out.println(driver.findElement(By.xpath("//div[@class='formErrorContent']")).getText());
		
		driver.close();
	}
	

}

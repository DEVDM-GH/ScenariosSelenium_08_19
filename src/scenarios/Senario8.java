package scenarios;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Senario8 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}

	@Test
	public static void M8() throws InterruptedException, AWTException

	{
		WebDriver driver = new ChromeDriver();// casting
		driver.manage().window().maximize();// maximize the browser window
		Actions a = new Actions(driver);
		driver.navigate().to("https://www.bluestone.com/");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//li[@class='active']/span[contains(.,'Kadas')]"));
		a.moveToElement(ele).perform();
		Thread.sleep(2000);

		WebElement ele1 = driver.findElement(By.xpath("//li[@class='menuparent']/a"));
		Thread.sleep(2000);
		a.moveToElement(ele1).perform();
		a.doubleClick(ele1).perform();
		List<WebElement> ele3 = driver.findElements(By.xpath("//div[@class='p-image']/a/img"));
		ele3.get(2).click();

		driver.findElement(By.xpath("//span[@class='size-box-overlay']")).click();
		driver.findElement(By.xpath("//li[@data-key='06']")).click();

		driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
	}

}

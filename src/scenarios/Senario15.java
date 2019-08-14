package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Senario15 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}
	@Test
	public static void M15() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//Implicit Wait
		
		
		Actions mh=new Actions(driver);
		WebElement gc = driver.findElement(By.xpath("//li[@id='goldCoins']/a[contains(.,'Gold Coins')]"));
		mh.moveToElement(gc).perform();
		
		driver.findElement(By.xpath("//span[@data-p='gold-coins-weight-2gms,m']")).click();
		WebDriverWait ww=new WebDriverWait(driver , 10);
		if(ww.until(ExpectedConditions.titleContains("2 gram 24 KT Gold Coin"))) {
			System.out.println("Successfully selected 2 gram 24 KT Gold Coin");
		}
		
		driver.close();
	}
}

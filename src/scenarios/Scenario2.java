package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Scenario2 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}
	@Test
	public static void M2() {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//Implicit Wait
		
		WebElement id = driver.findElement(By.id("identifierId"));
		id.sendKeys("dhamanasapa18@gmail.com");
		WebElement clickId = driver.findElement(By.id("identifierNext"));
		clickId.click();
		
		driver.findElement(By.name("password")).sendKeys("madaautkde");// constructor chaining
		driver.findElement(By.id("passwordNext")).click();
		
		WebDriverWait ww=new WebDriverWait(driver , 10);
		if(ww.until(ExpectedConditions.titleContains("Inbox"))) {
			System.out.println("Successfully Logged In using Username and Password");
		}
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("jalegakoyala@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("This is surely an Automated Mail.");
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("If You Are getting this mail. Then you are in some serious trouble...");
		driver.findElement(By.xpath("//tbody/tr/td/div//div[@id=':9u']")).click();
	}	
}

package scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scenario1 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}
	@Test
	public static void M1() {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//Implicit Wait
		Actions a=new Actions(driver);//object creation of Action class
		
		WebElement id = driver.findElement(By.id("identifierId"));
		id.sendKeys("dhamanasapa18@gmail.com");
		WebElement clickId = driver.findElement(By.id("identifierNext"));
		clickId.click();
		
		driver.findElement(By.name("password")).sendKeys("madaautkde");// constructor chaining
		driver.findElement(By.id("passwordNext")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Primary']")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//tbody/tr[@jsmodel='nXDxbd']"));
		System.out.println("No. of mails: "+ele.size());
		//System.out.println("Press Enter to write the index of mail you want to choose:");
		int i=1;
		List<WebElement> ele2 = driver.findElements(By.xpath("//tbody/tr[@jscontroller='ZdOxDb']["+i+"]/td/div[@class='yW']/child::*/child::*"));
		for (WebElement sender : ele2) {
			System.out.println("Subject of the mail is: "+sender.getText());
		}
		List<WebElement> ele3 = driver.findElements(By.xpath("//tbody/tr[@jscontroller='ZdOxDb']["+i+"]/td[@tabindex='-1']//div[@class='y6']/child::*/child::*"));
		for (WebElement subject : ele3) {
			System.out.println("Subject of the mail is: "+subject.getText());
		}
	}
}

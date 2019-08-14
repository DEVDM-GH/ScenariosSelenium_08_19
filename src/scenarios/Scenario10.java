package scenarios;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scenario10 {

	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}
	@Test
	public static void M10() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// Implicit Wait

		driver.findElement(By.xpath("//iframe[@id='chat-widget']")).click();

		Thread.sleep(1000);
		Set<String> win = driver.getWindowHandles();
		System.out.println(win.size());
		
		//driver.switchTo().frame("chat-widget");
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='lc-1h9260c eptvlbh0']/input[@id='name']"));
		ele.sendKeys("bashahah");
		
		driver.findElement(By.xpath("//div/input[@id='email']")).sendKeys("dhamanasapa@gmail.com");
		driver.findElement(By.xpath("//div/input[@id='name_146917605549304831']")).sendKeys("9969691234");
		driver.findElement(By.xpath("//form/div/button[@class='lc-yp53ho esv0owm0']")).click();
		Thread.sleep(2000);
		System.out.println("The automated message is as following.");
		System.out.println(
				driver.findElement(By.xpath("//div[@class='lc-1glynz2 eovu8nx0']/span[@class='Linkify']")).getText());

		Thread.sleep(5000);
		driver.close();

	}

}

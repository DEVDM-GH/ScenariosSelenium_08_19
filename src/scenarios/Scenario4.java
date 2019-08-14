package scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scenario4 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}
	@Test
	public static void M4() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.ebay.com/");
		WebElement id = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		id.sendKeys("apple watches");
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a/span[contains(.,'All')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='gh-cat']")).click();

		WebElement e = driver.findElement(By.xpath("//option[contains(.,'Jewelry & Watches')]"));
		// WebElement e = driver.findElement(By.xpath("//select/option[13]"));
		System.out.println(e.getText());
		Thread.sleep(2000);
		// driver.close();
		// driver.navigate().back();
		List<WebElement> item = driver.findElements(By.xpath("//div[@class=\"s-item__info clearfix\"]/a"));
		for (WebElement ele : item) {
			String menu = ele.getText();
			System.err.println(menu);

		}
		WebElement ele = driver.findElement(By.xpath("//ul[@id='gf-l']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);

		js.executeScript("window.scrollBy(0,-400)");
		                
		Thread.sleep(2000);
		driver.close();
	}
}

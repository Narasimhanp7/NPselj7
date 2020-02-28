package TestingPra;

import javax.mail.Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AssignmentTwo {

	@Test(priority=0)
	public static void tripAdvisorRatings(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("​https://www.tripadvisor.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Club Mahindra");
		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@title='Search']//following-sibling::div//a)[1]")));
		driver.findElement(By.xpath("(//input[@title='Search']//following-sibling::div//a)[1]")).click();
		wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Write a review']")));
		driver.findElement(By.xpath("//a[text()='Write a review']")).click();
		driver.switchTo().window(" Write a review - Tripadvisor ");
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath("//img[@alt='Roll over, then click to rate']"))).moveByOffset(160, 32).click().build().perform();
		driver.findElement(By.id("ReviewTitle")).sendKeys("Testing");
		driver.findElement(By.id("ReviewText")).sendKeys("your review Testingyour review Testingyour review Testingyour review Testingyour r"
				+ "eview Testingyour review Testingyour review Testingyour review Testingyour review Testingyour review Testingyour review Testingyour review Testing");
		boolean hotelRatings = driver.findElement(By.xpath("//div[text()='Hotel Ratings']")).isDisplayed(); 
		if(hotelRatings=true){
		build.moveToElement(driver.findElement(By.xpath("//div[text()='Hotel Ratings']"))).moveByOffset(120, 25).click().build().perform();
		build.moveToElement(driver.findElement(By.xpath("//div[text()='Hotel Ratings']"))).moveByOffset(120, 25).click().build().perform();
		build.moveToElement(driver.findElement(By.xpath("//div[text()='Hotel Ratings']"))).moveByOffset(120, 45).click().build().perform();
		}
	}
}

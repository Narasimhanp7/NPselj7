package TestingPra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AssignmentOne {

	
	static int flipkartPrice;
	static int  amazonPrice;
	
	@Test(priority=0)
	public static void amazonPrice() {
	
		System.setProperty("webdriver.chrome.driver", "D:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String expTitleAmazon = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String expTitleFlipkart = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone XR (64GB) - Yellow");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'results for')]")));
		driver.findElement(By.xpath("//a/span[contains(text(),'iPhone XR (64GB) - Yellow')]")).click();
		wt.until(ExpectedConditions.visibilityOf((WebElement) By.id("priceblock_ourprice")));
		driver.switchTo().window("Apple iPhone XR (64GB) - Yellow: Amazon.in: Appario Retail Private Ltd");
		String price = driver.findElement(By.id("priceblock_ourprice")).getText();
		price=price.replace(",", "");
		String[] actPrice = price.split(".");
		amazonPrice=Integer.valueOf(actPrice[0].substring(1,actPrice[0].length()));
		driver.quit();
	}
	
	@Test(priority=1)
	public static void flipkartPrice(){
		System.setProperty("webdriver.chrome.driver", "D:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String expTitleFlipkart = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("iPhone XR (64GB) - Yellow");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Apple iPhone XR (Yellow, 64 GB)']")));
		driver.findElement(By.xpath("//div[text()='Apple iPhone XR (Yellow, 64 GB)']")).click();
		driver.switchTo().window("Apple iPhone XR ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com");
		wt.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("//div[@class='_1vC4OE _3qQ9m1']")));
		String price = driver.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']")).getText();
		flipkartPrice=Integer.valueOf(price.replace(",", "").substring(1, price.length()));
		driver.quit();
	}
	
	@Test(priority=2)
	public static void priceCompare(){
		if(amazonPrice<flipkartPrice){
			System.out.println("Amazon has lesser price");
		} else{
			System.out.println("Flipkart has lesser price");
		}
	}
}

package com.SimpleProject;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	public static WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://orangehrm.com/");
	 
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(Duration.ofSeconds(5));
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.findElement(By.xpath("//button[text()='Allow all']")).click();
	    driver.findElement(By.xpath("//a[text()='Solutions']")).click();
	    WebDriverWait wiat = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Function<WebDriver,Boolean> f = new Function<WebDriver, Boolean>(){

			@Override
			public Boolean apply(WebDriver t) {
				// TODO Auto-generated method stub
				return driver.findElement(By.xpath("(//a[text()='Culture'])[1]")).isDisplayed();
			}
	    };
	    wiat.until(f);
	    driver.findElement(By.xpath("(//a[text()='Culture'])[1]")).click();
	    
	    boolean val = driver.findElement(
	        By.xpath("//a[contains(text(),'Start Your')]")
	    ).isDisplayed();

	    Assert.assertTrue(val);
  }  
}

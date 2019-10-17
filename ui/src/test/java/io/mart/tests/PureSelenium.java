package io.mart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PureSelenium {
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.logfile", "chromedriverlog.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
	}
	
	
	@Test
	public void checkLoginIsPossible() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector(".btn_action")).submit();
		Thread.sleep(10000);
		
		driver.close();
	}
}

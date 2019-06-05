package io.mart.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.mart.pages.InventoryPage;
import io.mart.pages.LoginPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	@BeforeClass
	public void setUp() {
		Config config = ConfigFactory.load();
		
		Configuration.browser = config.getString("browser.type");
		Configuration.baseUrl = config.getString("base.path");
		Configuration.browserCapabilities = prepareCapabilities();
	}
	
	@Test
	public void checkLoginWithCorrectCredentials_succeeds() {
		// Arrange
		LoginPage loginPage = Selenide.open("/", LoginPage.class);
		
		// Act
		InventoryPage inventoryPage = loginPage
				.inputName("standard_user")
				.inputPassword("secret_sauce")
				.pressLogin();
		
		// Assert
		inventoryPage.numberOfProductsIs(6);
	}
	
	
	private DesiredCapabilities prepareCapabilities() {
		return new DesiredCapabilities();
	}
}

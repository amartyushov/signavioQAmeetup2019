package io.mart.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.mart.pages.InventoryPage;
import io.mart.pages.LoginPageWithAllure;
import io.mart.tests.custom.CustomProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginWithSelenoidTest {
	
	@BeforeClass
	public void setUp() {
		Configuration.driverManagerEnabled = false;
		Configuration.browser = CustomProvider.class.getName();
		Configuration.baseUrl = "https://www.saucedemo.com";
	}
	
	
	@Test
	public void checkLoginWithCorrectCredentials_succeeds() {
		// Arrange
		LoginPageWithAllure loginPage = open("/", LoginPageWithAllure.class);
		
		// Act
		InventoryPage inventoryPage = loginPage
				.inputName("standard_user")
				.inputPassword("secret_sauce")
				.pressLogin();
		
		// Assert
		inventoryPage.numberOfProductsIs(6);
	}
}

package io.mart.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.mart.pages.InventoryPage;
import io.mart.pages.LoginPageWithAllure;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginWithAllureTest {
	
	@BeforeClass
	public void setUp() {
		Config config = ConfigFactory.load();
		
		Configuration.browser = config.getString("browser.type");
		Configuration.baseUrl = config.getString("base.path");
		Configuration.browserCapabilities = prepareCapabilities();
		
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
				.screenshots(true)
				.savePageSource(false));
	}
	
	
	@Test
	public void checkLoginWithCorrectCredentials_succeeds() {
		// Arrange
		LoginPageWithAllure loginPage = Selenide.open("/", LoginPageWithAllure.class);
		
		// Act
		InventoryPage inventoryPage = loginPage
				.inputName("standard_user")
				.inputPassword("secret_sauce")
				.pressLogin();
		
		// Assert
		inventoryPage.numberOfProductsIs(6);
	}
	
	@Test
	public void thisTestIsFailing() {
		// Arrange
		LoginPageWithAllure loginPage = Selenide.open("/", LoginPageWithAllure.class);
		
		// Act
		InventoryPage inventoryPage = loginPage
				.inputName("standard_user")
				.inputPassword("secret_sauce")
				.pressLogin();
		
		// Assert
		inventoryPage.numberOfProductsIs(5);
	}
	
	
	private DesiredCapabilities prepareCapabilities() {
		return new DesiredCapabilities();
	}
}

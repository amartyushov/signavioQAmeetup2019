package io.mart.tests.custom;

import java.net.MalformedURLException;
import java.net.URL;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CustomProvider implements WebDriverProvider {
	
	@Override
	public WebDriver createDriver(DesiredCapabilities capabilities) {
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("name", "myCoolTestName");    // session have this name on UI
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.merge(capabilities);
		String remoteSelenoidURL = "http://SELENOID_HOST:SELENOID_PORT/wd/hub"; // please add yourself
		try {
			return new RemoteWebDriver(new URL(remoteSelenoidURL), chromeOptions);
		} catch (final MalformedURLException e) {
			throw new RuntimeException("Unable to create driver in " + remoteSelenoidURL, e);
		}
	}
}
package io.mart.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class LoginPageWithAllure {
	
	@FindBy(id = "user-name")
	private SelenideElement login_field;
	
	@FindBy(id = "password")
	private SelenideElement password_field;
	
	@FindBy(css = ".btn_action")
	private SelenideElement login_btn;
	
	@Step("Set login \"{0}\" at login page")
	public LoginPageWithAllure inputName(String userName){
		login_field.shouldBe(visible).setValue(userName);
		return this;
	};
	
	@Step("Set password \"{0}\" at login page")
	public LoginPageWithAllure inputPassword(String password) {
		password_field.shouldBe(visible).setValue(password);
		return this;
	}
	
	@Step("Pressing login button")
	public InventoryPage pressLogin() {
		login_btn.click();
		return Selenide.page(InventoryPage.class);
	}
}

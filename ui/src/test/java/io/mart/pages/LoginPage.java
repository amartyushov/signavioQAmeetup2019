package io.mart.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
	
	@FindBy(id = "password")
	private SelenideElement password_field;
	
	@FindBy(css = ".btn_action")
	private SelenideElement login_btn;
	
	@FindBy(id = "user-name")
	private SelenideElement login_field;
	
	public LoginPage inputName(String userName){
		login_field.shouldBe(visible).setValue(userName);
		return this;
	};
	
	public LoginPage inputPassword(String password) {
		password_field.shouldBe(visible).setValue(password);
		return this;
	}
	
	public InventoryPage pressLogin() {
		login_btn.click();
		return Selenide.page(InventoryPage.class);
	}
}

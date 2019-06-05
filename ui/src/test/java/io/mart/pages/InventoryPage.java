package io.mart.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryPage {
	
	@FindBy(css = ".inventory_item")
	private ElementsCollection products;
	
	@Step("Check number of products on inventory page is {0}")
	public void numberOfProductsIs(int number) {
		products.shouldHaveSize(number);
	}

}

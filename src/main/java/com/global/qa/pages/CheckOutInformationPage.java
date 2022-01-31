package com.global.qa.pages;

import com.global.qa.support.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckOutInformationPage extends BaseClass {

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement FIRST_NAME;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement LAST_NAME;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement ZIP;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement CONTINUE;

    @FindBy(xpath = "//span[@class='title']")
    WebElement CHECKOUT_OVERVIEW;

    public CheckOutInformationPage() {
        PageFactory.initElements(driver, this);
    }

    public void providePersonalDetails(){
        FIRST_NAME.sendKeys("Marshneel");
        LAST_NAME.sendKeys("Jarande");
        ZIP.sendKeys("E14 123");
        CONTINUE.click();
        Assert.assertEquals(CHECKOUT_OVERVIEW.getText(), "CHECKOUT: OVERVIEW");

    }


}

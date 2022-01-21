package com.global.qa.pages;

import com.global.qa.support.BaseClass;
import com.global.qa.support.ElementsUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseClass {

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement USERNAME;

    @FindBy(xpath = "//input[@id='password']")
    WebElement PASSWORD;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement LOGIN;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void validateLogin() {

        USERNAME.sendKeys("standard_user");
        PASSWORD.sendKeys("secret_sauce");
        LOGIN.click();
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

    }


}

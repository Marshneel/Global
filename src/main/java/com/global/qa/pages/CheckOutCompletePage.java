package com.global.qa.pages;

import com.global.qa.support.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckOutCompletePage extends BaseClass {


    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement THANK_YOU;

    public CheckOutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyCompletion() {
        Assert.assertEquals(THANK_YOU.getText(), "THANK YOU FOR YOUR ORDER");
    }


}

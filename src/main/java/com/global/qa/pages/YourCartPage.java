package com.global.qa.pages;

import com.global.qa.support.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class YourCartPage extends BaseClass {


    @FindBy(xpath = "//button[@id='checkout']")
    WebElement CHECKOUT;

    @FindBy(xpath = "//span[@class='title']")
    WebElement HEADER;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement CART_ITEMS_NUMBER;

    public YourCartPage() {
        PageFactory.initElements(driver, this);
    }

    public void checkout(){
        CART_ITEMS_NUMBER.click();
        Assert.assertEquals(HEADER.getText(),"YOUR CART");

        CHECKOUT.click();
        Assert.assertEquals(HEADER.getText(),"CHECKOUT: YOUR INFORMATION");

    }

}

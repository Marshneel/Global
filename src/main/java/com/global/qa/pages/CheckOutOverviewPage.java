package com.global.qa.pages;

import com.global.qa.support.BaseClass;
import com.global.qa.support.ElementsUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckOutOverviewPage extends BaseClass {

    @FindBy(xpath = "//button[@id='finish']")
    WebElement FINISH;

    @FindBy(xpath = "//span[@class='title']")
    WebElement HEADER;

    public CheckOutOverviewPage() {
        PageFactory.initElements(driver, this);
    }

    public void completePurchase(){
        FINISH.click();
        Assert.assertEquals(HEADER.getText(),"CHECKOUT: COMPLETE!");
    }

}

package com.global.qa.TestCases;

import com.global.qa.support.BaseClass;
import com.global.qa.support.WebModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLab_Tests extends BaseClass {
    WebModel webModel;

    public SwagLab_Tests() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        webModel = new WebModel();

    }

    @Test(priority = 1)
    public void verifySuccessfulLogin() {
        webModel.getLoginPage().validateLogin();

    }

    @Test(priority = 2)
    public void sortProducts() {
        webModel.getLoginPage().validateLogin();
        webModel.getProductsPage().sortProductsLowHigh();
    }

    @Test(priority = 3)
    public void selectCheapestItem() {
        webModel.getLoginPage().validateLogin();
        webModel.getProductsPage().sortProductsLowHigh();
        webModel.getProductsPage().selectCheapestItem();

    }

    @Test(priority = 4)
    public void selectSecondCostliestItem() {
        webModel.getLoginPage().validateLogin();
        webModel.getProductsPage().sortProductsLowHigh();
        webModel.getProductsPage().selectCheapestItem();
        webModel.getProductsPage().selectSecondCostliestItem();

    }

    @Test(priority = 5)
    public void verifyItemsAreAddedToCart() {
        webModel.getLoginPage().validateLogin();
        webModel.getProductsPage().sortProductsLowHigh();
        webModel.getProductsPage().selectCheapestItem();
        webModel.getProductsPage().selectSecondCostliestItem();
        webModel.getProductsPage().verifyItemsAddedToCart();

    }

    @Test(priority = 6)
    public void checkoutPersonalDetails() {
        webModel.getLoginPage().validateLogin();
        webModel.getProductsPage().sortProductsLowHigh();
        webModel.getProductsPage().selectCheapestItem();
        webModel.getProductsPage().selectSecondCostliestItem();
        webModel.getProductsPage().verifyItemsAddedToCart();
        webModel.yourCartPage().checkout();
        webModel.getCheckOutPage().providePersonalDetails();

    }

    @Test(priority = 7)
    public void verifySuccessfulPurchase() {
        webModel.getLoginPage().validateLogin();
        webModel.getProductsPage().sortProductsLowHigh();
        webModel.getProductsPage().selectCheapestItem();
        webModel.getProductsPage().selectSecondCostliestItem();
        webModel.getProductsPage().verifyItemsAddedToCart();
        webModel.yourCartPage().checkout();
        webModel.getCheckOutPage().providePersonalDetails();
        webModel.getCheckOutOverviewPage().completePurchase();
        webModel.getCheckOutCompletePage().verifyCompletion();

    }

    @AfterMethod
    public void tearDown() {
      driver.close();
      driver.quit();
    }


}

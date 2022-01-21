package com.global.qa.support;
import com.global.qa.pages.*;

public class WebModel {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckOutInformationPage checkOutPage;
    private CheckOutOverviewPage checkOutOverviewPage;
    private CheckOutCompletePage checkOutCompletePage;

    public WebModel(){
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        yourCartPage = new YourCartPage();
        checkOutPage = new CheckOutInformationPage();
        checkOutOverviewPage = new CheckOutOverviewPage();
        checkOutCompletePage = new CheckOutCompletePage();

    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
    public ProductsPage getProductsPage() { return productsPage; }
    public YourCartPage yourCartPage() { return yourCartPage; }
    public CheckOutInformationPage getCheckOutPage() { return  checkOutPage;}
    public CheckOutOverviewPage getCheckOutOverviewPage() { return checkOutOverviewPage;}
    public CheckOutCompletePage getCheckOutCompletePage() {return checkOutCompletePage;}


}

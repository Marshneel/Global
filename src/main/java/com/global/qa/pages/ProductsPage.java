package com.global.qa.pages;

import com.global.qa.support.BaseClass;
import com.global.qa.support.ElementsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BaseClass {

    ElementsUtils utils = new ElementsUtils();

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement SORT;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement CART_ITEMS_NUMBER;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    List<WebElement> ADD_TO_CART_BUTTONS;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small btn_inventory']")
    List<WebElement> REMOVE_BUTTONS;

    @FindBy(xpath = "//div[@class='inventory_list']/div")
    List<WebElement> INVENTORY_LIST;



    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    public void sortProductsLowHigh() {

       utils.selectByValue(SORT,"lohi");
    }

    public void selectCheapestItem(){

        ADD_TO_CART_BUTTONS.get(0).click();
        Assert.assertEquals(REMOVE_BUTTONS.get(0).getText(),"REMOVE");

    }

    public void selectSecondCostliestItem(){

        for(int i=0;i<INVENTORY_LIST.size();i++){
            if(i== (INVENTORY_LIST.size()-2)) {
                driver.findElements(By.xpath("//div[@class='inventory_list']/div //button")).get(i).click();
                Assert.assertEquals(driver.findElements(By.xpath("//div[@class='inventory_list']/div //button")).get(i).getText(),"REMOVE");
                 }
            }

    }

    public void verifyItemsAddedToCart(){
        Assert.assertEquals(CART_ITEMS_NUMBER.getText(),"2");

    }



}

package com.global.qa.support;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class ElementsUtils extends BaseClass{

    public static String amount;

    public void selectByValue(WebElement element,String value){
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }


}

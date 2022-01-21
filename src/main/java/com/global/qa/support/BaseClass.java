package com.global.qa.support;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;

    public BaseClass(){
        try {
            prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/test/Resources/config.properties");
            prop.load(fileInputStream);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {

        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
          //  System.setProperty("webdriver.chrome.driver", "DriverFiles//chromedriver");
            driver = new ChromeDriver();

        }
        else if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();

        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

    }


}

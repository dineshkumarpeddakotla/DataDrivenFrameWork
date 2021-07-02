package com.datadrivenframework.base;

import com.datadrivenframework.utility.CrossBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseClass {

    //driver variable is declared
    public static WebDriver driver;

    /**
     * setUp method is used to open browser and navigate to url
     * browser is opened based on parameter value
     * @throws InterruptedException interrupts the execution for certain period
     */
    @Parameters("browserName")
    @BeforeTest //execute before test
    public void setUp(String browserName) throws InterruptedException {
        driver = CrossBrowser.selectDriver(browserName);
        driver.get("https://www.udemy.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    //tearDown method closes all connections
//    @AfterTest //execute after test
    public void tearDown() {
        driver.quit();
    }
}

/*
 *Purpose : Class is implemented to execute the methods before and after test
 *               @BeforeTest is used to execute the method before execute actual test
 *               @AfterTest is used to execute the method after execute actual test
 *               @Parameter is used to provide the value for browser name
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 23-06-2021
 */

package com.datadrivenframework.base;

import com.datadrivenframework.utility.CrossBrowser;
import com.datadrivenframework.utility.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    //driver variable is declared
    public static WebDriver driver;

    /**
     * setUp method is used to open browser and navigate to url
     * browser is opened based on parameter value
     */
    @Parameters("browserName")
    @BeforeTest //execute before test
    public void setUp(String browserName) {
        Log.info("Test is starting");
        Log.info("browser is selecting");
        driver = CrossBrowser.selectDriver(browserName);
        Log.info("Navigating to Url : https://www.udemy.com/");
        driver.get("https://www.udemy.com/");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //tearDown method closes all connections
    @AfterTest //execute after test
    public void tearDown() {
        Log.info("Closing the browser");
        driver.quit();
    }
}

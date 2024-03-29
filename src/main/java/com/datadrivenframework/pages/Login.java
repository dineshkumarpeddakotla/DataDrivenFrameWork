/*
 *Purpose : Class is implemented with pom and page factory model to find the webElements
 *          by using locators in Login Page and different methods are implemented to execute operations
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 23-06-2021
 */

package com.datadrivenframework.pages;

import com.datadrivenframework.base.BaseClass;
import com.datadrivenframework.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Login extends BaseClass {

    //web elements are declared and FindBy annotation is used to find web elements by using locators
    @FindBy(linkText = "Log in")
    public WebElement loginLink;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//INPUT[@id='submit-id-submit']")
    WebElement login;
    @FindBy(xpath = "//a[contains(text(),'Log in to a different account')]")
    public WebElement loginToDifferentAccount;

    //parameterized constructor is used
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this); //initElements method is used from PageFactory class
    }

    /**
     * login method is used to login into application
     * @return page title
     */
    public String login(String emailId, String pass) {
        Log.info("Click on Login Button in Home Page");
        loginLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log.info("Sending Email data");
        email.sendKeys(emailId);
        Log.info("Sending Password");
        password.sendKeys(pass);
        Log.info("Click on Login to submit details ");
        login.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver.getTitle();
    }
}

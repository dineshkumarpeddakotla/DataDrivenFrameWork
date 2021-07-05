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
     * @throws InterruptedException interrupts the execution for certain period
     */
    public String login(String emailId, String pass) throws InterruptedException {
        loginLink.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        email.sendKeys(emailId);
        password.sendKeys(pass);
        login.click();
        Thread.sleep(2000);

        return driver.getTitle();
    }
}

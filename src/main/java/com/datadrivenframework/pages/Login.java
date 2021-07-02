package com.datadrivenframework.pages;

import com.datadrivenframework.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {


    //web elements are declared and FindBy annotation is used to find web elements by using locators
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//INPUT[@id='submit-id-submit']")
    WebElement login;

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
        email.sendKeys(emailId);
        password.sendKeys(pass);
        login.click();
        Thread.sleep(2000);

        return driver.getTitle();
    }
}

package com.datadrivenframework.pages;

import com.datadrivenframework.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//a[@aria-label='My profile']")
    WebElement myProfile;
    @FindBy(xpath = "//div[contains(text(),'Udemy credits')]")
    WebElement logOut;
    @FindBy(xpath = "//div[contains(text(),\"You've successfully logged out of Udemy. Come back soon!\")]")
    WebElement alertMessage;

    //parameterized constructor is used
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * applicationLogout method is used to logout the user from application and uses action method in it
     * @return boolean value for alert message displayed or not
     * @throws InterruptedException interrupts execution for certain given period of time
     */
    public Boolean applicationLogout() throws InterruptedException {
        actions(logOut);
        logOut.click();

        return alertMessage.isDisplayed();
    }

    /**
     * actions method is used to perform certain action by using action class
     * @param element web element is used
     * @throws InterruptedException interrupts execution for certain given period of time
     */
    public void actions(WebElement element) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(myProfile).perform();
        Thread.sleep(1000);
        actions.moveToElement(element).perform();
        Thread.sleep(1000);
    }
}

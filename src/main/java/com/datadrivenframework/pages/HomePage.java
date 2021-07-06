/*
 *Purpose : Class is implemented with pom and page factory model to find the webElements
 *          by using locators in Home Page and different methods are implemented to execute operations
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 24-06-2021
 */

package com.datadrivenframework.pages;

import com.datadrivenframework.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//a[@aria-label='My profile']")
    WebElement myProfile;
    @FindBy(xpath = "//div[contains(text(),'Log out')]")
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
     */
    public Boolean applicationLogout() {
        actions(logOut);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logOut.click();

        return alertMessage.isDisplayed();
    }

    /**
     * actions method is used to perform certain action by using action class
     * @param element web element is used
     */
    public void actions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(myProfile).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.moveToElement(element).perform();
    }
}

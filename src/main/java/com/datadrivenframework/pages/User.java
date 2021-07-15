/*
 *Purpose : Class is implemented with pom and page factory model to find the webElements
 *          by using locators in User Page and different methods are implemented to execute operations
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 26-06-2021
 */
package com.datadrivenframework.pages;


import com.datadrivenframework.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class User extends BaseClass {

    @FindBy(xpath = "//a[contains(text(),'View public profile')]")
    WebElement publicProfile;
    @FindBy(xpath = "//a[contains(text(),'Profile')]")
    WebElement profile;
    @FindBy(xpath = "//a[@href = '/user/edit-photo/']")
    WebElement photo;
    @FindBy(xpath = "//a[@href = '/user/edit-account/']")
    WebElement account;
    @FindBy(xpath = "//div[@class = 'file-uploader--file-selector--SGCns']")
    WebElement uploadImage;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement cropImage;
    @FindBy(xpath = "//input[@id='submit-id-submit']")
    WebElement saveButton;

    //parameterized constructor is implemented
    public User(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * clickPublicProfile method is used to open public profile
     * @return current url of the page
     */
    public String clickPublicProfile() {
        publicProfile.click();

        return driver.getCurrentUrl();
    }

    /**
     * clickEditProfile method is used to open edit profile page
     * @return current url of page
     */
    public String clickEditProfile() {
        profile.click();

        return driver.getCurrentUrl();
    }

    /**
     * clickEditPhoto method is used to open edit photo
     * @return current url of page
     */
    public String clickEditPhoto() {
        photo.click();

        return driver.getCurrentUrl();
    }

    /**
     * clickAccount method is used to open account page
     * @return current url
     */
    public String clickAccount() {
        account.click();

        return driver.getCurrentUrl();
    }

    /**
     * uploadImage method is used to upload a image by using a EnterDataUsingRobotClass
     * @return boolean value for crop image button displayed
     */
    public Boolean uploadImage() {
        uploadImage.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            Runtime.getRuntime().exec("C:\\Users\\dinnu\\Testing\\DataDrivenFramework\\src\\test\\resources\\autoIt\\fileUpload.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Boolean displayed = cropImage.isDisplayed();
        cropImage.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        saveButton.sendKeys(Keys.ENTER);

        return displayed;
    }
}

/*
 *Purpose : Class is implemented for executing the different test cases for LoginPage
 *               @Test annotation represents to identify and execute testcase
 *               @Listeners annotation is used to make listen instructions before and after testcases
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 23-06-2021
 */

package com.datadrivenframework;

import com.datadrivenframework.base.BaseClass;
import com.datadrivenframework.pages.HomePage;
import com.datadrivenframework.pages.Login;
import com.datadrivenframework.utility.DataProvider;
import com.datadrivenframework.utility.listeners.TestListener;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestDataDriven extends BaseClass {

    //Test case is executed and assertion is done for login
    @Test(dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    @Description("Verify user is able Login to application with valid credentials and" +
                 " not able to login with invalid credentials")
    public void loginTo_Application_WithValid_Credentials(String email, String password) {
        Login login = new Login(driver);
        HomePage homePage = new HomePage(driver);
        String actualTitle = login.login(email,password);
        String expectedTitle = "Online Courses - Anytime, Anywhere | Udemy";
        Boolean alertMessage = homePage.applicationLogout();

        driver.manage().deleteAllCookies();

        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertTrue(alertMessage);
    }
}

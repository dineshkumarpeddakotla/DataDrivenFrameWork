/*
 *Purpose : Class is implemented for taking screenshots after every test execution
 *          by implements ITestListener interface and uses ITestResults interface
 *          to identify the results of test
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 25-06-2021
 */

package com.datadrivenframework.utility.listeners;

import com.datadrivenframework.base.BaseClass;
import com.datadrivenframework.utility.CaptureScreenshot;
import com.datadrivenframework.utility.ExcelUtil;
import com.datadrivenframework.utility.Log;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener extends BaseClass implements ITestListener {

    CaptureScreenshot captureScreenshot = new CaptureScreenshot(); //capture screenshot object is created
    //excelUtil object is created
    ExcelUtil excelUtil = new ExcelUtil(".\\src\\test\\resources\\Udemy.xlsx", "LoginCredentials");

    public void onTestStart(ITestResult result) {
        Log.info(result.getName() + " test is starting.");
    }

    public void onFinish(ITestContext testContext) {
        Log.info("I am in onFinish method " + testContext.getName());
    }

    /**
     * onTestFailure method is used to perform some action which are given after test case is failed
     * @param result ITestResult interface is used to get results of the testcase
     */
    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed " + result.getName());
        Log.error(result.getName() + " Test is failed");
        captureScreenshot.captureScreenshot(result.getName(), "failed");
        excelUtil.writeData(result.getParameters(),result.getName(),"Fail");
        Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    /**
     * onTestSuccess method is used to perform some action which are given after test case is passed
     * @param result ITestResult interface is used to get results of the testcase
     */
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed " + result.getName());
        Log.info(result.getName()+ " Test is passed");
        captureScreenshot.captureScreenshot(result.getName(), "success");
        excelUtil.writeData(result.getParameters(),result.getName(),"Pass");
        Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    /**
     * onTestSuccess method is used to perform some action which are given after test case is skipped or ignored
     * @param result ITestResult interface is used to get results of the testcase
     */
    public void onTestSkipped(ITestResult result) {
        System.out.println("Method skipped " + result.getName());
        Log.warn(result.getName()+" Test is skipped");
        captureScreenshot.captureScreenshot(result.getName(), "skipped");
        excelUtil.writeData(result.getParameters(),result.getName(),"Skipped");
        Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + iTestResult.getName());
    }
}

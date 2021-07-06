/*
 *Purpose : Class is implemented for taking screenshots after every test execution
 *          by implements ITestListener interface and uses ITestResults interface
 *          to identify the results of test
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 25-06-2021
 */

package com.datadrivenframework.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    CaptureScreenshot captureScreenshot = new CaptureScreenshot(); //capture screenshot object is created
    //excelUtil object is created
    ExcelUtil excelUtil = new ExcelUtil(".\\src\\test\\resources\\Udemy.xlsx", "LoginCredentials");

    /**
     * onTestFailure method is used to perform some action which are given after test case is failed
     * @param result ITestResult interface is used to get results of the testcase
     */
    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed " + result.getName());

        captureScreenshot.captureScreenshot(result.getName(), "failed");
        excelUtil.writeData(result.getParameters(),result.getName(),"Fail");
    }

    /**
     * onTestSuccess method is used to perform some action which are given after test case is passed
     * @param result ITestResult interface is used to get results of the testcase
     */
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed " + result.getName());

        captureScreenshot.captureScreenshot(result.getName(), "success");
        excelUtil.writeData(result.getParameters(),result.getName(),"Pass");
    }

    /**
     * onTestSuccess method is used to perform some action which are given after test case is skipped or ignored
     * @param result ITestResult interface is used to get results of the testcase
     */
    public void onTestSkipped(ITestResult result) {
        System.out.println("Method skipped " + result.getName());

        captureScreenshot.captureScreenshot(result.getName(), "skipped");
        excelUtil.writeData(result.getParameters(),result.getName(),"Skipped");
    }
}

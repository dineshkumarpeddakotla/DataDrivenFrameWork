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

import java.io.IOException;

public class TestListener implements ITestListener {

    //object is created
    CaptureScreenshot captureScreenshot = new CaptureScreenshot();

    //onTestFailure method is used when test is failed it will take screenshot automatically
    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed " + result.getName());
        try {
            captureScreenshot.captureScreenshot(result.getName(), "failed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //onTestSuccess method is used when test is passed it will take screenshot automatically
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed " + result.getName());
        try {
            captureScreenshot.captureScreenshot(result.getName(), "success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

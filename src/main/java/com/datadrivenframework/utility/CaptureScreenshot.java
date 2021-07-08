/*
 *Purpose : Class is implemented for taking screenshots and place those screenshot in necessary directory
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 24-06-2021
 */

package com.datadrivenframework.utility;

import com.datadrivenframework.base.BaseClass;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenshot extends BaseClass {

    /**
     * captureScreenshot method is used to take screenshot
     * @param screenshotName testcase name is giving
     * @param result giving success or failed as input
     */
    public void captureScreenshot(String screenshotName, String result)  {
        String date = new SimpleDateFormat("yyyy_MM_dd_hhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(".\\screenshots\\"+result+"\\"+ screenshotName+"_"+date+".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

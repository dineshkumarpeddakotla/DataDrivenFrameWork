/*
 *Purpose : Class is implemented to provide multiple data for test cases from excel sheet
 *                @DataProvider is provides the data to test cases
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 1-07-2021
 */

package com.datadrivenframework.utility;

public class DataProvider {

    /**
     * getDataFromProvider is used get the from excel sheet
     * @return data from excel sheet
     */
    @org.testng.annotations.DataProvider(name = "LoginDetails")
    public static Object[][] getDataFromProvider() {
        ExcelUtil excelUtil = new ExcelUtil(".\\src\\test\\resources\\Udemy.xlsx", "LoginCredentials");

        return excelUtil.readData();
    }
}

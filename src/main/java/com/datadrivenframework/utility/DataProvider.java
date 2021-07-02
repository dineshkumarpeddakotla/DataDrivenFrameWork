package com.datadrivenframework.utility;

import java.io.IOException;

public class DataProvider {

    /**
     * getDataFromProvider is used get the from excel sheet
     * @return data from excel sheet
     * @throws IOException directory not found exception
     */
    @org.testng.annotations.DataProvider(name = "LoginDetails")
    public static Object[][] getDataFromProvider() throws IOException {
        ExcelUtil readExcel = new ExcelUtil();

        return readExcel.readData(".\\src\\test\\resources\\UdemyApplication.xlsx", "LoginCredentials");
    }
}

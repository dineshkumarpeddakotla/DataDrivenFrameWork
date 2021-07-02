package com.datadrivenframework.utility;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    /**
     * readData method is used to read the data from excel sheet
     * @param filePath path of the file taken as input
     * @param sheetName sheet name in a file
     * @return cell value
     * @throws IOException file or directory not found found
     */
    public Object[][] readData(String filePath, String sheetName) throws IOException {

        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rows-1][columns];

        for (int i = 1; i < rows; i++) {
            XSSFRow currentRow = sheet.getRow(i);
            for (int j = 0; j<columns; j++ ) {
                data[i-1][j] = currentRow.getCell(j).toString();
            }
        }

        return data;
    }
}

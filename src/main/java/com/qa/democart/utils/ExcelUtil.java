package com.qa.democart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static Workbook book;
	public static Sheet sheet;
	public static String TEST_DATA_SHEET_PATH = "./src/test/resources/testdata/DemoAppTestData.xlsx";

	public static Object[][] getTestData(String sheetName) {

		Object[][] data = null;
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);

			try {
				book = WorkbookFactory.create(ip);
				sheet = book.getSheet(sheetName);
				
				int rowNum = sheet.getLastRowNum();
				int colNum = sheet.getRow(0).getLastCellNum();
				
				data = new Object[rowNum][colNum];

				for (int i = 0; i < rowNum; i++) {
					for (int j = 0; j < colNum; j++) {
						data[i][j] = sheet.getRow(i+1).getCell(j).toString();
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;

	}

}

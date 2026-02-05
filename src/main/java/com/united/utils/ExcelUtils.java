package com.united.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.united.data.OrderData;


public class ExcelUtils {
	
	
	public static OrderData readExcelUtil(String testCaseID) throws IOException {
		
		File file = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/cartData.xlsx");
		try {
			try (FileInputStream fis = new FileInputStream(file);
					Workbook workbook = new XSSFWorkbook(fis)) {
				Sheet sheet = workbook.getSheetAt(0);
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					Row row = sheet.getRow(i);
					if(row.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseID)) {
						OrderData data =  new OrderData();
						data.setVeggies(Arrays.asList(row.getCell(1).getStringCellValue().split(",")));
						data.setCheckoutTitle(row.getCell(2).getStringCellValue());
						data.setThankYouMessage(row.getCell(3).getStringCellValue());
						return data;
					}
					
					
				}
				
			}
			
			
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	

}

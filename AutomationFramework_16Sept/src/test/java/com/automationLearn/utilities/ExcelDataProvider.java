package com.automationLearn.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src=new File("./TestData/TestData.xlsx");
		
		
		    try {
		    	FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to read excel-"+ e.getMessage());
			}	
		
	}
	
	public String getStringData(String sheetnm, int row, int col)
	{
		return wb.getSheet(sheetnm).getRow(row).getCell(col).getStringCellValue();
	}

	public double getNumericData(String sheetnm, int row, int col)
	{
		return wb.getSheet(sheetnm).getRow(row).getCell(col).getNumericCellValue();
	}
}

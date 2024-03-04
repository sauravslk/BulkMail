package com.mail.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = "D:\\eclipse-workspace\\BulkMailProject\\src\\main\\java\\com\\mail\\testdata\\MailTestData.xlsx";
	
	public TestUtil()
	{
		super();
	}

   public static Object[][] getTestData(String sheetname) throws InvalidFormatException, IOException
//	public static void main(String args[])  throws InvalidFormatException, IOException
	{
		/*Workbook book;
		 Sheet sheet;
		String TESTDATA_SHEET_PATH = "D:\\eclipse-workspace\\BulkMailProject\\src\\main\\java\\com\\mail\\testdata\\MailTestData.xlsx";*/
		FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);
		book = WorkbookFactory.create(fis);
		sheet = book.getSheet("Sheet1");
	    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		Row row = sheet.getRow(0);
		
		/*for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		*/
		
		int col_num = 0;
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			System.out.println(row.getCell(i).getStringCellValue());
		//	if(row.getCell(i).getStringCellValue().trim().contentEquals("Email ID"))
			if(row.getCell(i).getStringCellValue().contains("mail"))
			
				col_num = i;
							
		}
		
	//	System.out.println("column # =" +col_num);
		
		for (int i=0; i<sheet.getLastRowNum();i++)
		{
		data [i][col_num] = sheet.getRow(i+1).getCell(col_num).toString();
		//	System.out.println(sheet.getRow(i+1).getCell(col_num));
			
		}
		
		
		return data;
	}
	
	
	
}

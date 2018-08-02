
package data_provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class DataProvider 
{
	XSSFWorkbook wb;
	public DataProvider()
	{
		File src = new File("./Application_Test_Data/AppData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Exception is that I don't know");
		}
	}
		
		public String getUsername(int sheet_index, int row1, int column1) 
		{
			String data = wb.getSheetAt(sheet_index).getRow(row1).getCell(column1).getStringCellValue();
			return data;
		}
		
		public String getPassword(int sheet_index, int row1, int column1) 
		{
			String data = wb.getSheetAt(sheet_index).getRow(row1).getCell(column1).getStringCellValue();
			return data;
		}
		
		
		
		
		
	}
	
	


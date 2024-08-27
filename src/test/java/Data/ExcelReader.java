package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.eventusermodel.XSSFBReader;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream FIS = null;
	public FileInputStream getFileInputStream() {
		
		String filepath= "/NopCommerce/src/test/java/Data/userData.xlsx";
File srcFile = new File(filepath);
try {
	FIS = new FileInputStream(srcFile);
} catch (FileNotFoundException e) {
	System.out.println("test data file not found, check file path of test data"+ e.getMessage());
System.exit(0);
}
return FIS;
	}
	
	public Object[][] getExcelData() throws IOException{
		FIS = getFileInputStream();	
		XSSFWorkbook wb = new XSSFWorkbook(FIS);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfColumns = 4;
		//n7ut data fe 2d array
		String[][] arrayExcelData = new String [TotalNumberOfRows] [ TotalNumberOfColumns ];
		 for (int i = 0; i < TotalNumberOfRows; i++) {
			for (int j = 0; j < TotalNumberOfColumns; j++) {
				XSSFRow row= sheet.getRow(i);
				arrayExcelData[i][j]= row.getCell(j).toString();
			}
		}
	wb.close();
	return arrayExcelData;
	
	}
	
}

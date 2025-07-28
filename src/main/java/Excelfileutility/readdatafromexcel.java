package Excelfileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readdatafromexcel 
{
public String readdatafromexcel(String Sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream("./TestData/TestScriptDataAdv3.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(Sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
	wb.close();
	return data;
}



//getting data from multiple data
public int togetrowcount(String Sheetname) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis = new FileInputStream("./TestData/TestScriptDataAdv3.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int rowcount = wb.getSheet(Sheetname).getLastRowNum();
	wb.close();
	return rowcount;
}
}

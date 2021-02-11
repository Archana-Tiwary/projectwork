package com.tt.util;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XlUtil {

	public String filePath;
	public String currSheet="Data";
	public int rowCount=0;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	InputStream in;
	HashMap<String,Integer> column;
	
	public XlUtil(String filePath)
	{
		this(filePath,"Data");
	}
	public XlUtil(String filePath, String currSheet)
	{
		this.filePath=filePath;
		this.currSheet=currSheet;
		load();
	}
	
	public void load()
	{
		try
		{
			in =new FileInputStream(this.filePath);
			wb=new XSSFWorkbook(in);
			sheet=wb.getSheet(this.currSheet);
			loadsheet(this.currSheet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void loadsheet(String SheetName)
	{
		sheet=wb.getSheet( SheetName);
		getTotalRow();
		loadColumns();
	}
	
	public void close()
	{
		try {
			if(in!=null)
				in.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void loadColumns()
	{
		column = new HashMap();
		Row hdr = sheet.getRow(0);
		int currCellIndex =0;
		Iterator<Cell> cells = hdr.iterator();
		
		while(cells.hasNext())
		{
			Cell cell = cells.next();
			String colName = getCellValue(cell);
			column.put(colName,currCellIndex);
			currCellIndex++;
		}
	}
	
	public void printRow(int numOfRows)
	{
		Row r = sheet.getRow(numOfRows);
		Iterator<Cell> cells = r.iterator();
		int cellNum=0;
		while(cells.hasNext())
		{
			Cell cell = cells.next();
			System.out.println("value at["+numOfRows+","+cellNum+"]->"+getCellValue(cell));
			cellNum++;
		}
	}
	
	public String getCellValue(String columnName , int rowNum)
	{
		String ret="";
		Row r = sheet.getRow(rowNum);
		Iterator<Cell> cells = r.iterator();
		int colIndex = column.get(columnName);
		int cellNum = 0;
		while(cells.hasNext())
		{
			Cell cell = cells.next();
			if(colIndex==cellNum)
			{
				ret=getCellValue(cell);
			System.out.println("value at["+rowNum+","+cellNum+"]->"+getCellValue(cell));
			break;
		}
		cellNum++;
	}
	return ret;
	}
	
	public String getCellValue(Cell cell)
	{
		String ret="";
		if(cell.getCellTypeEnum()==CellType.STRING)
			ret=cell.getStringCellValue();
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			ret=""+cell.getNumericCellValue();
		else if(cell.getCellTypeEnum()==CellType.BOOLEAN)
			ret=""+cell.getBooleanCellValue();
		
		return ret;
	}
	
	public int getTotalRow()
	{
		rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	
	public static void main(String args[])
	{
		XlUtil xl = new XlUtil("C:\\Users\\USER\\Desktop\\file.xlsx");
		int RowCount = xl.getTotalRow();
		System.out.println("Number of rows present in excel file:"+RowCount);
		
		String lastName = xl.getCellValue("LastName",1);
		String firstName = xl.getCellValue("FirstName",2); 
		String postalcode = xl.getCellValue("PostalCode",1);
		xl.close();
		
		
	}
}









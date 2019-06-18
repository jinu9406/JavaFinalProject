package edu.handong.csee.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public ArrayList<String> getData(InputStream is) throws IOException{
		ArrayList<String> values= new ArrayList<String>();
		
		try(InputStream inp= is){
			Workbook wb= WorkbookFactory.create(inp);
			Sheet sheet= wb.getSheetAt(0);
			Iterator<Row> iterator= sheet.iterator();
			
			while(iterator.hasNext()) {
				String data= "";
				String dataSum= "";
				
				Row row= iterator.next();
				Iterator<Cell> cell= row.iterator();
				
				while(cell.hasNext()) {
					Cell tmp= cell.next();
					
					switch(tmp.getCellType()) {
					
					case FORMULA: 
						data= tmp.getCellFormula();
						break;
					
					case NUMERIC:
						data= ""+ tmp.getNumericCellValue();
						break;
					
					case STRING:
						data= ""+ tmp.getStringCellValue();
						break;
						
					case BLANK:
						data= "";
						break;
					
					case BOOLEAN:
						data= ""+ tmp.getBooleanCellValue();
						break;
					
					case ERROR:
						data= ""+ tmp.getErrorCellValue();
						
					default:
						break;					
					}
					
					dataSum+= data+ "&";
					
				}
				
				values.add(dataSum);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return values;
	}
}

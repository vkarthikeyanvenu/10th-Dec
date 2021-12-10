package org.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("D:\\KarthikeyanTesting\\Maven1\\testdata\\Book2.xlsx");
		
		FileInputStream fin = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fin);
		
		Sheet s = w.getSheet("Sheet1");
		
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			
			Row r = s.getRow(i);
			
			
		for (int j = 0; j <r.getPhysicalNumberOfCells(); j++) {
			
			Cell c = r.getCell(j);
			
			
			int cellType = c.getCellType();
			
			String value="";
			if (cellType==1) {
				
				value = c.getStringCellValue();
				System.out.println(value);
				
			}else if (cellType==0) {
				if (DateUtil.isCellDateFormatted(c)) {
					Date d = c.getDateCellValue();
					
				SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
				value = sim.format(d);
				System.out.println(value);
						
			}else {
				double d = c.getNumericCellValue();
				
				long l = (long)d;
				
				value = String.valueOf(l);
				System.out.println(value);
			}
				
			}
			
			
		}
		}
	}
}
			
//		boolean a = f.createNewFile();
//		System.out.println(a);
		
//		Workbook w = new XSSFWorkbook();
//		
//		Sheet s = w.createSheet("KN");
//		
//		Row r = s.createRow(5);
//		
//		Cell c = r.createCell(3);
//		
//		c.setCellValue("TEST");
//		
//		FileOutputStream fout = new FileOutputStream(f);
//		
//		w.write(fout);
//		
//		System.out.println("DONE");
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	}

//}

package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	
	public static void loadUrl(String url) {
		driver.get(url);
		
	}
	
	public static void winMax() {
		driver.manage().window().maximize();
		
	}
	
	public static void printTitle() {
		System.out.println(driver.getTitle());

	}
	
	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());

	}
	
	public static void applyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	public static void getChar(WebElement ele) {
		ele.getText();
		
	}
	
	public static void getAttr(WebElement ele,String name) {
		ele.getAttribute(name);

	}
	
	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);
	
	}
	
	public static void btnClick(WebElement ele) {
		ele.click();

	}
	
	public static void takeSnap(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\KarthikeyanTesting\\Maven1\\screenshots+FileName+.png");
		FileUtils.copyFile(src, dest);

	}
	
	public static void rightClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
		
	}
	
	public static void mouseOver(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();;
		
	}
	
	public static void copyPaste(WebElement src,WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, target);
		
	}
	
	public static String getData(int rowNumber, int cellNumber) throws IOException {
		
		File f = new File("D:\\\\KarthikeyanTesting\\\\Maven1\\\\testdata\\\\Book1.xlsx");
		
		FileInputStream fin = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fin);
		
		Sheet s = w.getSheet("sheet1");
		
		Row r = s.getRow(rowNumber);
		
		Cell c = r.getCell(cellNumber);
		
		int cellType = c.getCellType();
		
		String value="";
		if (cellType==1) {
			
			value = c.getStringCellValue();
			
			
		}else if (cellType==0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			value = sim.format(d);
			
					
		}else {
			double d = c.getNumericCellValue();
			
			long l = (long)d;
			
			value = String.valueOf(l);
			
		}
	}
		
		return value;
		
		
		
		
		

	}
	
	public static void closeChrome() {
		driver.close();
		

	}
	
	
	

}

package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
    public static void loadBrowser()
    {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    	
    }
    public static void maxiWindow() {
		driver.manage().window().maximize();

	}
   
    public static void applyImplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
    
    public static void fill(WebElement ele,String text) {
		ele.sendKeys(text);

	}
    
    public static void takessnap(String picName) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\eclipse-workspace\\FinalCucumber\\Screenshots\\"+picName+".png");
		FileUtils.copyFile(src, dest);
		

	}
    
    public static String excelRead(String filePath,String sheetName,int rowNo,int cellNo) throws IOException {
		File file=new File(filePath);
		FileInputStream fin=new FileInputStream(file);
		Workbook w=new XSSFWorkbook(fin);
		Sheet s=w.getSheet(sheetName);
		Row r=s.getRow(rowNo);
		Cell c=r.getCell(cellNo);
		int cellType = c.getCellType();
		String value="";
		if(cellType==1)
		{
			value=c.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date d=c.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
			value=sim.format(d);
			
		}
		else {
			double d = c.getNumericCellValue();
			long l=(long)d;
			value=String.valueOf(l);
		}
		return value;

	}
    
    public static void excelWrite(String filePath,int rowNo,int cellNo,String text) throws IOException {
	File file=new File(filePath);
	Workbook w=new XSSFWorkbook();
	Sheet s=w.createSheet();
	Row r=s.createRow(rowNo);
	Cell c=r.createCell(cellNo);
	c.setCellValue(text);
	FileOutputStream fout=new FileOutputStream(file);
	w.write(fout);
	System.out.println("Done Successfully");

	}
    public static void excelUpdate(String filePath,String sheetName,int rowNo,int cellNo,String text,String text2) throws IOException {
    	{
    		File file=new File(filePath);
    		FileInputStream fin=new FileInputStream(file);
    		Workbook w=new XSSFWorkbook(fin);
    		Sheet s=w.getSheet(sheetName);
    		Row r=s.getRow(rowNo);
    		Cell c=r.getCell(cellNo);
    		String value = c.getStringCellValue();
    		if (value.equals(text)) {
    			
    			c.setCellValue(text2);
				
			}
    		FileOutputStream fout=new FileOutputStream(file);
    		w.write(fout);
    		System.out.println("Done Success");
    	}
    	 
    	}
    
    public static void loadUrl(String url) {
		driver.get(url);

	}
    
    public static void click(WebElement ele) {
		ele.click();

	}
}

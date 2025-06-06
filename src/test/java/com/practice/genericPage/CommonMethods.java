package com.practice.genericPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;


public class CommonMethods extends MasterPage {
	
	public CommonMethods() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//Get Text of Web Element
	public void getWebElementText(String xpathkey) {
		String getTextOfWebElement= driver.findElement(By.xpath(or.getProperty(xpathkey))).getText();
		System.out.println(getTextOfWebElement);
	}

	//click method
	public void clickWebElement(String xpathkey) {
		driver.findElement(By.xpath(or.getProperty(xpathkey))).click();
	}
	
	//Clear Data
	public void clearData(String xpathkey) {
		driver.findElement(By.xpath(or.getProperty(xpathkey))).clear();
	}
	
	//Enter Data
	public void enterData(String xpathkey, String testdata) {
		driver.findElement(By.xpath(or.getProperty(xpathkey))).sendKeys(td.getProperty(testdata));
	}
	
	//Mouse Over
	public void moveToElement(String xpathkey) {
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(or.getProperty(xpathkey)))).build().perform();
	}
	
	//Click List of Web Element
	public void clickListElement(String xpathkey, String testdata) {
		
		List<WebElement> listOfElements = driver.findElements(By.xpath(or.getProperty(xpathkey)));
		
		for(int i=0; i<listOfElements.size(); i++) {
			if(listOfElements.get(i).getText().equalsIgnoreCase(td.getProperty(testdata))) {
				listOfElements.get(i).click();
			}
		}
		
	}
	
	//select drop down value using visible text
	public void selectDropdownValue(String xpathkey, String testdata){
		WebElement ele= driver.findElement(By.xpath(or.getProperty(xpathkey)));
		Select webElem = new Select(ele);
		webElem.selectByVisibleText(td.getProperty(testdata));
	}

	
	//Accept alert
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	//Reading excel data
	public void readExcelData(String xpathkey, int rowNo, int columnNo) throws IOException{
		File src= new File(".\\src\\test\\resources\\com\\practice\\resources\\ExcelTestData.xlsx");
	    FileInputStream fis= new FileInputStream(src);
	    XSSFWorkbook wb= new XSSFWorkbook(fis);
	    XSSFSheet sh=wb.getSheet(prop.getProperty("ExcelTestDataSheetName"));
	    System.out.println(sh.getSheetName());
	    String abc=sh.getRow(rowNo).getCell(columnNo).getStringCellValue();
	    driver.findElement(By.xpath(or.getProperty(xpathkey))).sendKeys(abc);
	}	
	
	//Handling Explicitly wait -visibility of Element located
	public void handleExplicitWait_visibilityofElementLocated(String xpathkey, String testdata) {
		WebDriverWait wt= new WebDriverWait(driver,30);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty(xpathkey)))).sendKeys(td.getProperty(testdata));
	}
	
	//Handling Explicitly wait- element to be clickable
	public void handleExplicitWait_elementToBeClickable(String xpathkey) {
		WebDriverWait wt = new WebDriverWait(driver,30);
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty(xpathkey))));
	}
	
	//Handle log file
	public void handleLogger(String logClassName, String loggerText ) {
		Logger logger= Logger.getLogger(logClassName);
		PropertyConfigurator.configure(prop.getProperty("log4JPropertiesFileLoc"));
		logger.info(loggerText);
	}
	
	public void captureScreenshot(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			
			//Create ref of TakeScreenshot Interface and Type casting
			TakesScreenshot ts= (TakesScreenshot) driver;  //type casting of 2 interfaces
			// Use getScreenshotAs() to capture the screenshot in file format
			//getScreenshotAs() method return type= FILE
			File sourceFile =ts.getScreenshotAs(OutputType.FILE);
			//copy the file to specific location
			File destFolder = new File("/screenshot/"+ result.getName()+".png");
			FileUtils.copyFile(sourceFile,destFolder);
			System.out.println(result.getName()+ "method() screenshot captured");
		}
	}
	

}

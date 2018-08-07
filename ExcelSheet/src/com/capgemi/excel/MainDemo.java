package com.capgemi.excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\Sabari\\chrome driver\\chromedriver.exe" );
		 driver = new ChromeDriver();
		driver.get("D:\\BDD workspace\\ExcelSheet\\WebContent\\login.html");
		Thread.sleep(1000);
		XSSFWorkbook srcBook = new XSSFWorkbook("D:\\bdd programs\\exceltest.xlsx");
		XSSFSheet sourceSheet = srcBook.getSheetAt(0);
		int rowMaxRowNum = sourceSheet.getLastRowNum();
		for(int row = 0;row <= rowMaxRowNum;row++){
		XSSFRow sourceRow = sourceSheet.getRow(row);
		XSSFCell fname = sourceRow.getCell(0);
		XSSFCell lname = sourceRow.getCell(1);
		driver.findElement(By.id("fname")).sendKeys(fname.toString());
		Thread.sleep(1000);
		driver.findElement(By.id("lname")).sendKeys(lname.toString());
		Thread.sleep(1000);
		WebElement submitButton = driver.findElement(By.id("submit"));
		submitButton.click();
	}
	}
	}



package com.cg.junit;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jxl.Sheet;
import jxl.Workbook;

public class RegistrationSteps {
	
	WebDriver driver;
	static String fName1;
	static String lName1;
	static String mail1;
	static String cNum1;
	static String address1;
	static String city1;
	static String stateName1;
	static String pname;
	static String cname;
	static String ts;

	@Before
	public static void readerFunction() throws Exception {
		FileInputStream inputStream=new FileInputStream(new File("D:\\excel.xls"));
		Workbook wb=Workbook.getWorkbook(inputStream);
		Sheet sh = wb.getSheet(0);
		fName1=sh.getCell(0,0).getContents();
		lName1=sh.getCell(1,0).getContents();
		mail1=sh.getCell(2,0).getContents();
		cNum1=sh.getCell(3,0).getContents();
		address1=sh.getCell(4,0).getContents();
		city1=sh.getCell(5,0).getContents();
		stateName1=sh.getCell(6,0).getContents();
	pname=sh.getCell(7,0).getContents();
		cname=sh.getCell(8,0).getContents();
		ts=sh.getCell(9,0).getContents();
	}
	

@Given("^The user visits the registration page$")
public void the_user_visits_the_registration_page() throws Throwable {
    
	System.setProperty("webdriver.chrome.driver","D:\\Sabari\\chrome driver\\chromedriver.exe" );
	 driver = new ChromeDriver();
	driver.get("D:\\BDD workspace\\Registration Assignment\\src\\com\\cg\\junit\\register.html");
}
@When("^the user enters the details for registration$")
public void the_user_enters_the_details_for_registration() throws Throwable {
    
	WebElement fname = driver.findElement(By.id("firstname"));
	fname.sendKeys(fName1);
	//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	Thread.sleep(1000);
	
	
	WebElement lname = driver.findElement(By.id("lastname"));
	lname.sendKeys(lName1);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(1000);
	
	WebElement email = driver.findElement(By.id("email"));
	email.sendKeys(mail1);
	Thread.sleep(1000);
	
	WebElement contact = driver.findElement(By.id("contact"));
	contact.sendKeys(cNum1);
	Thread.sleep(1000);
	
	WebElement address = driver.findElement(By.id("address"));
	address.sendKeys(address1);
	Thread.sleep(1000);
	
	WebElement city = driver.findElement(By.id("city"));
	city.sendKeys(city1);
	Thread.sleep(1000);
	
	WebElement state = driver.findElement(By.xpath("/html/body/table/tbody/tr[7]/td[2]/select"));
	state.sendKeys(stateName1);
	Thread.sleep(1000); 
	
	WebElement register = driver.findElements(By.xpath("/html/body/table/tbody/tr[8]/td/input")).get(0);
	register.click();
	

	}
@When("^the details are validated$")
public void the_details_are_validated() throws Throwable {
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	assertEquals("Details validated", alert.getText()); 
	driver.quit();
}
@When("^the user visits the project details page$")
public void the_user_visits_the_project_details_page() throws Throwable {
	
	System.setProperty("webdriver.chrome.driver","D:\\Sabari\\chrome driver\\chromedriver.exe" );
	 driver = new ChromeDriver();
	driver.get("D:\\BDD workspace\\Registration Assignment\\src\\com\\cg\\junit\\projectdetails.html");
}

@When("^the user enters the project deatils$")
public void the_user_enters_the_project_deatils() throws Throwable {
    
	WebElement projectname = driver.findElement(By.id("projectname"));
	projectname.sendKeys(pname);
	Thread.sleep(1000); 
	
	WebElement clientname = driver.findElement(By.id("clientname"));
	clientname.sendKeys(cname);
	Thread.sleep(1000); 
	
	WebElement teamsize = driver.findElement(By.id("teamsize"));
	teamsize.sendKeys(ts);
	Thread.sleep(1000); 
	
	WebElement register = driver.findElements(By.xpath("/html/body/table/tbody/tr[4]/td/input")).get(0);
	register.click();

}

@Then("^the user successfully registers the project$")
public void the_user_successfully_registers_the_project() throws Throwable {
   
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	assertEquals("Registration Successfull", alert.getText()); 
	
	driver.quit();
}
}
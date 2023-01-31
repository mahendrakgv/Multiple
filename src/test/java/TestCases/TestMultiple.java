package TestCases;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.multi.base.TestBase;

public class TestMultiple extends TestBase {
	
	public TestMultiple() throws IOException {
		super();
		PageFactory.initElements(driver, this);			
	}
	
	@BeforeClass
	public void setup() throws IOException
	{
		TestBase.initialization();
	}

	//@Test
	public void testgetMultipleELements() throws Exception {
		Thread.sleep(2000);
		
		WebElement Search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Thread.sleep(1000);
		Search.sendKeys("samsung");
		
		WebElement clkSeacrh = driver.findElement(By.xpath("//input[@value='Go']"));
		clkSeacrh.click();
		Thread.sleep(3000);
		
		List <WebElement> mobiles = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("Number of Mobile Phones   " + mobiles.size() );
		
		for (int i = 1;  i <= mobiles.size(); i++){
			System.out.println("Mobile Phones List   " + i +" " + 	mobiles.get(i).getAttribute("value"));
		
		}
						
	}
	
	//@Test
	public void testRHB() throws Exception {
		Thread.sleep(2000);
		
		try {
			Actions action = new Actions(driver);
			//WebElement Search = driver.findElement(By.xpath("//input[@id='twotabsearchtextox']"));
			//WebElement Search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			WebElement Search = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
			
			Thread.sleep(1000);
			
			action.contextClick(Search).perform();				
		} catch(Exception e){	
			System.out.println("Exceptions is " + e);
		}		
	}
		
	//Amazon.in Action for Mouse Hover them click
	@Test
	public void testHover() throws Exception {
		Thread.sleep(2000);
		
		
		Actions action = new Actions(driver);
		WebElement Search = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		
	
		Thread.sleep(2000);
		action.moveToElement(Search).perform();	
		
		WebElement subScribe = driver.findElement(By.xpath("//a[@class='nav-link nav-item']/span[contains(text(),'Your Subscribe & Save Items')]"));
		
		subScribe.click();
		
	}
	
	
	//Duplicate Strings in Name
	@Test
	public void testRepatedChards() throws Exception {
		Thread.sleep(2000);
				
		String name = "Mahendra Kumar G V";
		name = name.toLowerCase();
		//Assign to characters to array
		char[] carry = name.toCharArray();
	
		System.out.println("Name is " + name);
		System.out.print("Duplicate Characters in above string are: ");
		
		for (int i = 0; i< name.length(); i++)
		{
			for (int j = i+1; j < name.length(); j++)
			{
				if (carry[i] == carry[j]) {
					System.out.println("Repeated Char is " + carry[i]);
					break;
					}
			}	
		}
		
	}
	
	//@Test
	public void TestExceptionScan() {
		
		System.out.println("Enter Number");
		Scanner scan = new Scanner(System.in);
		
		try {
	    int	n = scan.nextInt();
	    System.out.println("Number ENetered is " + n);
		}catch(Exception e) {
			System.out.println("Please enter Number");
			
		}
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();		
	}
	

}

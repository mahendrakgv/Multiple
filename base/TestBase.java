package com.eco.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.eco.driver.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
		
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() throws IOException {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
			System.getProperty("user.dir") + "/src/main/java/com/eco/configurations/config.properties");
			//System.out.println(ip);
			prop.load(ip);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}		
	}			
	
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
			if(browserName.equals("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();	
				DriverManager.setDriver(driver);				
			} else
			if(browserName.equals("firefox")){
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					DriverManager.setDriver(driver);
			}	
						
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));	
			
		}	
}

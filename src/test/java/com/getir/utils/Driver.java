package com.getir.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Driver {
	private static final Logger logger = LogManager.getLogger();
	private static WebDriver driver;

	private Driver(){
	}

	public synchronized static WebDriver getDriver(String browser){
		// String browser ==>  it originally comes from xml file to test base class, from test base it comes here
		if(driver == null) {
			// first we check if the value from xml file is null or not
			// if the value from xml file NOT null we use
			// the value from xml file IS null, we get the browser from properties file
			browser = browser == null ? ConfigurationReader.getProperty("browser") : browser;
			System.out.println("driver = " + driver);
			logger.info("Creating the driver for: " + browser);
			switch (browser) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					options.addArguments("--no-sandbox");
					options.addArguments("--disable-dev-shm-usage");
					options.addArguments("--headless");
					TestConfiguration.configureChromeOptions(options);
					driver = new ChromeDriver(options);
					logger.info("Created Chrome driver with the following options: " + options.asMap());
					logger.info("Browser size is " + driver.manage().window().getSize());
					driver.get("http://demo.opencart.com");
					break;
				case "chromeHeadless":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "firefoxHeadless":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
					break;
				default:
					throw new RuntimeException("Illegal browser type!");
			}
		}
		return driver;
	}

	public static WebDriver getDriver(){
		return getDriver(null);
	}

	public static void closeDriver(){
		if(driver != null)
			driver.quit();
		driver = null;
	}
}
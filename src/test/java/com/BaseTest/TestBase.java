package com.BaseTest;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.CommonUtils.utils;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {

	//public SelendroidHomeScreen selendroidhomescreen;

	public static AndroidDriver driver;
	
	public static Logger log=Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	public void setUp() {

		if(driver==null){
			
			try {
				PropertyConfigurator.configure("./src/test/resources/Properties/log4j.properties");
			
				utils.loadConfigProp("selendroidtestapp.properties");
				
				log.info("config file loaded");
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			utils.setCapabilities();
			log.info("capabilities loaded");
			try {
				driver = utils.getDriver();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@BeforeClass
	public void beforeClass() {
		
		ExtentTest classLevelTest =utils.extentReport.createTest(getClass().getSimpleName());
		utils.classLevelLog.set(classLevelTest);

	}
	
	

	@AfterSuite
	public void tearDown(){
		
		driver.quit();
		log.info("driver successfully exit");
	}
	

}

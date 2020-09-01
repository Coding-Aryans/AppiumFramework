package com.testcases;


import org.testng.annotations.Test;

import com.BaseTest.TestBase;
import com.screens.SelendroidHomeScreen;



public class SelendroidHomeScreenTest extends TestBase  {


	
	
	@Test()
	public void testType() {
		System.out.println("inside test 1");
		SelendroidHomeScreen selendroidhomescreen = new SelendroidHomeScreen(driver);		
	     selendroidhomescreen.textData("hi Appium").textView();
	     
	}
	
	
}

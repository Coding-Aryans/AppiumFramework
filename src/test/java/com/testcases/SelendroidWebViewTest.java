package com.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseTest.TestBase;
import com.screens.SelendroidHomeScreen;

public class SelendroidWebViewTest  extends TestBase {
	
	
	@Test
	public void formData() {
		
		SelendroidHomeScreen selendroiWebscreen = new SelendroidHomeScreen(driver);
		selendroiWebscreen.WebView();
		Assert.fail();
		
	}

}

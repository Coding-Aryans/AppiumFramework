package com.screens;

import org.openqa.selenium.WebElement;

import com.BaseScreens.ScreenBase;
import com.BaseTest.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SelendroidHomeScreen extends ScreenBase {

	public SelendroidHomeScreen(AndroidDriver driver) {
		super(driver);
		
	}
	
	@AndroidFindBy(id="io.selendroid.testapp:id/my_text_field")
	public WebElement textBox;	
	
	@AndroidFindBy(id="io.selendroid.testapp:id/visibleButtonTest")
	public WebElement textView;	
	
	
	@AndroidFindBy(id="io.selendroid.testapp:id/buttonStartWebview")
	public WebElement WebView;
	
	public SelendroidHomeScreen textData(String data) {
		textBox.sendKeys(data);
	TestBase.log.info(data+"is:");
		return this;
	}

	public SelendroidHomeScreen textView() {
	System.out.println(textView.getText());
	TestBase.log.info(textView.getText()+"is:");
		return this;
	}
	
	public void WebView() {
		WebView.click();
		TestBase.log.info("web view Clicked successfuly....");
		//TestBase.log.info(textView.getText()+"is:");
			//return this;
		}

}

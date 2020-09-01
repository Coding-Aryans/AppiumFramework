package com.CommonUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.BaseScreens.ScreenBase;

import io.appium.java_client.android.AndroidDriver;

public class CaptureScreenShot  extends utils{
	

	public static String screenshotPath;
	   public static String Error;

		public static String capture() throws IOException {

			
			Date d = new Date();
		 Error = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		screenshotPath =System.getProperty("user.dir")+"/src/test/resources/TestReports/screenshots/"+Error;
			
			File screenshot = ((TakesScreenshot)utils.getDriver()).getScreenshotAs(OutputType.FILE);
		     File destination = new File(screenshotPath);
		    FileUtils.copyFile(screenshot,destination);
			return screenshotPath;

}}

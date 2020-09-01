package com.Listeners;


import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.CommonUtils.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class CustomListeners extends utils  implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test = classLevelLog.get().createNode(result.getName());
		testLevelLog.set(test);
		testLevelLog.get().info("Testcase:" + result.getName() + "test execution started");
	}

	public void onTestSuccess(ITestResult result) {
		testLevelLog.get().pass("This test case got passed");
		extentReport.flush();
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testLevelLog.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");

		String failureLogg = "This Test case got Failed";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testLevelLog.get().log(Status.FAIL, m);
		
		
		try {
			testLevelLog.get().addScreenCaptureFromPath(utils.capture());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentReport.flush();
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}



}

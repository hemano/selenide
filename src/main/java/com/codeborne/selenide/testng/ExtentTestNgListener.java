package com.codeborne.selenide.testng;

import com.codeborne.selenide.Screenshots;
import com.vimalselvam.testng.listener.ExtentTestNgFormatter;
import org.testng.ITestResult;

public class ExtentTestNgListener extends ExtentTestNgFormatter {

  public void onTestFailure(ITestResult iTestResult) {

    //attach screenshot to ExtentReports
    try {
      String filePath = Screenshots.getLastScreenshot().getCanonicalPath();
      ExtentTestNgFormatter.getInstance().addScreenCaptureFromPath(iTestResult, filePath);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

package com.codeborne.selenide.testng.listeners;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.codeborne.selenide.impl.ScreenShotLaboratory;
import org.testng.ITestResult;
import com.codeborne.selenide.Driver;
import java.io.IOException;

public class ExtentITestClassListener extends ExtentITestListenerClassAdapter {

  @Override
  public synchronized void onTestFailure(ITestResult result) {
    try {
      ExtentTestManager.getTest(result).fail(result.getThrowable());
      String screenshotPath = ScreenShotLaboratory.getInstance().getLastScreenshot().getAbsolutePath();
      ExtentTestManager.getTest(result).addScreenCaptureFromPath(screenshotPath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


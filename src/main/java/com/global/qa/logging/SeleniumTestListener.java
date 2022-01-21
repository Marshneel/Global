package com.global.qa.logging;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.global.qa.resources.ExtentManager;



public class SeleniumTestListener extends TestListenerAdapter {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    private static final Logger log = LoggerFactory.getLogger(SeleniumTestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Starting test: {}", result.getMethod().getQualifiedName());
        ExtentTest extentTest = extent.createTest(result.getMethod().getQualifiedName(), result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test passed: {}", iTestResult.getMethod().getQualifiedName());
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test failed: " + result.getMethod().getQualifiedName(), result.getThrowable());
        test.get().fail(result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        log.error("Test skipped: " + result.getMethod().getQualifiedName(), result.getThrowable());
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();
    }
}


package com.global.qa.resources;



import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static final String DIRECTORY_NAME = "test-output";
    private static final String FILE_NAME = "ExtentReportsTestNG.html";


    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    // Create an extent report instance
    private static ExtentReports createInstance() {
        createReportDirectoryIfItDoesNotExist();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(DIRECTORY_NAME + File.separator + FILE_NAME);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(FILE_NAME);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Regression Tests - Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    private static void createReportDirectoryIfItDoesNotExist() {
        File directory = new File(DIRECTORY_NAME);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}


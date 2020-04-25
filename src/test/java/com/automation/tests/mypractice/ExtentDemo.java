package com.automation.tests.mypractice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemo {
    ExtentReports report;
    ExtentHtmlReporter htmlReporter;
    ExtentTest extentLogger;

    @BeforeMethod
    public void setup(){
        //initialize the classes
        report = new ExtentReports();
        // create report path
        //System.getProperty("user.dir") --->returns the location / path of my project
        //"/test-output/report.html"---> report will be in test output folder, name-->report.html
        String path = System.getProperty("user.dir")+"/test-output/report.html";

        // initializing the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        //set the title of the report
        htmlReporter.config().setReportName("Vytrack smoke tests");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("browser","chrome");
        report.setSystemInfo("whats my name", "John b Goodenough");

    }
    @Test
    public void test1(){
        //GIVE NAME to the current test
        extentLogger = report.createTest("TC001 Login as driver test");
        // info() --> write test steps
        extentLogger.info("");
        extentLogger.info("go to url");
        extentLogger.info("enter driver login info");
        extentLogger.info("click submit");
        extentLogger.info("click verify logged in");
        //pass()---> marks the test case as passed
        extentLogger.pass("TC001 passed");



    }

    @AfterMethod
    public void close(){
        //this is when the report is actually created
        report.flush();
    }

}

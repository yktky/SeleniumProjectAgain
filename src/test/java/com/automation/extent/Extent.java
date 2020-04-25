package com.automation.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Extent {

    ExtentReports reports;
    ExtentHtmlReporter htmlReporter;
    ExtentTest extentLogger;  //actual thing

    @BeforeMethod
    public void setup(){

        //initialize the classes
        reports = new ExtentReports();
        //create report path
        // System.getProperty("user.dir") --. returns the location /path of my project
        ///test-output/report.html--> report will be in test output folder, name--> report.html

        String path = System.getProperty("user.dir")+"/test-output/report.html";

        //initialize the html report path
        htmlReporter = new ExtentHtmlReporter(path);
        //attach the html report to the report object
        reports.attachReporter(htmlReporter);

        //set the title of the report
        htmlReporter.config().setReportName("Vytrack smoke tests");

        //set enevirenment information
        reports.setSystemInfo("Environment","QA");
        reports.setSystemInfo("browser","chrome");
        reports.setSystemInfo("what is my name", "john b goodenough");


    }


    @Test
    public void test1(){
        // give name to the current test
        extentLogger = reports.createTest("TC001 Login as driver test");
        extentLogger.info("Open chrome");
        extentLogger.info("go to url");
        extentLogger.info("enter driver login info");
        extentLogger.info("click submit");
        extentLogger.info("click verify logged in");
        extentLogger.info("TC001");

        //pass()--> marks the test case as passed
        extentLogger.pass("TC001 passed");
    }


    @AfterMethod
    public void close(){

        // this is when the report is actually created
        //this line must run after everything
        reports.flush(); // if you dont have you, didnt get report

    }

}

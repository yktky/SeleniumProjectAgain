package com.automation.tests.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class UplodFilePractice {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");

    }
    @Test
    public void test1() throws Exception{
        //driver.findElement(By.linkText("File Download")).click();
        // click file and right click press shift choose you will se copy as and put inside sendkeys
        // for file upload we need two things find elemnt and inside sendkeys put file path and click submit
        //provide path to the file
        //insert your path to the path to the file into sendkeys method

        Thread.sleep(3);
       //  driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\darak\\Desktop\\yekta.txt");
        //How i uploded just put inside sendkeys
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\darak\\Documents\\Class Note Guljannat.docx");

        driver.findElement(By.id("file-submit")).click();//click submit
        BrowserUtils.wait(3);
        String expectedFileName = "Class Note Guljannat.docx";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,expectedFileName);
       // String file2Path ="C:\\Users\\darak\\Downloads\\day54 class note.txt";
    }
    @AfterMethod
    public void tearDown(){

    }
}

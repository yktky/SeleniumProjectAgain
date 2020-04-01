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
        driver.get("http://practice.cybertekschool.com/");

    }
    @Test
    public void test1(){
        driver.findElement(By.linkText("File Download")).click();
        // click file and right click press shift choose you will se copy as and put inside sendkeys
        // for file upload we need two things find elemnt and inside sendkeys put file path and click submit
        //provide path to the file
        //insert your path to the path to the file into sendkeys method
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\darak\\Downloads\\class_notes.txt"); //How i uploded just put inside sendkeys
        driver.findElement(By.id("file-submit")).click();//click submit
        BrowserUtils.wait(3);
        String expectedFileName = "class_notes.txt";
        String actualFileName = driver.findElement(By.id("uploaded-file")).getText();
        Assert.assertEquals(actualFileName,expectedFileName);
       // String file2Path ="C:\\Users\\darak\\Downloads\\day54 class note.txt";
    }
    @AfterMethod
    public void tearDown(){

    }
}

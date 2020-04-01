package com.automation.tests.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TestNgPractice {

    @Test
    public void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/");

       String expectedTitle = "Practice";
       String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is wrong");
        driver.quit();
    }
    //lets verify that Test Automation Practice heading  is displayed

    @Test
    public void verifyHeadinDisplayed(){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

        WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));

        Assert.assertTrue(heading.isDisplayed(),"Element is not visible");
        driver.quit();


    }


}

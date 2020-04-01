package com.automation.tests.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class RadioButton {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test
    public void test1(){
        // to go to radio Button page
        driver.findElement(By.xpath("//a[text()='Radio Buttons']")).click();
        //Or
       // driver.findElement(By.linkText("Radio Button")).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

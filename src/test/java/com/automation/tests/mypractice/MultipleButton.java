package com.automation.tests.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class MultipleButton {
    private WebDriver driver;  // I create WebDRiver instance variable

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");


    }
    @Test
    public void verifyButton(){
        String expectedResult = "Clicked on button one!";
        driver.findElement(By.xpath("//*[text()='Button 1']")).click();
       String actualResult = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actualResult,expectedResult,"Result is wrong");

    }
    @Test
    public void verifyButton2(){
        String expectedResult = "Clicked on button two!";
        driver.findElement(By.xpath("//button[text()='Button 2']")).click();  //By.name("button1)
        String actualResult = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actualResult,expectedResult,"Result is wrong");
    }

    @Test
    public void tearDown(){
        driver.quit();
    }
}

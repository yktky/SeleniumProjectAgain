package com.automation.tests.mypractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class PopUpPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
    }
    @Test(description = "Click OK in pop up message")
    public void test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        //to deal with pop up, we can create object of alert
        //Switches to the currently active modal dialog
        Alert alert = driver.switchTo().alert();
        alert.accept();//to click ok
        BrowserUtils.wait(3);

    }
    @Test(description = "Click on Cancel in pop up message")
    public void test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();  //--->//button[2] you can use second betton with xpath
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        //print text of popup message
        System.out.println(alert.getText());
        //to click cancel
        alert.dismiss();
        BrowserUtils.wait(5);
        //to print of the result
        WebElement result =driver.findElement(By.id("result"));
        System.out.println(result.getText());
    }
    @Test(description = "Click on button 3 enter some text and then click OK")
    public void test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[3]")).click(); //By.cssSelector[onclick='jsPrompt()']
        BrowserUtils.wait(3);
        driver.switchTo().alert().sendKeys("java is fun");
        BrowserUtils.wait(3);
        driver.switchTo().alert().accept();
        //to print text of result
        //should be java is fun

        System.out.println(driver.findElement(By.id("result")).getText());
    }
}

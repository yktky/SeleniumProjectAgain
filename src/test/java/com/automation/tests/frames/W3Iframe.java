package com.automation.tests.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class W3Iframe {
    //iframe[@id='DAsis']
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = BrowserFactory.getDriver("chrome");
         driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");



    }
    @Test
    public void test1(){

       // 1.way find iframe
      //  driver.switchTo().frame("iframeResult"); 1.way find iframe
        //2.way find iframe
     //   driver.switchTo().frame(7);

        WebElement iframe = driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
        driver.switchTo().frame(iframe);
       driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("GH");

      //to exit from frame
       driver.switchTo().defaultContent();
       BrowserUtils.wait(3);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
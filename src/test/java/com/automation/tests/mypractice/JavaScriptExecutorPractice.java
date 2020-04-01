package com.automation.tests.mypractice;

import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class JavaScriptExecutorPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");

    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500);");
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(3);//for demo
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //this script must scroll, until link elemnt is not visible
        //once link elemnet will be visible, it will stop scrolling
        js.executeScript("arguments[0].scrollIntoView(true)",link); //arguments[0] this means first webelemnt(link--first elemnt)
        //arguments[0]= link web element, it can be any web element
        //Argumenets it is an array of webelements after comma
        //I can find Webelement regular approach and --> WebElement link = driver.findElement(By.linkText("Cybertek School"));
        // then  i can use webelelmnt part of javascriptExecuter-->js.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowserUtils.wait(3);
    }
    @Test(description = "Click with JS Executor")
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));
        BrowserUtils.wait(3);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",link1);
        BrowserUtils.wait(3);
    }
    @Test(description = "Enter text with JS executor")
    public void test4(){
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.name("wooden_spoon"));

        // to create JsExecutor object we need to cast webdriver object
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value',John Smith')",name);
        js.executeScript("arguments[0].setAttribute('value','someemail@gmail.com)",email);
//.setAttribute('value','someemail@gmail.com) it is the same as name.sendKeys("john Smith")
        js.executeScript("arguments[0].click()",submitButton);
        BrowserUtils.wait(3);
    }



    @AfterMethod
    public void after(){
        driver.quit();
    }
}

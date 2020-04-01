package com.automation.tests.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class TestNgPractice2 {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //linktext only works with <a> element
        //linktext is only in between >Text<
        //find blue botton
        // this step is common for all Test cases so we write here if we have only i test we can put inside test
        driver.findElement(By.linkText("Radio Buttons")).click();
    }
    @Test
    public  void test1(){


        WebElement blueButton = driver .findElement(By.id("blue"));
        //lets verify that radio button is sellected
        //assert true that button is selected
        //if button is selected it will return true, other wise false
       // boolean isselected = blueButton.isSelected();
        //Assert.assertTrue(isselected);
        //Or like below
        Assert.assertTrue(blueButton.isSelected());
    }
    @Test(description = "Verify that red button is not selected")
    public void test2(){
        WebElement redButton = driver.findElement(By.id("red"));
        //isSelected() return true if button already clicked
        Assert.assertFalse(redButton.isSelected());  // assertFalse will expecte that condition is false

    }
    @Test(description = "Verify that green button is not clickable")
    public void test3(){
        // is enabled() will return true if button is available for interaction
        //that means you can click on it, in this case
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());

    }

    @Test(description = "Click all radio Button")
            public void Test4 (){
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        //lets cliclk only if button is not clicked and is available for clicking
        for (WebElement eachButton : radioButtons) {
            // if button is available for clicking and not clicked yet
            if(eachButton.isEnabled()&&!eachButton.isSelected()){
               // then click on it
                eachButton.click();
                //in this case, id attribute represents a name of color
                System.out.println("Button clicked: "+eachButton.getAttribute("id"));
            }else {
                System.out.println("Button was not clicked: "+eachButton.getAttribute("id"));
            }
            BrowserUtils.wait(10);
            // Dont confuse  you see in output not blue is not clicable bacause is clicked already default
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

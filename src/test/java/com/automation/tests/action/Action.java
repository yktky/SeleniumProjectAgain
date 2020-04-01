package com.automation.tests.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class Action {
//[class='figure']:nth-of-type(1) h5 // nth 8. 7. 6. child
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");

    }

    @Test(description = "Verify first image")
    public void test1(){
        //create object of action class to perform actions (drag and drop, contex click)
        Actions action = new Actions(driver);
        WebElement image1 =driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        //just to hover on elemnt not click
        //build()is required whwen we have more than 1 action in a chain
        //without .perform() it will not work
        //moveToRlement = hover
        //.perform() stands for triggering actions
        action.moveToElement(image1).perform();
        BrowserUtils.wait(3);
//[class='figure']:nth-of-type(1) h5--if you put>h5  (>h5it has child it means direct child)
        //if you :nth-of-type(1) h5 ---if you put space h5 to be able to jump to any child we dont need to put grater

        //h5 is a grand child of .figure:nth-of-type(1) this elemnt that contains image
        WebElement textOfImageElement = driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5"));
        String expectedText = "name: user1";
        String actualText = textOfImageElement.getText();
        Assert.assertEquals(actualText,expectedText);
    }
    @Test
    public void test2(){
        Actions action = new Actions(driver);
        for (int i = 1; i <=3; i++) {
            action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type("+i+") "))).perform();
            BrowserUtils.wait(3);
            String name = driver.findElement(By.cssSelector(".figure:nth-of-type("+i+") h5")).getText();
            System.out.println(name);
            Assert.assertEquals(name,"name: user"+i);

        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

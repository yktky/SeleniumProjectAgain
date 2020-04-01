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

import java.util.Set;

public class SwitchWindow {
    private WebDriver driver;
@BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
    }
    @Test(description = "Verify that title is still Practice")
    public void test1(){
         driver.findElement(By.linkText("New tab")).click();
         // after 4 second, another website will be opened , in the second window
        // selenium doesn t switch automatically to the  new window
        BrowserUtils.wait(4);

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice","Title is wrong");

    }
    @Test(description = "Verify that user is able to see new window")
    public void test2(){
    driver.findElement(By.linkText("New tab")).click();
    //record id original window
    String oldWindow = driver.getWindowHandle();
        // after 4 second, another website will be opened , in the second window
        // selenium doesn t switch automatically to the  new window
    BrowserUtils.wait(4);

    //in the Selenium every window has is. that id calls window handle
        //to read window handle we use method getWindowHandle
        //after new window was opened, we can get list of all window id's/window handle
        //List - it is a Data Structure
        //Set it is also Data Structure, like list, but it doesnt allow duplicates
        //also, you can not easily access anything from there
        // there is no . get()method
        //thats whay, we need to loop through the set, to read a data from there
        //SET STORE ONLY UNIQUE VALUE
        Set<String> windowHandles=driver.getWindowHandles();
        for (String windowHandle : windowHandles){
            //if it is not an old window
            if(!windowHandle.equals(oldWindow)){  // here we are checking
                //switch to that window
                driver.switchTo().window(windowHandle);
            }
        }
        // lets verify that title of new window is a fresh tab
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Fresh tab","Title is wrong");
        //comeback to original page
        //we can build a function, that will jump, in between windows
        //base on page title
          String pageTitle = "Practice";
        for (String windowHandle : windowHandles) {
            //keep jumping from window to window
            driver.switchTo().window(windowHandle);
            //once we found page title of the window that we need
            if(driver.getTitle().equals(pageTitle)){
                //just exit
                //stop jumping
                break;
            }
        }
        System.out.println(driver.getTitle());

    }
    @AfterMethod
    public void tearDown(){
    driver.quit();

    }
}

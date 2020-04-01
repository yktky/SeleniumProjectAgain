package com.automation.tests.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class DropDownSelectClass {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("Dropdown")).click();
    }
    @Test(description = "Select option 2 from the dropdown")
    public void test1(){
        //to work with select dropdowns, we need to use Select class in Selenium
        //step1. find dropdown and create a WebElement
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //step2 Create Select Object
        Select select = new Select(dropdown);
        //to select any option by visible text:
        //Also you can select by value, or index
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        // How to verify that option 2 is selected
        //select.getFirstSelectedOption() - to get selected option/ this is what is selected
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");


    }
    @Test(description = "Print List Of Country")
    public void test2(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        List<WebElement> states = select.getOptions();//will return available option to select
        //how to print every option, as a text , one by one?
        for (WebElement option : states) {
            System.out.println(option.getText());
        }
    }

    @Test(description = "Select your state and verify that state is selected")
    public void test3(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        select.selectByValue("MD");
        BrowserUtils.wait(2);
        // we can use testvalue or index for selection
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Maryland");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

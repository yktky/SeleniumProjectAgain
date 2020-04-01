package com.automation.tests.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class DragandDrop {
    @Test(description = "Drag and Drop example")
    public void test1(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        Actions actions = new Actions(driver);
        driver.findElement(By.linkText("Drag and Drop")).click();
        WebElement moon = driver.findElement(By.id("column-a"));
        WebElement earth = driver.findElement(By.id("column-b"));
        BrowserUtils.wait(3);
        actions.dragAndDrop(moon,earth).perform();
        BrowserUtils.wait(3);
        driver.quit();
    }
}

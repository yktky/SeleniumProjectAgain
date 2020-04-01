package com.automation.tests.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

import java.util.List;

public class warmup {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //how to find all links?
        //every link as a tag name <a>

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("links size : "+links.size());

        //what if I want to all of link prints one by one
        //first typing for loop  if we have any condition put if statement
        // if you dont have any condition onle inside loop ------>System.out.println(each.getText());
        // it give one by one link
        for (WebElement each : links) {
            if(!each.getText().isEmpty()) {

                //print text of every links with getText()
                System.out.println(each.getText());
            }
        }
        System.out.println();

        driver.quit();
    }
}

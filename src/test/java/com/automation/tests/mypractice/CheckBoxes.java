package com.automation.tests.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.List;

public class CheckBoxes {
    private WebDriver driver;
    @BeforeMethod
    public  void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");

        //<a href="/checkboxes">Checkboxes</a>
        driver.findElement(By.linkText("Checkboxes")).click();

    }
    @Test
    public void test1(){
        // find all check boxes
        //anycheckboxes will have [type='checkbox']
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
      int index =1;
        for (WebElement checkbox : checkboxes) {
            if(checkbox.isEnabled() && !checkbox.isSelected()){
                checkbox.click();
                System.out.println("Checkbox cliked:# "+checkbox.getText()+ index);  // no any text I just for pratic use
            }
            else {
                System.out.println("Checkbox was not clicked:# "+checkbox.getText()+index); // pay attention checkbox2 already clicked so you will see in out put is not cliked
            }
            index++;
        }
    }
}

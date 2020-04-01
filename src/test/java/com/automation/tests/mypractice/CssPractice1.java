package com.automation.tests.mypractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

import java.util.List;

public class CssPractice1 {

    public static void main(String[] args)throws Exception {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        for (WebElement button :buttons) {
            button.click();
           Thread.sleep(57);
           WebElement message = driver.findElement(By.cssSelector("#result"));
            System.out.println(message.getText());
        }

        //find element with a tag name h3, that has a parent element, with class name container
      //  WebElement header = driver.findElement(By.cssSelector(".container>h3"));
        //OR
        WebElement header = driver.findElement(By.cssSelector("[class='container']>h3"));
        System.out.println(header.getText());
        WebElement p = driver.findElement(By.cssSelector("[class='container']>p"));
        System.out.println(p.getText());
     driver.quit();

    }
}

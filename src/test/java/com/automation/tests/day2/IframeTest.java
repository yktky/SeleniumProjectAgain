package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTest {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        Thread.sleep(3);

        //before looking for that element, we need to jump to that frame
        //you can specify: name, id, index or webelement of the frame
        //it's like we are jumping to another layer
        driver.switchTo().frame("mce_0_ifr");

        //now, this content will be visible
        WebElement textInput = driver.findElement(By.id("tinymce"));

        System.out.println(textInput.getText());

        Thread.sleep(3);

        textInput.clear();//to delete text
        textInput.sendKeys("Hello, World!");

       Thread.sleep(5);

        //exit from the frame
        driver.switchTo().defaultContent();

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());

        driver.close();
    }

}

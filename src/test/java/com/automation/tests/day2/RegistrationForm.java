package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        Thread.sleep(3);
        // enter first name
        driver.findElement(By.name("firstname")).sendKeys("Yekta");
        driver.findElement(By.name("lastname")).sendKeys("Kindergarden");
        driver.findElement(By.name("username")).sendKeys("coolPrivate");
        driver.findElement(By.name("email")).sendKeys("coool@gmail.com");
        driver.findElement(By.name("password")).sendKeys("superscret");
        driver.findElement(By.name("phone")).sendKeys("571-000-0000");
        List<WebElement> gender = driver.findElements(By.name("gender"));
        gender.get(0).click();
        driver.findElement(By.name("birthday")).sendKeys("01/01/2013");
        driver.findElement(By.id("inlineCheckbox2")).click();
        Thread.sleep(3);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3);
        driver.quit();



    }
}

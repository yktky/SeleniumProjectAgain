package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploding {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        Thread.sleep(3);
        WebElement upload = driver.findElement(By.id("file-upload"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.home");//+"/pom.xml";
        System.out.println(filePath);

        //it work only for my computer because only have this file
        //and my computer username is different than yours
       String file2Path ="C:\\Users\\darak\\Downloads\\day54 class note.txt"; // ask why it give error
//        doesn't work, should be on your computer
//        String cloudFile = " https://cybertek-appium.s3.amazonaws.com/etsy.apk";

        System.out.println(filePath);//print path

        upload.sendKeys(file2Path);
        Thread.sleep(10000);
        driver.findElement(By.id("file-submit")).click();//click to upload


        Thread.sleep(3);
       // driver.quit();

    }
}

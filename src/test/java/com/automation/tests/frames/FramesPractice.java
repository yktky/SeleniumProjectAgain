package com.automation.tests.frames;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class FramesPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }

    @Test(description = "iFrame example")
    public void test1(){
        driver.findElement(By.linkText("iFrame")).click();
        //since element inside a frame, element is not visible for Selenium
        //without switching to the frame
        //we can switch to frame based on id, name, index(starting from 0), web element
        driver.switchTo().frame("mce_0_ifr"); // we need find webelement in iframe
        //without switching we can not see inner html document
        //which one to  use?id, name , index, webelement
        //1.id or name <iframe id = "mce_0_ifr" name = "some_frame">
        //2. webelemnt driver .fidelement(By.ByCssSelector("ifreame[class= 'some_frame']]"));
        //3. index [iframe1,iframe2,ifarme3]
        WebElement inputArea = driver.findElement(By.id("tinymce"));// only this I used it give me
        // NOSuchelementException so I did above switchTometfod
        String expectedText = "Your content goes here.";
        String actualText = inputArea.getText();
        System.out.println(actualText);
        Assert.assertEquals(actualText,expectedText);
   //     BrowserUtils.wait(3);
        inputArea.clear(); // you can delete 
        BrowserUtils.wait(3);
        //to exit from the frame
        driver.switchTo().defaultContent();


    }
    @Test(description = "Nested Frames example")
    public void test2(){

        //it is not switch to frame
        //it is a navigation action
        driver.findElement(By.linkText("Nested Frames")).click();
        WebElement findFrame = driver.findElement(By.cssSelector("[name= 'frame-bottom']"));
        //we switch to frame based on webelement
        driver.switchTo().frame(findFrame); //or directly you can put inside frame(driver.findElement(By.cssSelector("[name= 'frame-bottom']")))
        //the reason why we are switching here
        //is beacuse content that is inside a frame is not visible for selenium
        //it is like when you are on the first floor
        //trying to find what is on the second floor
        WebElement content = driver.findElement(By.tagName("body"));
        System.out.println(content.getText());
        driver.switchTo().defaultContent();//to exit from all frame and come back to original document(go to first floor)
        driver.switchTo().frame("frame-top");//second floor
        driver.switchTo().frame("frame-left");//third floor
        System.out.println(driver.findElement(By.tagName("body")).getText()); //print text
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");//child frame
        WebElement contentMiddle = driver.findElement(By.tagName("body"));
        System.out.println(contentMiddle.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
       // driver.switchTo().frame("frame-middle");
        driver.switchTo().frame("frame-right");
        WebElement contentLeft = driver.findElement(By.tagName("body"));
        System.out.println(contentLeft.getText());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

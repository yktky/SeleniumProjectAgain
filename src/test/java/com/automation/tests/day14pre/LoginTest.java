package com.automation.tests.day14pre;

import com.automation.tests.vytrack.PreviousTestBase;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginTest extends PreviousTestBase {
    @Ignore
    @Test
    public void test1(){
        //read url value from the properties file
        String url = ConfigurationReader.getProperty("url");
        //Driver.getProperty()-->will return webdriver object
        //and then we can call webdriver methods like get(), findElement()......
        //WebDriver driver = new WebDriver() i dont need this
      //  Driver.getDriver().get(url); //pagetitle
        //print page title
        BrowserUtils.wait(2);
        System.out.println(Driver.getDriver().getTitle());
        Driver.closeDriver();
    }
    @Test
    public void test2(){
        System.out.println(Driver.getDriver().getTitle());
        Driver.closeDriver();
    }
}

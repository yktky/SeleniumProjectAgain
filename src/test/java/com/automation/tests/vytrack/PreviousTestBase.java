package com.automation.tests.vytrack;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.Driver;

public abstract class PreviousTestBase {
    //wil be visible in the sub class, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;
    @BeforeMethod
    public void setup(){

        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait=new WebDriverWait(Driver.getDriver(),15);
        actions = new Actions(Driver.getDriver());

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}

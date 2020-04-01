package com.automation.tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

public class DriverTest {
@Test
    public void test(){
    //Driver.getDriver()-----> return driver
    Driver.getDriver().get("https://www.google.com/");
    Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
    BrowserUtils.wait(3);
    Driver.closeDriver();
}

}

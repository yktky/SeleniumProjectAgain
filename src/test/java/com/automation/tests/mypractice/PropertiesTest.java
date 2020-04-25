package com.automation.tests.mypractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class PropertiesTest {


    @Test
    public void test1(){

        //we provide the key of the property to getProperty method
        String browser = ConfigurationReader.getProperty("browser");
        System.out.println(browser);
        //Assert.assertEquals(browser,"firefox");
        Assert.assertEquals(browser,"chrome");
        System.out.println(ConfigurationReader.getProperty("url"));

    }
}

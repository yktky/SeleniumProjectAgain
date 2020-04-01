package com.automation.tests.day14pre;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class ConfigurationReaderTest {
    //ConfigurationReader.getProperty("browser");
    //ConfigurationReader.configFile.getProperty("browser");-->direct access

    @Test
    public void test1(){
        String expectedBrowser="chrome";
        //we are keys in "key" as astring
        //as return, you will get value
        //key= value
        //property name = value
        //we dont change property names, we change values
        //the idea is change in the one place, and affect entire framework
        //lets say every class will read browser type from properties file
        //and to perform cross  browsing testing, we can easily change value of browser property
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,expectedBrowser);
       //read value of url property
        System.out.println(ConfigurationReader.getProperty("url"));
        //read value of user_name property
        System.out.println("Username: "+ConfigurationReader.getProperty("user_name"));
        //read value of password property
        String password = ConfigurationReader.getProperty("password");
        System.out.println("Password: "+password);
    }
}

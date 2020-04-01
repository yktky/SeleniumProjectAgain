package com.automation.tests.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;


public class NewLoginTests extends AbstractTestBase {

    /* Login and verify that page title is a "Dashboard" */
    @Test
    public void verifyPageTitle(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
    }
    /*
    * Enter wrong credentials and verify warning message*/
    @Test
    public void verifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
    }

}

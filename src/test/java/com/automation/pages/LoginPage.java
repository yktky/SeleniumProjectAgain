package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage {
    @FindBy(id ="prependedInput" )
    private WebElement username;//this is reference variable to for username webelement
 // or this---> actually same thing--->   public WebElement username2 = Driver.getDriver().findElement(By.id("prependedInput"));

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;
    @FindBy(linkText = "Forgot your password?")
  private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")  //???why we did
    private WebElement warningMessage;

    public LoginPage(){
        //to connect our webdriver, page class and page factory
        //PageFactory used to use @FindBy annotation
        //PageFactory-helps to find elements easier
        PageFactory.initElements(Driver.getDriver(),this);

    }
    /*Method to login
    @param usernameValue
    @param passwordValue
    * */
    public void  login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }


    /*Method to login, version #2
    * Login as a default user
    * Credentials will be retrieved from configuration.properties file
    *
    * */
    public void login(){//metodOverload
        username.sendKeys(ConfigurationReader.getProperty("user_name")); //user_name is coming from configuration.properties
        password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }
    public String getWarningMessageText(){
        return warningMessage.getText();
    }
}

package com.automation.tests.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.List;

public class WebTables {
    private WebDriver driver;
    private WebDriverWait wait; //explicit

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait=new WebDriverWait(driver, 15);//explicit object
        //wait for presence of table1
        //before finding element use
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
    }
    @Test(description = "print table 1 data")
    public void test1(){
        //table[@id='table1']//thead//tr//th[4]
        //table stands for webTable in HTML
        //table is id of firt table
        //once we find this table as web element, we can print all text from there
        //if you are getting NoSuchElementException
        // i recomended to use this wait, for any elemnt,not only web table


        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println(table1.getText());
    }
    @Test(description = "Verify that number of columns in the first table is equals to 6")
    public void test2(){


        int actualColumnNumber=driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnNumber =6;
        Assert.assertEquals(actualColumnNumber,expectedColumnNumber);

    }
    //to exclude first row--->//table[@id='table1']//tbody//tr
    // "//" means any child, in this case any tr elemnt of table
    @Test(description = "Verify that number of rows is equals to 5")
    public void test3(){
        int expectedRowCount = 5;
        // pay attention findElements
        int actualRowCount = driver.findElements(By.xpath("//table[@id='table1']//tr")).size(); //--->//tr any child
                                                                                       //size
        Assert.assertEquals(actualRowCount,expectedRowCount);
    }
    /*Use findElements() to find all values from 2 nd row
    Then iterate through the collection of elements with for each loop
    Print text of every element from new line
    * */
    @Test(description = "Print all values from the 2nd row(excluding table header)")
    public void test4(){
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]//td"));
        for (WebElement cell : row) {
            System.out.println(cell.getText());
        }
    }
    @Test(description = "Print all values from the n-th row(excluding table header)")
    public void test5(){

      // cssSelector alternative: table[id='table1'] tbody tr:nth-of-type(2) td
        //findElements does not give no such element exception
        int index = 1;
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr["+index+"]//td"));

        for (WebElement cell : row) {
            System.out.println(cell.getText());
        }

    }
    @Test(description = "Verify that email in the third row is equals to jdoe@hotmail.com")
    public void test6(){
        int row = 3;//represent row number
        int column =3;//represents columns number
        //combination of tr and td index will give us specific cell value
        ////table[@id='table1']// tbody//tr[3]//td[3]
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']// tbody//tr["+row+"]//td["+column+"]"));
        String expectedEmail = "jdoe@hotmail.com";
        String actualEmail = cell.getText();
        //System.out.println(actualEmail);
        Assert.assertEquals(actualEmail,expectedEmail);
    }
    /*
    * Get all values from email columns and verify that every value comtains "@"
    * if no- fail test
    * */
    @Test(description = "Verify that every email contains '@'")
    //table[@id='table1']// tbody//tr//td[3]
    public void test7(){
        //get all emails
        //loop through collection of eamils
        //td[3] columns --3
        List<WebElement> emails= driver.findElements(By.xpath("//table[@id='table1']// tbody//tr//td[3]"));
        for (WebElement emil:emails) {
            System.out.println(emil.getText());
            Assert.assertTrue(emil.getText().contains("@"));
        }
    }
    /*
    * Step1. Click on last name --column name
    * Step 2 Get all values from "last name" column
    * Step3. Verify that column is sorted in alphabetic order
    *INTERVIEV Question
    * */
    @Test(description = "Verify that after click on last name, values will be sorted in alphabetic order")
    public void test8(){

        //if result is less then 0, sequence of words is correct or alphabetic
        //if result is 0 ---words are equals
        //if result is positive , sequence of words is opposite to alphabetic
        //it check character by caharecter
        //if 1.st charcter is the same, it compares 2
        String word = "a"; // in ascii table
        String word2 = "d";//100 in ascii table
        //a-d = -3, 97-100
        System.out.println(word.compareTo(word2));
        System.out.println(word.compareTo(word2)<0);
        WebElement lastNameElement= driver.findElement(By.xpath("//table[@id='table1']//th[1]")); //or use //table[@id='table1']//*[text()='Last Name']
        lastNameElement.click();
        List<WebElement> lastNames =driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
//        for (WebElement lastName : lastNames) { //forEachLOOp I can not compare so I will use regular forLoop
//            System.out.println(lastName.getText()); //Verify that column is sorted in alphabetic order ----I can not Verify or compare here
//        }
        for (int i = 0; i < lastNames.size()-1; i++) {
            String lastName = lastNames.get(i).getText();
            String followingLastName = lastNames.get(i + 1).getText();
            System.out.println("#####:: " + i);
            System.out.println("Current last name: " + lastName);
            System.out.println("Foloowing last name: " + followingLastName);
            System.out.println("###########################################");
            Assert.assertTrue(lastName.compareTo(followingLastName) < 0); // How we cheacking ----><or >or == we are checking
            //Verify that column is sorted in alphabetic order
            //IF result is less than 0, sequence of word is correct or alphabetic*********************
            //if result is 0 - words are equals *****************
            //if result is positive, sequence of words is opposite to alphabetic*************************
        }

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}

package com.automation.tests.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class WebTablePractice2 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void table1() {
        ////table[@id='table1']//th
        //table[@id='table1']/thead/tr/th or this one
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        System.out.println("header.size() = " + headers.size());
        for (WebElement eachHead : headers) {

            System.out.println(eachHead.getText());

        }
        //get all column names
        WebElement header2 = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println(header2.getText());


    }

    @Test
    public void pritTableSize() {


        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th")); //th I want jump so I used
        System.out.println("header.size() = " + headers.size());


        //tr also for row you can jump with xpath
        List<WebElement> allRowIncludingHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("numbers of rows including headers: " + allRowIncludingHeader);

        //NUMBER OF ROW WITHOUT HEADERS
        List<WebElement> allRowsExcudingHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsExcudingHeaders.size());

    }

    @Test
    public void getRow() {
        List<WebElement> allRowExcludingHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        System.out.println(allRowExcludingHeader.size());

        //get all the table row dynamicaaly. we can do it in 2 steps
        //1. get the number rows
        //based on the number of rows iterate each row


        for (int i = 1; i < allRowExcludingHeader.size(); i++) {

            String xpath = "//table[@id='table1']/tbody/tr[" + i + "]";
            System.out.println(xpath);
            WebElement singleRow = driver.findElement(By.xpath(xpath));
            System.out.println(singleRow.getText());


        }
    }

    @Test
    public void getAllCellInRow() {
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));
        for (WebElement eachCell : allCellsInOneRow) {
            System.out.println(eachCell.getText());
        }

        System.out.println("number of cells in this row: " + allCellsInOneRow.size());
    }

    @Test
    public void getSingleCellByIndex() {

        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        System.out.println(singleCell.getText());
    }

    @Test
    public void getCellByDynamicIndex(){
      //get number of rows
        int rowNumber = getNumberOfRows();

        //get number of columns
        int colNumber = getNumberOfCols();

        //iterates each row in the table
        for (int i = 1; i <=rowNumber; i++) {

            //iterate each cell in the row
            for (int j = 1; j <= colNumber; j++) {

                //i----> index of tr(row)
                //j----> index of td(cell)
                String xpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                WebElement cell = driver.findElement(By.xpath(xpath));
                System.out.println(cell.getText());

            }
        }
    }

    private int getNumberOfCols(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }
    private int getNumberOfRows(){
        List<WebElement> allRowsExcludingHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsExcludingHeaders.size();
    }

    @Test
    public void getSpecifyCellByIndex(){
        //get cell by given indexes
        int r = 4;  // row number
        int c = 3;  //column number

        String xpath = "//table[@id='table1']/tbody/tr["+r+"]/td["+c+"]";
        WebElement cell = driver.findElement(By.xpath(xpath));
        System.out.println(cell.getText());
    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        //get email of jason
        //email is in the 3.rd column
        String name = "Jason";
        String xpath = "//table[@id='table1']//td[.='"+name+"']/../td[2]";
        System.out.println(driver.findElement(By.xpath(xpath)).getText());

    }

}

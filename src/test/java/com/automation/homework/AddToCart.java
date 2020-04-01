package com.automation.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AddToCart {

    private WebDriver driver = Driver.getDriver();

    @Test
    public void test() {
        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);

        BrowserUtils.wait(3);

        List<WebElement> items = driver.findElements(By.cssSelector("[class='sg-col-inner']"));

        items.removeIf(p -> p.findElements(By.cssSelector("[aria-label='Amazon Prime']")).isEmpty()); // remove all non-prime items

        List<WebElement> prices = items.stream().map(p -> p.findElement(By.cssSelector("[class='a-price'] > [aria-hidden='true']"))).collect(Collectors.toList());
        List<WebElement> descriptions = items.stream().map(p -> p.findElement(By.cssSelector("[class='a-size-base-plus a-color-base a-text-normal']"))).collect(Collectors.toList());


        System.out.println("Number of prices: " + prices.size());
        System.out.println("Number of descriptions: " + descriptions.size());

        Random random = new Random();
        int randomNumber = random.nextInt(descriptions.size());

        prices.removeIf(p -> !p.isDisplayed()); //remove invisible items
        descriptions.removeIf(p -> !p.isDisplayed()); //remove invisible items

        //replace new line with .
        List<String> parsedPrices = BrowserUtils.getTextFromWebElements(prices).parallelStream().map(p -> p.replace("\n", ".")).collect(Collectors.toList());
        List<String> parsedDescriptions = BrowserUtils.getTextFromWebElements(prices);

        parsedDescriptions.removeIf(String::isEmpty);

        String expectedPrice = parsedPrices.get(randomNumber);

        WebElement randomItem = descriptions.get(randomNumber);

        String expectedDescription = randomItem.getText().trim();


        System.out.println("Prices: " + parsedPrices);
        System.out.println("Descriptions: " + BrowserUtils.getTextFromWebElements(descriptions));


        randomItem.click();//click on random item

        WebElement quantity = driver.findElement(By.xpath("//span[text()='Qty:']/following-sibling::span"));

        int actual = Integer.parseInt(quantity.getText().trim());

        Assert.assertEquals(actual, 1);

        WebElement productTitle = driver.findElement(By.id("productTitle"));
        WebElement productPrice = driver.findElement(By.cssSelector("[id='priceInsideBuyBox_feature_div'] > div"));

        String actualDescription = productTitle.getText().trim();
        String actualPrice = productPrice.getText().trim();

        Assert.assertEquals(actualDescription, expectedDescription);
        Assert.assertEquals(actualPrice, expectedPrice);

        driver.quit();
    }

    //close browser if fails
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(Driver::closeDriver));
    }
}

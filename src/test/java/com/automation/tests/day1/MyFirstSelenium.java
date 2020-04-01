package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSelenium {
    //important notes: pom.xml if you need help put also propertybetween group id and build
    // now I didnt put that
   /*   <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>*/



    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(3);
      String title =  driver.getTitle();  //return of the page <title>Some title</title> text
        System.out.println(title);
        driver.quit();
    }
}

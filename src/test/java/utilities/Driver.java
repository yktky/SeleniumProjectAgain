package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //same for everyone
    private static WebDriver driver;
    //so no one can create object of Driver class
    //everyone should call static getter method instead
    //you can not do like this, i constructor is private Driver obj = new Driver()
    private Driver() {
    }

    //if switch statement complains on string parameter
    //change java version to +7, better at least 8to at least 8 or above
    //File---->Project Structure-->Set Project language level
    public static WebDriver getDriver() {
        //if webdriver object doesn't exist
        //create it
        if (driver == null) {
            //specify browser type in configuration.properties file
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    //if browser type wrong, throw exception
                    //no browser will be opned
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


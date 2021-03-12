package utils;

import com.appinternet.base.BasePage;
import utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CustomDriver {

    public static WebDriver driver;
    public static BasePage basePage;

    public WebDriver getDriver() {
        try {
            // read config
            Properties p = new Properties();
            FileInputStream fi = new FileInputStream(System.getProperty("user.dir") +
                    "\\src\\main\\java\\properties\\config.properties");
            p.load(fi);
            String browserName = p.getProperty("browser");

            switch (browserName) {
                case "firefox":
                    if (null == driver) {
                        // setup
                        System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_DIRECTORY);

                    }

                    break;

                case "chrome":

                    if (null == driver) {
                        // setup

                        System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_DIRECTORY);
                        // chrome options
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();

                    }

                    break;

            }

        } catch (Exception e) {
            System.out.println("Unable to load browser: " + e.getMessage());

        } finally {
            driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
            basePage = PageFactory.initElements(driver, BasePage.class);


        }

        return driver;

    }
}

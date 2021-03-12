package steps;


import com.appinternet.base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.CustomDriver;

public class MasterHooks extends CustomDriver {

    @Before
    public void setUp() {
        driver = getDriver();
    }

    @After
    public void tearDownAndScreenshotOnFaliure(Scenario scenario) throws InterruptedException {
        try {

            if(driver!= null && scenario.isFailed()) {
               // scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
                       // "image/png");
                BasePage.captureScreenshot();
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }

            if(driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;

            }
        } catch (Exception e) {
            System.out.println("Method has failed......tearDownAndScreenshotOnFaliure(), Exception"
                    + e.getMessage());
        }
    }




}

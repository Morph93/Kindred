package parallel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import qa.driverFactory.DriverFactory;


public class ApplicationHooks  {


    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static String scenarioName;


    @Before(order = 0)
    public void getProperty() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.init_driver();
    }


    @After(order = 0)
    public void close() {
        driver.quit();
    }


    @After(order = 1)
    public void tearDown(Scenario scenario) {

        //if (scenario.isFailed() && scenario.) { ToDo -> Uncomment if you want scs only on failed
        // take screenshot:

        scenarioName = scenario.getName().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png", scenarioName);
        //}
    }



}

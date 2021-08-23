package pages.chrome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import pages.unibet.HomePage;
import qa.util.FunctionsPage;

import java.util.HashMap;

public class DataSync extends FunctionsPage {
    public DataSync(AppiumDriver<MobileElement> driver) {
        super(driver);
        initMap();
    }

    HashMap<String, By> mapOfPageElements = new HashMap<>();

    private void initMap() {

        mapOfPageElements.put("noTanksButton", By.id("com.android.chrome:id/negative_button"));

    }

    public void clickOnNoThanksButton() {
        driver.findElement(mapOfPageElements.get("noTanksButton")).click();
    }

    public HomePage goToWebPage(String url) {
        driver.findElementsByXPath("//android.widget.Image[@text = 'Google']");
        driver.get(url);

        return new HomePage(driver);
    }
}

package pages.chrome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import qa.util.FunctionsPage;

import java.util.HashMap;

public class TermsOfUse extends FunctionsPage {
    public TermsOfUse(AppiumDriver<MobileElement> driver) {
        super(driver);
        initMap();
    }

    HashMap<String, By> mapOfPageElements = new HashMap<>();

    private void initMap() {

        mapOfPageElements.put("acceptAndContinueButton", By.id("com.android.chrome:id/terms_accept"));

    }

    public DataSync clickOnAcceptAndContinueButton(){
        clickElementBy(mapOfPageElements.get("acceptAndContinueButton"),"acceptAndContinueButton");
        return new DataSync(driver);
    }
}

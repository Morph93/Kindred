package pages.unibet;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import qa.util.FunctionsPage;

import java.util.HashMap;

public class HomePage extends FunctionsPage {


    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initMap();
    }


    HashMap<String, String> mapOfPageElements = new HashMap<>();

    private void initMap() {
        mapOfPageElements.put("continueWithoutSpecialBonusButton","//android.widget.Button[@text = 'Continue Without Special Bonus']");
        mapOfPageElements.put("blogSidebarButton", "//android.view.View[@text = 'Blog']");
    }


    public void closeOverlayIfItAppears() {
        try {
            driver.findElementByXPath(mapOfPageElements.get("continueWithoutSpecialBonusButton")).click();
        } catch (Exception e) {
            System.out.println("No overlay");
        }
    }

    public BlogSidebar openBlogSideBar() {
        clickOnMobileElement(mapOfPageElements.get("blogSidebarButton"),"continueWithoutSpecialBonusButton");

        return new BlogSidebar(driver);
    }
}

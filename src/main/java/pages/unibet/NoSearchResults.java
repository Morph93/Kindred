package pages.unibet;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import qa.util.FunctionsPage;

import java.util.HashMap;

public class NoSearchResults extends FunctionsPage {

    public NoSearchResults(AppiumDriver<MobileElement> driver) {
        super(driver);
        initMap();
    }

    HashMap<String, String> mapOfPageElements = new HashMap<>();

    private void initMap() {

        mapOfPageElements.put("editTextBar", "//android.view.View[2]/android.view.View[1]/android.view.View/android.widget.EditText");
        mapOfPageElements.put("xButtonToRemoveInput", "//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.Image");

    }

    public void inputTextIntoSearchBar(String text) {
        inputText(mapOfPageElements.get("editTextBar"), text, "editTextBar");
    }

    public void checkSuggestionList() {
        for (int i = 1; i < 3; i++) {
            MobileElement element = driver.findElementByXPath("//android.view.View[2]/android.widget.ListView[1]/android.view.View[" + i + "]/android.view.View");
            if (!element.getAttribute("content-desc").contains("basketball")) {
                Assert.fail("The element from suggestion list doesn't contain word from a search bar.");
            }
        }
    }

    public void clickOnXToRemoveInput() {
        clickOnMobileElement(mapOfPageElements.get("xButtonToRemoveInput"), "xButtonToRemoveInput");
    }

    public void checkIfInputHasBeenRemoved() {
        isTextEqual(mapOfPageElements.get("editTextBar"), "", "editTextBar");
    }
}

package pages.unibet;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import qa.util.FunctionsPage;

import java.util.HashMap;

public class RedirectionCheck extends FunctionsPage {

    public RedirectionCheck(AppiumDriver<MobileElement> driver) {
        super(driver);
        initMap();
    }

    HashMap<String, String> mapOfPageElements = new HashMap<>();

    private void initMap() {
        mapOfPageElements.put("titleOfFirstSearchResult", "//android.view.View[3]/android.view.View[1]/android.view.View/android.view.View");
        mapOfPageElements.put("noSearchResults", "//android.view.View[@text = 'No search results']");
        mapOfPageElements.put("numbersResult", "//android.view.View[@text = 'CHELTENHAM']");
    }

    public void checkIfSearchResultContainsExpectedText(String inputType) {
        switch (inputType) {
            case "valid":
                doesElementContainsText(mapOfPageElements.get("titleOfFirstSearchResult"), "TheWineTipster", "titleOfFirstSearchResult");
                break;
            case "no search result":
                doesElementContainsText(mapOfPageElements.get("noSearchResults"), "No search results", "noSearchResults");
                break;
            case "numbers":
                doesElementContainsText(mapOfPageElements.get("numbersResult"), "CHELTENHAM", "numbersResult");
                break;
            case "combinations":
                elementShouldNotExist(mapOfPageElements.get("noSearchResults"), "noSearchResults");
                break;
            default:
                break;
        }
    }
}

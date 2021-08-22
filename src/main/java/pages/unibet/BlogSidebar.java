package pages.unibet;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import qa.util.FunctionsPage;

import java.util.HashMap;

public class BlogSidebar extends FunctionsPage {

    public BlogSidebar(AppiumDriver<MobileElement> driver) {
        super(driver);
        initMap();
    }

    HashMap<String, String> mapOfPageElements = new HashMap<>();

    private void initMap() {
        mapOfPageElements.put("searchBar", "//android.view.View/android.widget.EditText");
    }

    public void fillSearchBar(String inputType) {
        switch (inputType) {
            case "characters":
                inputText(mapOfPageElements.get("searchBar"), "The Wine Tipster", "searchBar");
                break;
            case "special characters":
                inputText(mapOfPageElements.get("searchBar"), "!@#$%", "searchBar");
                break;
            case "numbers":
                inputText(mapOfPageElements.get("searchBar"), "12345", "searchBar");
                break;
            case "combinations":
                inputText(mapOfPageElements.get("searchBar"), "25 York", "searchBar");
                break;
            default:
                break;
        }
    }

    public void checkSearchBar(String expectedString) {
        switch (expectedString) {
            case "characters":
                isTextEqual(mapOfPageElements.get("searchBar"), "The Wine Tipster", "searchBar");
                break;
            case "special characters":
                isTextEqual(mapOfPageElements.get("searchBar"), "!@#$%", "searchBar");
                break;
            case "numbers":
                isTextEqual(mapOfPageElements.get("searchBar"), "12345", "searchBar");
                break;
            case "combinations":
                isTextEqual(mapOfPageElements.get("searchBar"), "25 York", "searchBar");
                break;
            default:
                break;
        }
    }


    public RedirectionCheck fillSearchBarAndConfirmInput(String inputType) {
        switch (inputType) {
            case "valid":
                inputTextAndSubmit(mapOfPageElements.get("searchBar"), "The Wine Tipster", "searchBar");
                break;
            case "no search result":
                inputTextAndSubmit(mapOfPageElements.get("searchBar"), "!@#$%", "searchBar");
                break;
            case "numbers":
                inputTextAndSubmit(mapOfPageElements.get("searchBar"), "12345", "searchBar");
                break;
            case "combinations":
                inputTextAndSubmit(mapOfPageElements.get("searchBar"), "25 York", "searchBar");
                break;
            default:
                break;
        }
        return new RedirectionCheck(driver);
    }
}

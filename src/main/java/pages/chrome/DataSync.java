package pages.chrome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.unibet.HomePage;
import qa.util.FunctionsPage;

import java.util.HashMap;
import java.util.Set;

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
        driver.get(url);

        return new HomePage(driver);
    }

    public void test() {


        driver.findElementByXPath("//android.view.View/android.widget.EditText").sendKeys("Golf");
        String test = driver.findElementByXPath("//android.view.View/android.widget.EditText").getText();

        System.out.println("GLEDAJ OVO: "+ test);

    }
}

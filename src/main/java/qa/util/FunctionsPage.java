package qa.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class FunctionsPage {


    protected AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    public FunctionsPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
    }

    protected void clickOnMobileElement(String locator, String elementName) {
        try {
            MobileElement element = driver.findElementByXPath(locator);
            element.click();
        } catch (Exception e) {
            Assert.fail("Couldn't find " + elementName + " with locator: " + locator);
        }
    }

    protected void inputText(String locator, String text, String elementName) {

        try {
            MobileElement element = driver.findElementByXPath(locator);

            if (element != null) {
                element.sendKeys(text);
            }
        } catch (Exception e) {
            Assert.fail("Couldn't find " + elementName + " with locator: " + locator);
        }
    }

    protected void inputTextAndSubmit(String locator, String text, String elementName) {

        try {
            MobileElement element = driver.findElementByXPath(locator);

            if (element != null) {
                element.click();
                element.sendKeys(text + "\\n");
            }
        } catch (Exception e) {
            Assert.fail("Couldn't find " + elementName + " with locator: " + locator);
        }
    }

    protected void isTextEqual(String locator, String expectedText, String elementName) {
        try {
            MobileElement element = driver.findElementByXPath(locator);
            String actualText = element.getText();
            if (!actualText.equals(expectedText)) {

                Assert.fail("Element:  " + elementName + " actually have text [ " + actualText + " ] but it should have text [ " + expectedText + " ]");
            }
        } catch (Exception e) {
            Assert.fail("Couldn't find " + elementName + " with locator: " + locator);
        }
    }

    protected void doesElementContainsText(String locator, String expectedText, String elementName) {
        try {
            MobileElement element = driver.findElementByXPath(locator);
            String actualText = element.getText();
            if (!actualText.contains(expectedText)) {

                Assert.fail("Element:  " + elementName + " doesn't contain [ " + expectedText + " ] instead it has [ " + actualText + " ]");
            }
        } catch (Exception e) {
            Assert.fail("Couldn't find " + elementName + " with locator: " + locator);
        }
    }

    protected void elementShouldNotExist(String locator, String elementName) {
        List<MobileElement> listOfElements = driver.findElementsByXPath(locator);

        if (!listOfElements.isEmpty()) {
            Assert.fail("The element: " + elementName + " exists, but it shouldn't.");
        }
    }


    protected MobileElement waitIsPresent(By by) {
        return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    protected void waitIsClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    protected void clickElementBy(By by, String elementName) {

        MobileElement element;

        try {
            element = driver.findElement(by);
            try {
                waitIsClickable(by);
                element.click();
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                element = waitIsPresent(by);
                waitIsClickable(by);
                element.click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            Assert.fail("Couldn't find " + elementName + " with locator: " + by);
        }
    }


}

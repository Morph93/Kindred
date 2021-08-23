package parallel.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.chrome.DataSync;
import pages.chrome.TermsOfUse;
import pages.unibet.HomePage;
import pages.unibet.BlogSidebar;
import pages.unibet.NoSearchResults;
import pages.unibet.RedirectionCheck;
import parallel.ApplicationHooks;

public class StepsPage {

    TermsOfUse termsOfUse;
    DataSync dataSync;
    HomePage homePage;
    BlogSidebar blogSidebar;
    RedirectionCheck redirectionCheck;
    NoSearchResults noSearchResults;

    @Given("Accept terms of use")
    public void acceptTermsOfUse() {
        termsOfUse = new TermsOfUse(ApplicationHooks.getDriver());
        dataSync = termsOfUse.clickOnAcceptAndContinueButton();
    }


    @When("Decline data sync")
    public void declineDataSync() {
        dataSync.clickOnNoThanksButton();
    }

    @And("Go to {string}")
    public void goTo(String url) {
        homePage = dataSync.goToWebPage(url);
    }

    @When("Close the overlay if it appears")
    public void closeTheOverlayIfItAppears() {
        homePage.closeOverlayIfItAppears();
    }

    @And("Click on the Blog")
    public void clickOnTheBlog() {
        blogSidebar = homePage.openBlogSideBar();
    }


    @And("Input {string} string into the search bar")
    public void inputStringIntoTheSearchBar(String arg0) {
        blogSidebar.fillSearchBar(arg0);

    }

    @Then("Check if the search bar contains {string} string")
    public void checkIfTheSearchBarContainsString(String arg0) {
        blogSidebar.checkSearchBar(arg0);
    }


    @When("Input {string} string into the search bar and confirm input")
    public void inputStringIntoTheSearchBarAndConfirmInput(String arg0) {
        redirectionCheck = blogSidebar.fillSearchBarAndConfirmInput(arg0);
    }

    @Then("Check redirection for {string} type of input")
    public void checkRedirectionForTypeOfInput(String arg0) {
        redirectionCheck.checkIfSearchResultContainsExpectedText(arg0);
    }


    @And("Type {string} into new search bar on the page")
    public void typeIntoNewSearchBarOnThePage(String arg0) {
        noSearchResults = new NoSearchResults(ApplicationHooks.getDriver());
        noSearchResults.inputTextIntoSearchBar(arg0);
    }


    @Then("Check if autosuggestion works")
    public void checkIfAutosuggestionWorks() {
        noSearchResults.checkSuggestionList();
    }

    @And("Click on X to delete input")
    public void clickOnXToDeleteInput() {
        noSearchResults.clickOnXToRemoveInput();
    }

    @Then("Check if the input has been deleted")
    public void checkIfTheInputHasBeenDeleted() {
        noSearchResults.checkIfInputHasBeenRemoved();
    }
}

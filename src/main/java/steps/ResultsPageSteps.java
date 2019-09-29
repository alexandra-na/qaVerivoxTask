package steps;

import infrastructure.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ResultsPage;

public class ResultsPageSteps extends TestBase {

    private ResultsPage resultsPageObject;

    @After
    public void stopDriver(){
        closeBrowser();
    }

    @Before
    public void startDriver(){
        startBrowser();
        resultsPageObject = new ResultsPage(driver);
    }

    @Then("^he should be able see the Result List page with all the available Tariffs$")
    public void resultListPageIsDisplayed() {
        resultsPageObject.resultsPageIsDisplayed();
        resultsPageObject.firstFifthTariffsAreDisplayed();
    }

    @Given("the User is on the DSL Result List")
    public void theUserIsOnTheDSLResultListFollowScenario() {
        driver.get("https://www.verivox.de/internet-vergleich/internetundtelefon/?Prefix=030&speed=16000");
        try {
            Thread.sleep(5000); //sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("he selects one of the listed Tariffs")
    public void heSelectsOneOfTheListedTariffs() throws InterruptedException {
        resultsPageObject.selectATariff();
    }

    @When("there are more than {int} tariffs available for the provided Vorwahl and bandwidth")
    public void thereAreMoreThanTariffsAvailableForTheProvidedVorwahlAndBandwidth() {
        resultsPageObject.scrollToButton20More();
    }

    @And("the User should see button labeled as {string}")
    public void theUserShouldAButtonLabeledAs() {
        resultsPageObject.verifyButton();
    }

    @Then("the list should be appended with next {int} tariffs and so on until all Tariffs are loaded")
    public void theListShouldBeAppendedWithNextTariffsAndSoOnUntilAllTariffsAreLoaded() {
        resultsPageObject.allElementsAreDisplayed();
    }

    @And("he clicks on this button")
    public void heClicksOnThisButton() throws InterruptedException {
        resultsPageObject.clickButton20More();
    }
}

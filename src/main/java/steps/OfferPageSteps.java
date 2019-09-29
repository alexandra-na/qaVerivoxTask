package steps;

import infrastructure.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.OfferPage;

public class OfferPageSteps extends TestBase {

    private OfferPage offerPageObject;

    @After
    public void stopDriver(){
        closeBrowser();
    }

    @Before
    public void startDriver(){
        startBrowser();
        offerPageObject = new OfferPage(driver);
    }

    @Then("he should be able see the details of the selected Tariff")
    public void heShouldBeAbleSeeTheDetailsOfTheSelectedTariff() {
        offerPageObject.tariffDetailIsDisplayed();
    }

    @And("he should also see a button labeled as {string}")
    public void heShouldAlsoSeeAButtonLabeledAs() {
        offerPageObject.in5minButtonIsDisplayed();
    }
}

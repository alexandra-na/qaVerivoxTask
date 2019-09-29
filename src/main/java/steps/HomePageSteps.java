package steps;

import infrastructure.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps extends TestBase {

    private HomePage homePageObject;

    @After
    public void stopDriver(){
        closeBrowser();
    }

    @Before
    public void startDriver(){
        startBrowser();
        homePageObject = new HomePage(driver);
    }

    @Given("^the User is on www.verivox.de$")
    public void theMainPageIsDisplayed() {
        driver.get("http://www.verivox.de");
        try {
            Thread.sleep(2000); //sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^he is on the DSL calculator$")
    public void theDSLCalculatorIsAccessed() throws Throwable {
        homePageObject.clickDSLButton();
    }

    @When("^he enters prefix/code “Ihre Vorwahl” as 030 with 16 Mbit/s bandwidth selection$")
    public void userEntersAreaCodeAndBandwidth() {
        homePageObject.enterCodeAreaAndBandwidth();
    }

    @When("^clicks on the button labeled as \"JETZT VERGLEICHEN\"$")
    public void clickOnTheButtonCompareTariff() throws Throwable {
        homePageObject.clickCompareNowButton();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import infrastructure.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.WebElementConstant.*;

public class OfferPage extends TestBase {

    public OfferPage(WebDriver driver) {
        TestBase.driver = driver;
        loadPage();
    }

    @FindBy(css = TARIFF_DETAILS_BUTTON_CSS)
    private WebElement tariffDetailsButton = null;

    @FindBy (xpath = IN_5_MIN_BUTTON_XPATH)
    private WebElement in5MinButton = null;

    public void tariffDetailIsDisplayed(){
        tariffDetailsButton.isDisplayed();
        assertTrue(tariffDetailsButton.getText().contains("Tarifdetails"));
    }

    public void in5minButtonIsDisplayed(){
        in5MinButton.isDisplayed();
    }
}

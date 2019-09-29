package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import infrastructure.TestBase;

import static utils.WebElementConstant.*;

public class HomePage extends TestBase {

    public HomePage(WebDriver driver) {
        TestBase.driver = driver;
        loadPage();
    }

    @FindBy(id = DSL_BUTTON_ID)
    private WebElement dslButton = null;

    @FindBy (xpath = AREA_CODE_TEXTBOX_XPATH)
    private WebElement areaCodeTextbox = null;

    @FindBy (xpath = MPS_BUTTON_XPATH)
    private WebElement mbpsButton = null;

    @FindBy (xpath = COMPARE_NOW_BUTTON_XPATH)
    private WebElement compareNowButton = null;

    public void clickDSLButton() throws InterruptedException {
        dslButton.click();
        Thread.sleep(5000);
    }

    public void enterCodeAreaAndBandwidth() {
        areaCodeTextbox.sendKeys("030");
        mbpsButton.isSelected();
    }

    public void clickCompareNowButton() throws InterruptedException {
        compareNowButton.click();
        Thread.sleep(10000);
    }
}
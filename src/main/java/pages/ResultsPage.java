package pages;

import infrastructure.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.*;

public class ResultsPage extends TestBase{

    public ResultsPage(WebDriver driver) {
        TestBase.driver = driver;
        loadPage();
    }

    @FindBy (css = "resultlist-headline")
    private WebElement resultListHeadline = null;

    @FindBy (xpath = "//ul[@class='product-list']/li[1]//div[@class='tariff-name']//strong")
    private WebElement firstTariff = null;

    @FindBy (xpath = "//ul[@class='product-list']/li[2]//div[@class='tariff-name']//strong")
    private WebElement secondTariff = null;

    @FindBy (xpath = "//ul[@class='product-list']/li[3]//div[@class='tariff-name']//strong")
    private WebElement thirdTariff = null;

    @FindBy (xpath = "//ul[@class='product-list']/li[4]//div[@class='tariff-name']//strong")
    private WebElement fourthTariff = null;

    @FindBy (xpath = "//ul[@class='product-list']/li[5]//div[@class='tariff-name']//strong")
    private WebElement fifthTariff = null;

    @FindBy (xpath = "//div[@class='resultlist-position-zero']//div[@class='products-table-full-width result-table']//div[@class='content']//div//div[@class='product-order']//div//div//button[@class='responsive-label-txt resultlist-cta']")
    private WebElement goToTariffButton = null;

    @FindBy (xpath = "//li[19]//div[1]//div[2]//div[1]//div[4]//div[2]//div[1]//button[1]")
    private WebElement lastButton = null;

    @FindBy (xpath = "//p[@class='pagination-area']//button")
    private WebElement moreButton = null;

    @FindBy (xpath = "//ul[@class='product-list']/li[22]")
    private WebElement firstElement = null;

    @FindBy (xpath = "//ul[@class='product-list']/li[41]")
    private WebElement lastElement = null;

    public void resultsPageIsDisplayed() {
        assertEquals(resultListHeadline.getText(), "Ermittelte Internettarife","Displayed page is incorrect!");
    }

    public void firstFifthTariffsAreDisplayed() {
        assertFalse(firstTariff.getText().isEmpty());
        assertFalse(secondTariff.getText().isEmpty());
        assertFalse(thirdTariff.getText().isEmpty());
        assertFalse(fourthTariff.getText().isEmpty());
        assertFalse(fifthTariff.getText().isEmpty());
    }

    public void selectATariff() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, " +
                        "window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
                        "arguments[0].dispatchEvent(evt);",
                goToTariffButton);
        Thread.sleep(2000);
    }

    public void scrollToButton20More() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastButton);
    }

    public void verifyButton() {
        assertTrue(moreButton.getText().contains("weitere laden"));
    }

    public void clickButton20More() throws InterruptedException {
        moreButton.click();
        Thread.sleep(5000);
    }

    public void allElementsAreDisplayed() {
        assertTrue(firstElement.isDisplayed());
        assertTrue(lastElement.isDisplayed());
    }
}

package infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    private static final String platform = ConfigConstants.USED_BROWSER;
    public static WebDriver driver;

    protected WebDriverWait wait;
    protected Actions action;

    public WebDriver getDriver() {
        if (platform.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (platform.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (platform.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
        }

        return driver;
    }

    protected void closeBrowser() {
        driver.quit();
    }

    protected void startBrowser(){
        driver.quit();
    }

    protected void loadPage(){
        PageFactory.initElements(driver, this);
    }
}

package scenarios;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by alexandra.nagy
 */
class PreTests {

    @Test
    void scenario1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.verivox.com");
        try {
            Thread.sleep(2000); //sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement dslButton = driver.findElement(By.id("mps-tab-5"));
        dslButton.click();

        Thread.sleep(5000);

        WebElement areaCodeTextbox = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/main[1]/div[2]/section[1]/div[1]/div[1]/div[6]/form[1]/div[2]/div[1]/input[1]"));
        areaCodeTextbox.sendKeys("030");

        WebElement mbpsButton = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/main[1]/div[2]/section[1]/div[1]/div[1]/div[6]/form[1]/div[2]/div[2]/input[1]"));
        mbpsButton.isSelected();

        WebElement compareNowButton = driver.findElement(By.xpath("//div[@id='mps-tab-box-5']//button[@class='page-button'][contains(text(),'Jetzt vergleichen')]"));
        compareNowButton.click();

        Thread.sleep(10000);

        WebElement resultListHeadline = driver.findElement(By.className("resultlist-headline"));

        if(!resultListHeadline.getText().equals("Ermittelte Internettarife")){
            fail("Displayed page is incorrect!");
        }

        WebElement firstTariff = driver.findElement(By.xpath("//ul[@class='product-list']/li[1]//div[@class='tariff-name']//strong"));

        if(!firstTariff.getText().contains("Red Internet & Phone")){
            fail("Displayed page is incorrect!");
        }

        driver.quit();
    }

    @Test
    void scenario2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.verivox.de/internet-vergleich/internetundtelefon/?Prefix=030&speed=16000");
        try {
            Thread.sleep(2000); //sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);

        WebElement goToTariffButton = driver.findElement(By.xpath("//div[@class='resultlist-position-zero']//div[@class='products-table-full-width result-table']//div[@class='content']//div//div[@class='product-order']//div//div//button[@class='responsive-label-txt resultlist-cta']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", goToTariffButton);

        Thread.sleep(2000);

        WebElement tariffDetailsButton = driver.findElement(By.cssSelector(".tariff-detail"));
        tariffDetailsButton.isDisplayed();
        assertTrue(tariffDetailsButton.getText().contains("Tarifdetails"));

        WebElement minButton = driver.findElement(By.xpath("//div[@class='summary-tariff-content flex']//a[@class='responsive-label-txt offer-page-cta']"));
        minButton.isDisplayed();

        driver.quit();
    }

    @Test
    void scenario3() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.verivox.de/internet-vergleich/internetundtelefon/?Prefix=030&speed=16000");
        try {
            Thread.sleep(2000); //sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);

        WebElement lastButton = driver.findElement(By.xpath("//li[19]//div[1]//div[2]//div[1]//div[4]//div[2]//div[1]//button[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastButton);

        WebElement moreButton = driver.findElement(By.xpath("//p[@class='pagination-area']//button"));
        assertTrue(moreButton.getText().contains("weitere laden"));
        moreButton.click();

        Thread.sleep(3000);

        WebElement the21Element = driver.findElement(By.xpath("//ul[@class='product-list']/li[22]"));
        assertTrue(the21Element.isDisplayed());

        WebElement the40Element = driver.findElement(By.xpath("//ul[@class='product-list']/li[41]"));
        assertTrue(the40Element.isDisplayed());

        driver.quit();
    }
}

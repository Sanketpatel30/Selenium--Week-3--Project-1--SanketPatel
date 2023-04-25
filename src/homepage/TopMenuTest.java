package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

import java.awt.*;
import java.time.Duration;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    // Launch the Chrome Browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String Menu) {
    }

    @Test
    public void verifyPageNavigation() {
        // List<WebElement> topMenuNames =
        selectMenu("Gift Cards");
//                    driver.findElement(By.xpath("//div[@class='header-menu']//li"));
//            for (WebElement names : topMenuNames) {
//                if (names.getText().equalsIgnoreCase(Menu)) {
//                    names.click();
//                    break;
//                }
//            }
    }

    @Test
    public void verifyComputer() {
        selectMenu("Computer");
        verifyElements("Error", "Computers",
                By.xpath("//h1[contains(text),'Computers')]"));
    }

    // @Test
    public void verifyElectronics() {
        selectMenu("Electronics");
        verifyElements("Error", "electronics", By.xpath("//[contains(text(text),'Electronics')]"));
    }

    //@Test
    public void verifyDigitalDownloads() {
        selectMenu("Digital downloads");
        verifyElements("Error", "Digital downloads", By.xpath("//u1{@class='top-menu notmobile']//a[normailze-space()='Digital downloads']"));
    }

    //@Test
    public void verifyApparel() {
        selectMenu("Apparel");
        verifyElements("Error", "Apparel", By.xpath("//h1[contains(text(),'Apparel')]"));
    }

    //@Test
    public void verifyBooks() {
        SelectMenu("Books");
        verifyElements("Error", "Books", By.xpath("//h1[contains(text(),'Books')]"));

    }

    //@Test
    public void verifyJewelry() {
        selectMenu("Jewelry");
        verifyElements("Error", "Jewelry", By.xpath("//h1[contains(text(),'Jewelry')]"));
    }

    // @Test
    public void verifyGiftCards() {
        selectMenu("Gift Cards");
        verifyElements("Error", "Gift Cards", By.xpath("//h1[contains(text(),'Gift Cards')]"));
    }


    public void SelectMenu(String books) {
    }

    public void verifyElements(String error, String computers, By xpath) {
    }

    @After
    public void closeBrowser() {
        driver.quit();

    }

}
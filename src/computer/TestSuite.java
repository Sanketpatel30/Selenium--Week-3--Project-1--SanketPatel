package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static browserfactory.Basetest.driver;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]")).click();
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        // driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]")).click();
        clickOnElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        //driver.findElement(By.xpath("//option[contains(text(),'Name: Z to A')]")).click();
        // Verify that the products are arranged in descending alphabetical order
        List<WebElement> productNames = driver.findElements(By.xpath("//h2[@class='product-name']/a"));
        List<String> productNameStrings = new ArrayList<String>();
        for (WebElement productName : productNames) {
            productNameStrings.add(productName.getText());
        }
        List<String> sortedProductNames = new ArrayList<String>(productNameStrings);
        Collections.sort(sortedProductNames, Collections.reverseOrder());
        Assert.assertEquals(productNameStrings, sortedProductNames);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]")).click();
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        // driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]")).click();
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        //driver.findElement(By.xpath("//option[contains(text(),'Name: A to Z')]")).click();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]")).click();
        Assert.assertEquals("Build your computer page is not displayed", "Build your own computer", getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]")));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(5000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(5000);
        Assert.assertEquals("Wrong price displayed", "$1,475.00", getTextFromElement(By.xpath("//span[@id='price-value-1']")));
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        Assert.assertEquals("Green banner not displayed", "The product has been added to your shopping cart", getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]")));
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Assert.assertEquals("Shopping Cart not displayed", "Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        WebElement element = driver.findElement(By.xpath("//input[@class='qty-input']"));
        element.click();
        element.sendKeys(Keys.CONTROL + "a"); // Select all existing text
        element.sendKeys("2"); // Type in the new text
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        Assert.assertEquals("Total displayed not correct", "$2,950.00", getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")));
        verifyElements("error", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        verifyElements("error", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        verifyElements("error", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]\n"));

    }

    public void verifyElements(String error, String buildYourOwnComputer, By xpath) {
    }

    public void mouseHouver(By xpath) {
    }

    public void sendKeyToElement(By billingNewAddressFirstName, String michael) {
    }

    public void clickOnELement(By xpath) {
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}

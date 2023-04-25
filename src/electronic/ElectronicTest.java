package electronic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utility.Utility;

public class ElectronicTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() throws InterruptedException {
        mouseHover(By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        verifyElements("error", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));
    }

    public void mouseHoverAndClick(By xpath) {
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHover(By.xpath("//li[@class='active']//a[normalize-space()='Electronics']"));
        mouseHoverAndClick(By.xpath("//li[@class='active last']//a[normalize-space()='Cell phones']"));
        verifyElements("error", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        verifyElements("error", "Nokia Lumia 1020", By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        verifyElements("error", "$349.00", By.xpath("//span[contains(text(),'$349.00')]"));
        sendKeyToElement(By.id("product_enteredQuantity_20"), Keys.BACK_SPACE + "2");
        clickOnElement(By.id("add-to-cart-button-20"));
        verifyElements("error", "The product has been added to your shopping cart", By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        clickOnElement(By.xpath("//span[@title='Close']"));
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        verifyElements("error", "(2)", By.xpath("//span[contains(text(),'(2)')]"));
        verifyElements("error", "$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        verifyElements("error", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        verifyElements("error", "Register", By.xpath("//h1[contains(text(),'Register')]"));
        sendTextToElement(By.id("FirstName"), "Sank");
        sendTextToElement(By.id("LastName"), "Patel");
        sendTextToElement(By.id("Email"), "SankPatel1722@gmail.com");
        sendTextToElement(By.id("Password"), "Temp@123");
        sendTextToElement(By.id("ConfirmPassword"), "Temp@123");
        clickOnElement(By.id("register-button"));
        verifyElements("error", "Your registration completed", By.xpath("//div[contains(text(),'Your registration completed')]"));
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendKeyToElement(By.id("BillingNewAddress_City"), "London");
        sendKeyToElement(By.id("BillingNewAddress_Address1"), "123 High Street");
        sendKeyToElement(By.id("BillingNewAddress_ZipPostalCode"), "EC157YN");
        sendKeyToElement(By.id("BillingNewAddress_PhoneNumber"), "1234567");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        clickOnElement(By.id("shippingoption_2"));
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");
        sendTextToElement(By.id("CardholderName"), "Mr Michael Peter");
        sendTextToElement(By.id("CardNumber"), "5356 6548 1418 5420");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "12");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        verifyElements("error", "Payment Method:", By.xpath("//span[contains(text(),'Payment Method:')]"));
        verifyElements("error", "Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        verifyElements("error", "Shipping Method:", By.xpath("//span[contains(text(),'Shipping Method:')]"));
        verifyElements("error", "2nd Day Air", By.xpath("//span[contains(.,'2nd Day Air')]"));
        verifyElements("error", "$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        verifyElements("error", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        verifyElements("error", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        verifyElements("error", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/");

    }

    public void mouseHover(By xpath) {
    }

    public void sendKeyToElement(By billingNewAddressCity, String london) {
    }

    public void verifyElements(String error, String s, By xpath) {
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}

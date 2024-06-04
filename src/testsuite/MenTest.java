package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 5. Write down the following test into ‘MenTest’
 * class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppinCart()
 * * Mouse Hover on Men Menu
 * * Mouse Hover on Bottoms
 * * Click on Pants
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on size
 * 32.
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on colour
 * Black.
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on
 * ‘Add To Cart’ Button.
 * * Verify the text
 * ‘You added Cronus Yoga Pant to your shopping cart.’
 * * Click on ‘shopping cart’ Link into
 * message
 * * Verify the text ‘Shopping Cart.’
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the product size ‘32’
 * * Verify the product colour ‘Black’
 */
public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        //Mouse Hover on Men Menu
        mouseHoverToElement(By.id("ui-id-5"));
        Thread.sleep(2000);

        //Mouse Hover on Bottoms
        mouseHoverToElement(By.id("ui-id-18"));
        Thread.sleep(2000);

        //Click on Pants
        clickOnElement(By.id("ui-id-23"));
        Thread.sleep(2000);

        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverAndClickOnElement(By.xpath("//div[@id='option-label-size-143-item-175']"));
        Thread.sleep(2000);

        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverAndClickOnElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
        Thread.sleep(2000);

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverAndClickOnElement(By.xpath("//button[contains(@title,'Add to Cart')]"));
        Thread.sleep(2000);

        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromTheElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("You added Cronus Yoga Pant to your shopping cart.", expectedText, actualText);
        Thread.sleep(2000);

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Thread.sleep(2000);

        //Verify the text ‘Shopping Cart.’
        String expectedShippingCartText = "Shopping Cart";
        String actualShippingCartText = getTextFromTheElement(By.xpath("//div[@class='page-title-wrapper']"));
        Assert.assertEquals("Shopping Cart", expectedShippingCartText, actualShippingCartText);
        Thread.sleep(2000);

        //Verify the product name ‘Cronus Yoga Pant’
        String expectedProductName = "Cronus Yoga Pant";
        String actualProductName = getTextFromTheElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Cronus Yoga Pant", expectedProductName, actualProductName);
        Thread.sleep(2000);

        //Verify the product size ‘32’
        String expectedTextSize = "32";
        String actualTextSize = getTextFromTheElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("32", expectedTextSize, actualTextSize);
        Thread.sleep(2000);

        //Verify the product colour ‘Black’
        String expectedTextColor = "Black";
        String actualTextColor = getTextFromTheElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Black", expectedTextColor, actualTextColor);
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
